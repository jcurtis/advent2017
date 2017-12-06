(ns advent2017.day05-test
  (:require [advent2017.day05 :refer :all]
            [expectations.clojure.test :refer :all]
            [clojure.java.io :as io]))

(def input (slurp (io/resource "day05")))

; part 1

(def sample "0
3
0
1
-3")

(defexpect solve1-samples
  (expect 5 (solve1 sample)))

(defexpect tokenize-tests
  (expect [0 3 0 1 -3] (tokenize sample)))

(defexpect jump-tests
  (expect [0 [1 3 0 1 -3] 1] (jump 0 [0 3 0 1 -3] 0))
  (expect [1 [2 3 0 1 -3] 2] (jump 0 [1 3 0 1 -3] 1))
  (expect [4 [2 4 0 1 -3] 3] (jump 1 [2 3 0 1 -3] 2))
  (expect [1 [2 4 0 1 -2] 4] (jump 4 [2 4 0 1 -3] 3))
  (expect [5 [2 5 0 1 -2] 5] (jump 1 [2 4 0 1 -2] 4)))

(defexpect escaped?-tests
  (expect false (escaped? 0 [1 3 0 1 -3]))
  (expect false (escaped? 4 [1 3 0 1 -3]))
  (expect true (escaped? 5 [1 3 0 1 -3]))
  (expect true (escaped? 9999 [1 3 0 1 -3])))

(let [r (solve1 input)]
  (println "day05 solve1" r)
  (expect 358131 r))

; part 2

(defexpect solve2-samples
  (expect 10 (solve2 sample)))

(let [r (solve2 input)]
  (println "day05 solve2" r)
  (expect 25558839 r))
