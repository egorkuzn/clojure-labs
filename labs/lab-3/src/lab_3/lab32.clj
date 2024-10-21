(ns lab-3.lab32
  (:require [lab-3.lab31 :refer :all]))

(defn lab-32
  [pred coll batch-size]
  (lazy-cat (lab-31 pred (take batch-size coll) batch-size)
            (if (empty? coll)
              coll
              (lab-32 pred (drop batch-size coll) batch-size))
            ))