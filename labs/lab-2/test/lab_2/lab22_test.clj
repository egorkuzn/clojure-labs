(ns lab-2.lab22-test
  (:require [clojure.test :refer :all]
            [lab-2.lab21 :refer :all]
            [lab-2.lab22 :refer :all]))

(deftest test-poly-lazy-mem
  (testing "test poly lazy mem"
    (println "test poly lazy mem")
    (time (lab-22 true polynom-4-degree 1.0))
    (time (lab-22 true polynom-4-degree 1.0))
    (time (lab-22 true polynom-4-degree 1.0))
    (time (lab-22 true polynom-4-degree 1.0))))

(deftest test-poly-lazy-no-mem-10
  (testing "test poly lazy mem"
    (println "test poly lazy mem 10")
    (println (time (lab-22 false polynom-4-degree 10.0)))
    (println (time (lab-22 false polynom-4-degree 20.0)))
    ;; (time (lab-22 false polynom-4-degree 20.0))
    ;; (time (lab-22 false polynom-4-degree 30.0))
    ;; (time (lab-22 false polynom-4-degree 15.0))
    ))

(deftest test-poly-lazy-no-mem
  (testing "test poly lazy no mem"
    (println "test poly lazy no mem")
    (time (lab-22 false polynom-4-degree 1.0))
    (time (lab-22 false polynom-4-degree 1.0))
    (time (lab-22 false polynom-4-degree 1.0))
    (time (lab-22 false polynom-4-degree 1.0))))