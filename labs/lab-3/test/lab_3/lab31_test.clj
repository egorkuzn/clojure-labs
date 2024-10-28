;; (ns lab-3.lab31-test
;;  (:require [clojure.test :refer :all]
;;            [lab-3.lab31 :refer :all]
;;            [lab-3.core-test :refer :all]))

;; (deftest test-parallel-filter
;;   (testing "test parallel filter"
;;     (println "test parallel filter")
;;     (println (lab-31 heavy-even? (range 100) (/ 100 8)))
;;     (println (lab-31 heavy-even? (range 100) (/ 100 8)))
;;     (println (lab-31 heavy-even? (range 100) (/ 100 8)))
;;     (println (time (lab-31 heavy-even? (range 100) (/ 100 8))))
;;     (println (time (->> (filter heavy-even? (range 100)) (doall))))
;;     (println "1")
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 1)))
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 1)))
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 1)))
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 1)))
;;     (println "2")
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 2)))
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 2)))
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 2)))
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 2)))
;;     (println "4")
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 4)))
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 4)))
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 4)))
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 4)))
;;     (println "8")
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 8)))
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 8)))
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 8)))
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 8)))
;;     (println "14")
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 14)))
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 14)))
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 14)))
;;     (time (lab-31 heavy-even? (range 1000) (/ 1000 14)))
;;     (println "non-parallel filter")
;;     (time (->> (filter heavy-even? (range 1000)) (doall)))
;;     (time (->> (filter heavy-even? (range 1000)) (doall)))
;;     (time (->> (filter heavy-even? (range 1000)) (doall)))
;;     (time (->> (filter heavy-even? (range 1000)) (doall)))))
