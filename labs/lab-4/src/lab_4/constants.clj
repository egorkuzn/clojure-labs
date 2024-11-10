(ns lab-4.constants)

; Константы для определения выражений

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
