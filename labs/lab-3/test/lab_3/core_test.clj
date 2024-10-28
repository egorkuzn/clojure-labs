(ns lab-3.core-test)

(defn heavy-even?
  [x] (Thread/sleep 10)
  (even? x))