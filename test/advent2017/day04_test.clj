(ns advent2017.day04-test
  (:require [expectations.clojure.test :refer :all]
            [advent2017.day04 :refer :all]
            [clojure.java.io :as io]))

(def input (slurp (io/resource "day04")))

; part 1

(defexpect validate-tests
  (expect true (validate "aa bb cc dd ee"))
  (expect false (validate "aa bb cc dd aa"))
  (expect true (validate "aa bb cc dd aaa")))

(let [r (solve1 input)]
  (println "day04 solve1" r)
  (expect 325 r))

; part 2

(defexpect validate2-tests
  (expect true (validate2 "abcde fghij"))
  (expect false (validate2 "abcde xyz ecdab"))
  (expect true (validate2 "a ab abc abd abf abj"))
  (expect true (validate2 "iiii oiii ooii oooi oooo"))
  (expect false (validate2 "oiii ioii iioi iiio")))

(let [r (solve2 input)]
  (println "day04 solve2" r)
  (expect 119 r))
