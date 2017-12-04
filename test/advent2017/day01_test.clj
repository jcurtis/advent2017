(ns advent2017.day01-test
  (:require [expectations.clojure.test :refer :all]
            [advent2017.day01 :refer :all]
            [clojure.java.io :as io]
            [clojure.string :as str]))

(def input ((str/split-lines (slurp (io/resource "day01"))) 0))

; part 1

(defexpect solve1samples
  (expect 3 (solve1 "1122"))
  (expect 4 (solve1 "1111"))
  (expect 0 (solve1 "1234"))
  (expect 9 (solve1 "91212129")))

(defexpect tokenize-tests
  (expect [1 1 2 2] (tokenize "1122"))
  (expect [1 1 1 1] (tokenize "1111"))
  (expect [1 2 3 4] (tokenize "1234"))
  (expect [9 1 2 1 2 1 2 9] (tokenize "91212129")))

(defexpect validate-vector-item-tests
  (expect 1 (validate-vector-item 0 [1 1] next-index))
  (expect 1 (validate-vector-item 1 [1 1] next-index))
  (expect nil (validate-vector-item 0 [1 2] next-index))
  (expect nil (validate-vector-item 1 [1 2] next-index))
  (expect 1 (validate-vector-item 0 [1 1 2 2] next-index))
  (expect nil (validate-vector-item 1 [1 1 2 2] next-index))
  (expect 2 (validate-vector-item 2 [1 1 2 2] next-index))
  (expect nil (validate-vector-item 3 [1 1 2 2] next-index))
  (expect 9 (validate-vector-item 7 [9 1 2 1 2 1 2 9] next-index)))

(defexpect filter-vector-tests
  (expect [1 2] (filter-vector [1 1 2 2] next-index))
  (expect [1 1 1 1] (filter-vector [1 1 1 1] next-index))
  (expect [] (filter-vector [1 2 3 4] next-index)))

(let [r (solve1 input)]
  (println "day01 solve1" r)
  (expect 1069 r))

; part 2

(defexpect halfway-tests
  (expect 5 (halfway 0 [1 2 3 4 5 6 7 8 9 10]))
  (expect 0 (halfway 5 [1 2 3 4 5 6 7 8 9 10]))
  (expect 2 (halfway 7 [1 2 3 4 5 6 7 8 9 10]))
  (expect 2 (halfway 0 [1 2 3 4]))
  (expect 2 (halfway 4 [1 2 3 4])))

(defexpect solve2samples
  (expect 6 (solve2 "1212"))
  (expect 0 (solve2 "1221"))
  (expect 4 (solve2 "123425"))
  (expect 12 (solve2 "123123"))
  (expect 4 (solve2 "12131415")))

(let [r (solve2 input)]
  (println "day01 solve2" r)
  (expect 1268 r))
