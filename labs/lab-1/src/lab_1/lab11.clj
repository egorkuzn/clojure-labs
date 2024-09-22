(ns lab_1.lab11)

(defn task-1-1-print-pairs-by-fixed
  "Выводит пары с фиксированным начальным значением"
  [fixed other-elements]
  (if (> (count other-elements) 0)
    (let [fixed-first-char (.charAt fixed 0)
          elem (first other-elements)
          elem-first-char (.charAt elem 0)]
      (if (not=  fixed-first-char elem-first-char)
        (cons
         (.concat fixed elem)
         (task-1-1-print-pairs-by-fixed fixed (rest other-elements)))
        (task-1-1-print-pairs-by-fixed fixed (rest other-elements))))
    (list)))

(defn task-1-1-all-alphabet-pairs
  "Создает пары перестановок по входному алфавиту"
  ([alphabet]
   (if (> (count alphabet) 0)
     (concat (task-1-1-print-pairs-by-fixed (first alphabet) alphabet)
             (task-1-1-all-alphabet-pairs (rest alphabet) alphabet))
     (list)))
  ([iterator permutations]
   (if (and (> (count iterator) 0) (> (count permutations) 0))
     (concat (task-1-1-print-pairs-by-fixed (first iterator) permutations)
             (task-1-1-all-alphabet-pairs (rest iterator) permutations))
     (list))))

(defn task-1-1
  " Задан набор (алфавит) символов в виде списка и число n.
Опишите функцию, которая возвращает список всех строк
длины n, состоящих из этих символов и не содержащих
двух одинаковых символов, идущих подряд.

Для решения использовать рекурсию и базовые операции
над константами и списками (str, cons, .concat и т.п.)

Пример: для алфавита (\"а\" \"b \" \"c\") и n=2 результат должен
быть (\"ab\" \"ac\" \"ba\" \"bc\" \"ca\" \"cb\") с точностью до
перестановки."
  ([n, alphabet]
   (cond
     (<= n 0) (list)
     (= n 1) alphabet
     (= n 2) (task-1-1-all-alphabet-pairs alphabet)
     (> n 2) (task-1-1 (- n 3) alphabet (task-1-1-all-alphabet-pairs alphabet))))
  ([n, alphabet, permutations]
   (if (> n 0)
     (task-1-1 (dec n) alphabet (task-1-1-all-alphabet-pairs alphabet permutations))
     (task-1-1-all-alphabet-pairs alphabet permutations))))