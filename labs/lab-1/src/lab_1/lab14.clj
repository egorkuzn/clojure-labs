(ns lab_1.lab14)

(defn task-1-4-task-condition
  [word, alphabet-symbol] 
  (let [last-char (.charAt word (- (.length word) 1))
        alphabet-symbol-char (.charAt alphabet-symbol 0)]
    (not= last-char alphabet-symbol-char))
  )

(defn lab-1-4-generator
  [word alphabet]
  (map
   (fn [alphabet-symbol]
     (.concat word alphabet-symbol))
   (filter
    (fn [alphabet-symbol]
      (task-1-4-task-condition word alphabet-symbol))
    alphabet)
   ))

(defn task-1-4
  [n, alphabet]
  (if (> n 0)
      (reduce
     (fn [result index]
       (reduce
        (fn [new-result result-elem]
          (concat
           new-result
           (lab-1-4-generator result-elem alphabet)))
        (list)
        result))
     alphabet
     (range 1 n))
    (list))
  )