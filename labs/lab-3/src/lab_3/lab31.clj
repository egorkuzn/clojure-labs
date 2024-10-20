(ns lab-3.lab31
  (:require [clojure.math :as math]))

(defn batch-count
  [coll batch-size]
  (math/round (math/ceil (/ (count coll) batch-size))))

(defn part-of
  [coll i batch-size]
  (take batch-size (drop (* i batch-size) coll))
  )

(defn lab-31
  [pred coll batch-size]
  (let [n (batch-count coll batch-size)]
    (->> (iterate inc 0)
         (take n)
         (map #(future (filter
                        pred
                        (part-of coll % batch-size))))
         (doall)
         (mapcat deref))))
