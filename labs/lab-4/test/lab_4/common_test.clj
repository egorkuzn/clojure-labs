(ns lab-4.common-test
  (:require [clojure.test :refer :all]
            [lab-4.variable :refer :all]
            [lab-4.constants :refer :all]
            [lab-4.expression :refer :all]))

(deftest test-expression-to-string
  (testing 
   "test-expression-to-string"
    
    (println (expr? (variable :🍓)))
    (println (expr? (&& (variable :🍓) (variable :🫐))))
    (println (expr? (&& (variable :🍓) (variable :🫐))))
    (println (and (expr? (variable :🍓)) (every? expr? (list (variable :🫐)))))
    (println (expression-to-string
              (dnf-solver
               (&& (variable :🍓) (variable :🫐))
               (variable :🫐)
               (|| (variable :🍓) (constant 0)))))
    (println (expression-to-string
              (dnf-solver
               (&& (variable :🍓) (variable :🫐))
               (variable :🫐)
               (constant 1))))
    ))
