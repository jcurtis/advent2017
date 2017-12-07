(ns advent2017.day06-test
  (:require [advent2017.day06 :refer :all]
            [expectations.clojure.test :refer :all]))

(def sample "0 2 7 0")
(def input "0	5	10	0	11	14	13	4	11	8	8	7	1	4	12	11")

; 0 5 10 0 11 14 13 4 11 8 8 7 1 4 12 11
; 1 6 11 1 11 0 14 5 12 9 9 8 2 5 13 12

; part 1

(defexpect tokenize-tests
  (expect [0 2 7 0] (tokenize sample))
  (expect [0 5 10 0 11 14 13 4 11 8 8 7 1 4 12 11] (tokenize input)))

(defexpect max-index-tests
  (expect 2 (max-index [0 2 7 0])))

(defexpect reallocate-tests
  (expect [2 4 1 2] (reallocate [0 2 7 0]))
  (expect [3 1 2 3] (reallocate [2 4 1 2]))
  (expect [0 2 3 4] (reallocate [3 1 2 3]))
  (expect [1 3 4 1] (reallocate [0 2 3 4]))
  (expect [2 4 1 2] (reallocate [1 3 4 1])))

(defexpect solve1-tests
  (expect 5 (solve1 sample))
  (let [r (solve1 input)]
    (println "day06 solve1" r)
    (expect 7864 r)))

; part 2

(defexpect solve2-tests
  (expect 4 (solve2 sample))
  (let [r (solve2 input)]
    (println "day06 solve2" r)
    (expect 1695 r)))
