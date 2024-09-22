(ns lab_1.lab13)

(defn lab-1-3-my-map
  "Реализация map через reduce"
  [f coll] (if (> (count coll) 0)
             (reduce
              (fn [result, x] (concat result (list (f x))))
              (list)
              coll)))

(defn lab-1-3-my-filter
  "Реализация map через reduce"
  [f coll] (if (> (count coll) 0)
             (reduce
              (fn [result, x] (
                               if (f x)
                                (cons x result)
                                result
                                ))
              (list)
              coll)))
