(ns lab-2.lab22
  (:require
   [lab-2.lab21 :as lab21]))

(defn delta-fun 
  [f-t step h]
  ())

(defn lazy-integral-seq 
  [f-t]
  (iterate 
   (fn [[step result]]
     ([(inc step)
       (+ result (delta-fun f-t step h))])) 
   [0 0]))

(defn lab-22
  "Оптимизировано с помощью бесконечной последовательности частичных решений."
  ([f-t x] (lab-22 f-t x 0.05))
  ([f-t x h] (
              (let [seq (lazy-integral-seq f-t)]
                (fn [x]
                  (nth seq (quot x h))))
   )))

(def fib (map
          first 
          (iterate (fn [[a b]] [b (+' a b)]) 
                   [0 1])))