(ns advent2017.day02-test
  (:require [expectations.clojure.test :refer :all]
            [advent2017.day02 :refer :all]
            [clojure.java.io :as io]))

(def input (slurp (io/resource "day02"))) 0

; part 1

(def sample1 "5 1 9 5
7 5 3
2 4 6 8")

(defexpect solve1sample
  (expect 18 (solve1 sample1)))

(defexpect tokenize-tests
  (expect [1 2 3] (tokenize "1 2 3")))

(defexpect checksum-vec-tests
  (expect 8 (checksum-vec [5 1 9 5]))
  (expect 4 (checksum-vec [7 5 3]))
  (expect 6 (checksum-vec [2 4 6 8])))

(let [r (solve1 input)]
  (println "day02 solve1" r)
  (expect 42299 r))

; part 2

(def sample2 "5 9 2 8
9 4 7 3
3 8 6 5")

(defexpect solve2sample
  (expect 9 (solve2 sample2)))

(defexpect divisible?-tests
  (expect (divisible? 8 2))
  (expect (divisible? 2 8))
  (expect (divisible? 9 3))
  (expect (not (divisible? 9 2)))
  (expect (not (divisible? 2 9))))

(defexpect find-divisible-tests
  (expect [2 8] (find-divisible [5 9 2 8]))
  (expect [9 3] (find-divisible [9 4 7 3]))
  (expect [3 6] (find-divisible [3 8 6 5])))

(let [r (solve2 input)]
  (println "day02 solve2" r)
  (expect 277 r))
