(ns lab_1.lab12)

(defn task-1-2-print-pairs-by-fixed
  ([fixed alphabet] (task-1-2-print-pairs-by-fixed fixed alphabet (list)))
  ([fixed alphabet result]
   (if (> (count alphabet) 0)
     (recur fixed
            (rest alphabet)
            (concat
             result
             (let [fixed-first-char (.charAt fixed 0)
                   elem             (first alphabet)
                   elem-first-char  (.charAt elem 0)]
               (if (not=  fixed-first-char elem-first-char)
                 (list (.concat fixed elem))
                 (list)))))
     result)))

(defn task-1-2-all-alphabet-pairs
  "Создает пары перестановок по входному алфавиту"
  ([alphabet] (task-1-2-all-alphabet-pairs alphabet alphabet))
  ([alphabet iterator] (task-1-2-all-alphabet-pairs alphabet iterator (list)))
  ([alphabet iterator result] (if (> (count iterator) 0)
                                (recur
                                 alphabet
                                 (rest iterator)
                                 (concat result
                                         (task-1-2-print-pairs-by-fixed (first iterator) alphabet)))
                                result)))

(defn task-1-2
  " Изменить решение задачи 1.1 таким образом, чтобы все
рекурсивные вызовы были хвостовыми"
  ([n alphabet] (task-1-2 n alphabet alphabet))
  ([n alphabet result] (cond
                         (> n 2) (recur
                                  (dec n)
                                  alphabet
                                  (task-1-2-all-alphabet-pairs result alphabet))
                         (= n 2) (task-1-2-all-alphabet-pairs result alphabet)
                         (= n 1) alphabet
                         (<= 0) (list))))