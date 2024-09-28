(ns lab-2.lab21)

(defn lab-21-trapezoid-space
  [a b h]
  (* (/ (+ a b) 2.0) h))

(defn lab-21-integral
  "Оператор, принимающий функцию `f-t` от одной переменной
     `x`:
     **![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXeQeoke3_ONP5ofscgW6IrlyyhmaH9vVnlPJi_aedCHVFoVOzH1yx-oaPQ6QJCkLg_2eQLfhKaZysPP1yRTVZ4vKiUTwcKEC2hC8_tNQKj8FcjuCIY7WG8go0Mh9MSjnX4fsIWKVQMGXoOriPCPTtu8Ou2n?key=MOzn1_bKZhqJBtZnSjyAyg)**
     
     Степень точности задается `h` - шаг интегрирования. По умолчанию берём 0.05."
  ([trapezoid-space-fun f-t x]
   (lab-21-integral trapezoid-space-fun f-t x 0.05))
  ([trapezoid-space-fun f-t x h] 
   (
    reduce
    (fn [result step-number]
      (let [
            x-zero (* step-number h)
      ] (+ result (trapezoid-space-fun
                   (f-t x-zero)
                   (f-t (+ x-zero h))
                   h))))
    0.0
    (range 0 (quot x h))
   )))  
  

(def lab-21-integral-mem
  "`lab-21-integral` оптимизирована с помощью мемоизации."
  (memoize (fn ([f-t x]
                (lab-21-integral lab-21-trapezoid-space f-t x))
             ([f-t x h]
              (lab-21-integral lab-21-trapezoid-space f-t x h)))))

(defn lab-21-integral-no-mem
  " `lab-21-integral`, которая вычисляет без мемоизации. "
  ([f-t x]
   (lab-21-integral lab-21-trapezoid-space f-t x))
  ([f-t x h]
   (lab-21-integral lab-21-trapezoid-space f-t x h)))



