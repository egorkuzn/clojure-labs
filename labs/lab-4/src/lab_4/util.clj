(ns lab-4.util)

; Утилитный класс для выражений

(defn args&| [expr]
  (drop 1 expr))