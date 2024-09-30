(ns lab-2.lab21-test
  (:require [clojure.test :refer :all]
            [lab-2.lab21 :refer :all]))

(deftest time-consuming-polynom-4-degree
  (testing "Проверка работы без memoization polynom-4-degree"
    (println "Без мемоизации polynom-4-degree:")
    (reduce
     (fn [expected x] (let [actual (time (lab-21-integral-no-mem polynom-4-degree (+ 11.0 x)))]
                        actual))
     (time (lab-21-integral-no-mem polynom-4-degree 10.0))
     (range 1 10)))
  (testing "Проверка работы memoization polynom-4-degree"
    (println "С мемоизацией polynom-4-degree:")
    (reduce
     (fn [expected x] (let [actual (time (lab-21-integral-mem polynom-4-degree (+ 11.0 x)))]
                        actual))
     (time (lab-21-integral-mem polynom-4-degree 10.0))
     (range 1 10)))
  (testing "Проверка работы memoization V1 polynom-4-degree"
    (println "С мемоизацией V1 polynom-4-degree:")
    (reduce
     (fn [expected x] (let [actual (time (lab-21-integral-mem-v1 polynom-4-degree (+ 11.0 x)))]
                        actual))
     (time (lab-21-integral-mem-v1 polynom-4-degree 10.0))
     (range 1 10))))

(deftest time-consuming-polynom-line
  (testing "Проверка работы без memoization line"
    (println "Без мемоизации: line")
    (reduce
     (fn [expected x] (let [actual (time (lab-21-integral-no-mem line (+ 11.0 x)))]
                        actual))
     (time (lab-21-integral-no-mem line 10.0))
     (range 1 10)))
  (testing "Проверка работы memoization line"
    (println "С мемоизацией line:")
    (reduce
     (fn [expected x] (let [actual (time (lab-21-integral-mem line (+ 11.0 x)))]
                        actual))
     (time (lab-21-integral-mem line 10.0))
     (range 1 10)))
  (testing "Проверка работы memoization V1 line"
    (println "С мемоизацией V1 line:")
    (reduce
     (fn [expected x] (let [actual (time (lab-21-integral-mem-v1 line (+ 11.0 x)))]
                        actual))
     (time (lab-21-integral-mem-v1 line 10.0))
     (range 1 10))))

(deftest time-consuming-const-fun
  (testing "Проверка работы без memoization const-fun"
    (println "Без мемоизации: const-fun")
    (reduce
     (fn [expected x] (let [actual (time (lab-21-integral-no-mem const-fun (+ 11.0 x)))]
                        actual))
     (time (lab-21-integral-no-mem const-fun 10.0))
     (range 1 10)))
  (testing "Проверка работы memoization const-fun"
    (println "С мемоизацией const-fun:")
    (reduce
     (fn [expected x] (let [actual (time (lab-21-integral-mem const-fun (+ 11.0 x)))]
                        actual))
     (time (lab-21-integral-mem const-fun 10.0))
     (range 1 10)))
  (testing "Проверка работы memoization V1 const-fun"
    (println "С мемоизацией V1 const-fun:")
    (reduce
     (fn [expected x] (let [actual (time (lab-21-integral-mem-v1 const-fun (+ 11.0 x)))]
                        actual))
     (time (lab-21-integral-mem-v1 const-fun 10.0))
     (range 1 10))))

(deftest time-consuming-hyperbola
  (testing "Проверка работы без memoization hyperbola"
    (println "Без мемоизации: hyperbola")
    (reduce
     (fn [expected x] (let [actual (time (lab-21-integral-no-mem hyperbola (+ 11.0 x)))]
                        actual))
     (time (lab-21-integral-no-mem hyperbola 10.0))
     (range 1 10)))
  (testing "Проверка работы memoization const-fun"
    (println "С мемоизацией const-fun:")
    (reduce
     (fn [expected x] (let [actual (time (lab-21-integral-mem hyperbola (+ 11.0 x)))]
                        actual))
     (time (lab-21-integral-mem hyperbola 10.0))
     (range 1 10)))
  (testing "Проверка работы memoization V1 const-fun"
    (println "С мемоизацией V1 const-fun:")
    (reduce
     (fn [expected x] (let [actual (time (lab-21-integral-mem-v1 hyperbola (+ 11.0 x)))]
                        actual))
     (time (lab-21-integral-mem-v1 hyperbola 10.0))
     (range 1 10))))

(deftest time-consuming-hyperbola-fixed
  (testing "ФИКСИРОВАНО Проверка работы без memoization hyperbola"
    (println "ФИКСИРОВАНО Без мемоизации: hyperbola")
    (reduce
     (fn [expected x] (let [actual (time (lab-21-integral-no-mem hyperbola 11.0))]
                        actual))
     (time (lab-21-integral-no-mem hyperbola 11.0))
     (range 1 10)))
  (testing "ФИКСИРОВАНО Проверка работы memoization hyperbola"
    (println "ФИКСИРОВАНО С мемоизацией hyperbola:")
    (reduce
     (fn [expected x] (let [actual (time (lab-21-integral-mem hyperbola 11.0))]
                        actual))
     (time (lab-21-integral-mem hyperbola 11.0))
     (range 1 10)))
  (testing "ФИКСИРОВАНО Проверка работы memoization V1 hyperbola"
    (println "ФИКСИРОВАНО С мемоизацией V1 hyperbola:")
    (reduce
     (fn [expected x] (let [actual (time (lab-21-integral-mem-v1 hyperbola 11.0))]
                        actual))
     (time (lab-21-integral-mem-v1 hyperbola 11.0))
     (range 1 10))))


;; (deftest value-result-test
;;   (testing "Проверка значения вычисления интеграла mem"
;;     (is (= (lab-21-integral-mem const-fun 4.0) 4.0)))
;;   (testing "Проверка значения вычисления интеграла mem V1"
;;     (is (= (lab-21-integral-mem-v1 const-fun 4.0) 4.0)))
;;   (testing "Проверка значения вычисления интеграла no mem"
;;     (is (= (lab-21-integral-no-mem const-fun 4.0) 4.0)))
;;   )

;; (deftest calc-in-partioning-dot
;;   (testing "Проверка неопределенного поведения в точке 0 - разрыва гиперболы"
;;     (is (= (lab-21-integral-mem hyperbola 0.1) ##Inf))))

;; (deftest null-test
;;   (testing "Проверка возвращения 0 при входном x == 0"
;;     (is (= (lab-21-integral-mem line 0.0) 0.0))
;;     (is (= (lab-21-integral-mem polynom-4-degree 0.0) 0.0))
;;     (is (= (lab-21-integral-mem hyperbola 0.0) 0.0))))
