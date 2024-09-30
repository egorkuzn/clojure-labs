(ns lab-2.lab21)

(defn trapezoid-space-no-mem
  [a b h]
  (* (/ (+ a b) 2.0) h))

(def trapezoid-space-mem (memoize trapezoid-space-no-mem))

(defn delta-no-mem
  [is-mem f-t x-zero h]
  ((if is-mem
     trapezoid-space-mem
     trapezoid-space-no-mem)
   (f-t x-zero)
   (f-t (+ x-zero h))
   h)
  )

(def delta-mem (memoize delta-no-mem))

(defn x-zero-calc-no-mem 
  [step-number h]
  (* step-number h))

(def x-zero-calc-mem (memoize x-zero-calc-no-mem))

(defn x-zero-calc
  [is-mem step-number h] 
  ((if false
     x-zero-calc-mem
     x-zero-calc-no-mem) step-number h))

(defn common-delta-no-mem-with-x-zero-no-mem
  [is-mem f-t step-number h]
  (let [x-zero (x-zero-calc is-mem step-number h)]
    ( if (>= step-number 0)
     ((if false
       delta-mem
       delta-no-mem) is-mem f-t x-zero h)
     0.0)))

(def common-delta-no-mem-with-x-zero-mem
  (memoize common-delta-no-mem-with-x-zero-no-mem))
  

;; (defn lab-21-integral-mem
;;   "`lab-21-integral` оптимизирована с помощью мемоизации."
;;   ([f-t x]
;;    (lab-21-integral true f-t x))
;;   ([f-t x h]
;;    (lab-21-integral true f-t x h)))

(defn lab-21-integral
  "Оператор, принимающий функцию `f-t` от одной переменной
     `x`:
     **![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXeQeoke3_ONP5ofscgW6IrlyyhmaH9vVnlPJi_aedCHVFoVOzH1yx-oaPQ6QJCkLg_2eQLfhKaZysPP1yRTVZ4vKiUTwcKEC2hC8_tNQKj8FcjuCIY7WG8go0Mh9MSjnX4fsIWKVQMGXoOriPCPTtu8Ou2n?key=MOzn1_bKZhqJBtZnSjyAyg)**
     
     Степень точности задается `h` - шаг интегрирования. По умолчанию берём 0.05." 
  ([is-mem f-t x]
   (if (> x 0.0)
     (lab-21-integral is-mem f-t x 0.05 0.0)
     0.0))
  ([is-mem f-t x h result] 
   (if (> x 0.0)
     (let [n (quot x h)]
       (recur
        is-mem
        f-t
        (- x h)
        h
        (+ result
           ((if is-mem
              common-delta-no-mem-with-x-zero-mem
              common-delta-no-mem-with-x-zero-no-mem) is-mem f-t n h))))
     result)))

(defn polynom-4-degree [x] (* x (* x (* x (* x)))))
(defn line [x] x)
(defn hyperbola [x] (/ 1.0 x))
(defn const-fun [x] 1.0)  

(def lab-21-integral-mem-base 
  (memoize (fn [f-t x h] 
             (if (>= x h)
               (let [n (quot x h)]
                 (+ (lab-21-integral-mem-base f-t (- x h) h) 
                    (common-delta-no-mem-with-x-zero-mem true f-t n h)))
               0.0))))

(defn lab-21-integral-mem
  "`lab-21-integral` оптимизирована с помощью мемоизации."
  ([f-t x]
   (lab-21-integral-mem f-t x 0.05))
  ([f-t x h]
   (lab-21-integral-mem-base f-t x h)))

(defn lab-21-integral-no-mem
  " `lab-21-integral`, которая вычисляет без мемоизации. "
  ([f-t x]
   (lab-21-integral false f-t x))
  ([f-t x h]
   (lab-21-integral false f-t x h)))

(defn lab-21-integral-mem-v1
  ([f-t x]
   (lab-21-integral-mem-v1 f-t x 0.05))
  ([f-t x h] (if (> x 0.0)
               (let [n (quot x h)]
                 (reduce
                  (fn [result step] (+ result (common-delta-no-mem-with-x-zero-mem false f-t step h)))
                  0.0
                  (reverse (range 0 n))))
               0.0)))
  