(ns lab-2.lab21-test
  (:require [clojure.test :refer :all]
            [lab-2.lab21 :refer :all]))

(deftest a-test
  (testing "First test example"
    (is (= (time (lab-21 (fn [x] x) 1)) 0.5))))