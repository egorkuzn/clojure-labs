(ns lab-2.lab22
  (:require
   [lab-2.lab21 :as lab21]))

(defn delta-fun 
  [f-t step h]
  (
   let [
        a (f-t (* step h))
        b (f-t (* (inc step) h))
   ]
   (lab21/trapezoid-space-no-mem a b h)
  ))

(defn lazy-integral-seq 
  [with-mem f-t h n]
  (get (nth (iterate
        (fn [[result step]]
          [(+ result (lab21/common-delta-no-mem-with-x-zero-no-mem with-mem f-t step h))
           (inc step)])
        [0 0.0])
       n) 0))

(defn lab-22
  "Оптимизировано с помощью бесконечной последовательности частичных решений."
  ([with-mem f-t x] (lab-22 with-mem f-t x 0.05))
  ([with-mem f-t x h] (let [n (quot x h)]
               (lazy-integral-seq with-mem f-t h n))))