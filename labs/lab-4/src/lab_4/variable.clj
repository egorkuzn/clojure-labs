(ns lab-4.variable)

; Переменные для определения выражений

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
   (= (second v1) (second v2))))
