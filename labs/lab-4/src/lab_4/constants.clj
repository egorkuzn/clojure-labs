(ns lab-4.constants)

; Структуры для определения выражений

(defn constant [val]
  "создание константы"
  {:pre [(or (= 1 val) (= 0 val))]}
  (list ::constant val))

(defn constant? [expr]
  "проверка, константа ли выражение"
  (= (first expr) ::constant))

(defn True? [expr]
  "проверка, истина ли"
  (and (constant? expr) (= (second expr) 1)))

(defn False? [expr]
  "проверка, ложь ли"
  (and (constant? expr) (= (second expr) 0)))

(defn variable [name]
  "создание переменной"
  {:pre [keyword? name]}
  (list ::variable name))

(defn variable? [expr]
  "проверка, переменная ли"
  (= (first expr) ::variable))

(defn variable-value [expr]
  "получение значения переменной"
  (second expr))

(defn same-variables? [v1 v2]
  "сравнение переменных"
  (and 
   (variable? v1)
   (variable? v2)
   (= (second v1) (second v2))
   ))
