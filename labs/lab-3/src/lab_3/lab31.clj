(ns lab-3.lab31)

(defn batch-count
  [coll batch-size]
  (let [n (count coll)]
   (+ (/ n batch-size)
     (if (> (mod n batch-size) 0) 1 0))))

;; (println (time (batch-count (range 0 10000000) (/ 10000000 8))))

(defn part-of
  [coll i batch-size]
  (take batch-size (drop (* i batch-size) coll))
  )

(defn lab-31
  [pred coll batch-size]
  (let [n (batch-count coll batch-size)]
    (->> (iterate inc 0)
         (take n)
         (map #(future (->>
                        (filter
                         pred
                         (part-of coll % batch-size))
                        (doall))))
         (doall)
         (mapcat deref)
         )))
