(ns lab_1.core
  (:require [lab_1.lab11 :as lab11]
            [lab_1.lab12 :as lab12]
            [lab_1.lab13 :as lab13]
            [lab_1.lab14 :as lab14])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (lab14/task-1-4 1 '("a", "b")))
  ;; (println (lab13/lab-1-3-my-map (fn [x] (.concat x "_letter")) '("a", "b", "c")))
  ;; (println (lab13/lab-1-3-my-filter (fn [x] (not= x "a")) '("a" "b" "c")))
  )


