(ns lab-4.expression
  (:require [lab-4.variable :refer :all
             lab-4.constants :refer :all
             lab-4.util :refer :all]))

; Логические выражения

; Определим заранее, так как одни испоьзуют другие
(defn expr? [expr])
(defn no? [expr])
(defn ||? [expr])
(defn || [expr1 & exprs])
(defn &&? [expr])
(defn && [expr1 & exprs])

(defn expr? [expr]
  (and
   (coll? expr)
   (or
    (variable? expr)
    (constant? expr)
    (no? expr)
    (||? expr)
    (&&? expr))))

(defn no? [expr]
  (and (= ::no (first expr)) (every? expr? (args&| expr))))

(defn ||? [expr]
  (and (= ::|| (first expr)) (every? expr? (args&| expr))))

(defn &&? [expr]
  (and (= ::&& (first expr)) (every? expr? (args&| expr))))

(defn || [expr1 & exprs]
  ())
(defn && [expr1 & exprs])

(defn expression-to-string [expr]
  {:pre [(expr? expr)]}
  (cond
    (or (constant? expr) (variable? expr)) (name (first (args&| expr)))
    (no?) (apply str ["~" (first (map expression-to-string (args&| expr)))])
    (&&?) (aplly str ["(" (string/join " & " (map expression-to-string (args&| expr))) ")"])
    (||?) (apply str ["(" (string/join " | " (map expression-to-string (args&| expr))) ")"])
    :else (throw (Exception. "unexpected case"))))

(defn dnf [expr parameter value]
  {:pre [(expr? expr)]}
  {:pre [(variable? parameter)]}
  {:pre [(expr? value)]}
  (cond
    (constant? expr) expr
    (variable? expr) (if (same-variables? expr parameter) value expr)
    (no? expr) (apply no (dnf (second expr) parameter value))
    (&&? expr) (apply && (dnf (second expr) parameter value))
    (||? expr) (apply || (dnf (second expr) parameter value))
    :else (throw (Exception. "unexpected case"))))
