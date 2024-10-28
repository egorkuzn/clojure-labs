(ns lab-4.constants)

; Структуры для определения выражений

(defn constant [val]
  "создание константы"
  {:pre [(or (= 1 val) (= 0 val))]}
  (list ::constant val))

(defn constant? [expr]
  "проверка, константа ли приложение"
  (= (first expr) ::constant))
