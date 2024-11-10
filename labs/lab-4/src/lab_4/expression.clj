(ns lab-4.expression 
  (:require [lab-4.variable :refer :all]
            [lab-4.constants :refer :all]
            [lab-4.util :refer :all]
            [clojure.string :as string]))

; Логические выражения

; Определим заранее, так как одни испоьзуют другие
(defn expr? [expr])
(defn no? [expr])
(defn ||? [expr])
(defn || [expr1 & exprs])
(defn &&? [expr])
(defn && [expr1 & exprs])

(defn ||? [expr]
  (and (= ::|| (first expr)) (every? expr? (args&| expr))))

(defn &&? [expr]
  (and (= ::&& (first expr)) (every? expr? (args&| expr))))

(defn || [expr1 & exprs]
  {:pre [(and (expr? expr1) (every? expr? exprs))]}
  (let [args (filter #(not (False? %)) (cons expr1 exprs))]
    (if (> (count args) 1)
      (cons ::||
            (reduce
             #(concat %1 (if (||? %2)
                           (args&| %2)
                           (list %2)))
             '()
             args))
      (if (= (count args) 1)
        (first args)
        (constant 0)))))

(defn x [colls]
  (if (empty? colls)
    '(())
    (for [a (first colls)
          more (x (rest colls))]
      (cons a more))))

(defn &&-to-|| [exprs]
  "используется свойство транзитивности логического И"
  (apply || (map
             #(if (> (count %) 1) (cons ::&& %) %)
             (x (map
                 #(if (||? %)
                    (args&| %)
                    (list %))
                 exprs)))))

(defn && [expr1 & exprs]
  {:pre [(and (expr? expr1) (every? expr? exprs))]}
  (let [args (filter #(not (True? %)) (cons expr1 exprs))]
    (if
     (> (count args) 1)
      (&&-to-||
       (reduce ;; сборка ВСЕХ-ВСЕХ конъюнкций
        #(concat %1 (if (&&? %2) 
                      (args&| %2) ;; Здесь случай (и А (и Б)) -> (и А Б). Раскрытие скобок
                      (list %2))) ;; А если нет, то уже принадлежало конъюнкции.
        '() ;; Наполнение пустоты
        args))
      (if
       (= (count args) 1)
        (first args)
        (constant 1)))))

(defn no [expr]
  "Отрицание"
  {:pre [(expr? expr)]}
  (cond 
    (True? expr) (constant 0)
    (False? expr) (constant 1)
    (no? expr) (second expr)
    (&&? expr) (apply || (map #(no %) (args&| expr)))
    (||? expr) (apply && (map #(no %) (args&| expr)))
    :else (list ::no expr)))

(defn no? [expr]
  (and (= ::no (first expr)) (every? expr? (args&| expr))))

(defn expr? [expr]
  (and
   (coll? expr)
   (or
    (constant? expr)
    (variable? expr)
    (&&? expr)
    (no? expr)
    (||? expr))))

(defn expression-to-string [expr]
  {:pre [(expr? expr)]}
  (cond
    (or (constant? expr) (variable? expr)) (name (first (args&| expr)))
    (no? expr) (apply str ["~" (first (map expression-to-string (args&| expr)))])
    (&&? expr) (apply str ["(" (string/join " & " (map expression-to-string (args&| expr))) ")"])
    (||? expr) (apply str ["(" (string/join " | " (map expression-to-string (args&| expr))) ")"])
    :else (throw (Exception. "unexpected case"))))

(defn dnf-solver [expr parameter value]
  {:pre [(expr? expr)]}
  {:pre [(variable? parameter)]}
  {:pre [(expr? value)]}
  (cond
    (constant? expr) expr
    (variable? expr) (if (same-variables? expr parameter) value expr)
    (no? expr) (apply no (dnf-solver (second expr) parameter value))
    (&&? expr) (apply && (map #(dnf-solver % parameter value) (args&| expr)))
    (||? expr) (apply || (map #(dnf-solver % parameter value) (args&| expr)))
    :else (throw (Exception. "unexpected case"))))
