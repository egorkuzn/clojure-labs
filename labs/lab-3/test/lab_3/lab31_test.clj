(ns lab-3.lab31-test
 (:require [clojure.test :refer :all]
           [lab-3.lab31 :refer :all]))

(deftest test-parallel-filter
  (testing "test parallel filter"
    (println "test parallel filter")
    (println (part-of `(1 2 3 4 5 6 7 8) 0 2)) 
    (time (lab-31 even? (range 0 100000) (/ 100000 1)))
    (time (lab-31 even? (range 0 100000) (/ 100000 2)))
    (time (lab-31 even? (range 0 100000) (/ 100000 4)))
    (time (lab-31 even? (range 0 100000) (/ 100000 8)))
    (time (lab-31 even? (range 0 100000) (/ 100000 14)))
    (time (doall (filter even? (range 0 100000))))))
