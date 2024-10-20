(ns lab-3.lab31
  (:require [clojure.math :as math]))

(defn heavy-inc [n]
  (Thread/sleep 100)
  (inc n))

(defn lab-31-parallel-map
  []
  (time (->> (iterate inc 0)
             (take 10)
             (map #(future (heavy-inc %)))
             (doall)
             (map deref)
             (doall)))
  )

(lab-31-parallel-map)

(defn batch-count
  [coll batch-size]
  (math/round (math/ceil (/ (count coll) batch-size))))

(defn part-of
  [coll i batch-size]
  (take i (drop (* i batch-size) coll))
  )

(defn lab-31
  [pred coll batch-size]
  (let
   [n (batch-count coll batch-size)]
   (time (->> (
              (iterate inc 0)
              (take n)
              (map #(future (
                         filter
                         pred
                         (part-of coll % batch-size)
              )))
               (doall)
               (map deref)
               (doall)
              )
         
  ))))
