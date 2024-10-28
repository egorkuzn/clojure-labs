(ns lab-3.lab32
  (:require [lab-3.lab31 :refer :all]))

;; (defn lab-32
;;   [pred coll batch-size]
;;   (lazy-cat (lab-31 pred (take batch-size coll) 10)
;;             (if (empty? coll)
;;               coll
;;               (lab-32 pred (drop batch-size coll) batch-size))))

(defn future-fn
  [pred coll i batch-size]
  (future (->>
           (filter
            pred
            (part-of coll i batch-size))
           (doall))))

(defn lab-32
  [pred coll batch-size]
  (->> (iterate inc 0)
       (map #(future-fn pred coll % batch-size))
       (take (batch-count coll batch-size))
       (doall)
       (mapcat deref))
  )
