(ns lab-2.lab21-test
  (:require [clojure.test :refer :all]
            [lab-2.lab21 :refer :all]))

(deftest time-consuming-test-no-mem
  (testing "Проверка работы без memoization"
    (println "Без мемоизации:")
    (reduce
     (fn [expected x] (let [actual (time (lab-21-integral-no-mem polynom-4-degree (+ 10.0 x)))] 
                        actual))
     (time (lab-21-integral-no-mem const-fun 10.0))
     (range 1 20))))

(deftest time-consuming-test-mem
  (testing "Проверка работы memoization"
    (println "С мемоизацией:")
    (reduce
     (fn [expected x] (let [actual (time (lab-21-integral-mem polynom-4-degree (+ 10.0 x) 0.1))] 
                        actual))
     (time (lab-21-integral-mem const-fun 10.0))
     (range 1 20))))


;; (deftest value-result-test
;;   (testing "Проверка значения вычисления интеграла"
;;     (is (= (lab-21-integral-mem line 9.0) 40.5))))

;; (deftest calc-in-partioning-dot
;;   (testing "Проверка неопределенного поведения в точке 0 - разрыва гиперболы"
;;     (is (= (lab-21-integral-mem hyperbola 0.1) ##Inf))))

;; (deftest null-test
;;   (testing "Проверка возвращения 0 при входном x == 0"
;;     (is (= (lab-21-integral-mem line 0.0) 0.0))
;;     (is (= (lab-21-integral-mem polynom-4-degree 0.0) 0.0))
;;     (is (= (lab-21-integral-mem hyperbola 0.0) 0.0))))
