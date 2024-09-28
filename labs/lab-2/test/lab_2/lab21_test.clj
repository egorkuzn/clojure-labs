(ns lab-2.lab21-test
  (:require [clojure.test :refer :all]
            [lab-2.lab21 :refer :all]))

(defn polynom-4-degree [x] (* x (* x (* x (* x)))))
(defn line [x] x)
(defn hyperbola [x] (/ 1.0 x))

(deftest time-consuming-test
  (testing "Проверка работы memoization"
    (reduce
     (fn [expected _] (
                       let [actual (time (lab-21-integral-mem polynom-4-degree 90.0))]
                        (is (= expected actual))
                        actual
                        ))
     (time (lab-21-integral-mem polynom-4-degree 90.0))
     (range 0 10))))


(deftest value-result-test
  (testing "Проверка значения вычисления интеграла"
    (is (= (lab-21-integral-mem line 9.0) 40.5))))

(deftest calc-in-partioning-dot
  (testing "Проверка неопределенного поведения в точке 0 - разрыва гиперболы"
    (is (= (lab-21-integral-mem hyperbola 0.1) ##Inf))))

(deftest null-test
  (testing "Проверка возвращения 0 при входном x == 0"
    (is (= (lab-21-integral-mem line 0.0) 0.0))
    (is (= (lab-21-integral-mem polynom-4-degree 0.0) 0.0))
    (is (= (lab-21-integral-mem hyperbola 0.0) 0.0))))