(ns advent2017.day08-test
  (:require [clojure.string :as str]
            [expectations.clojure.test :refer :all]
            [advent2017.day08 :refer :all]
            [clojure.java.io :as io]))
; part 1

(def sample "b inc 5 if a > 1
a inc 1 if b < 5
c dec -10 if a >= 1
c inc -20 if c == 10")

(def split-sample (str/split-lines sample))

(def input (slurp (io/resource "day08")))
(def split-input (str/split-lines input))

(defexpect readline-tests
  (expect [:b + 5 :a > 1] (readline "b inc 5 if a > 1"))
  (expect [:c + -20 :c = 10] (readline "c inc -20 if c == 10")))

(defexpect getreg-tests
  (expect 0 (getreg :c {}))
  (expect 1 (getreg :c {:c 1}))
  (expect 0 (getreg :d {:c 1})))

(defexpect process-step-tests
  (expect {} (process-step {} (readline (first split-sample))))
  (expect {:a 1} (process-step {} (readline (second split-sample))))
  (expect {:a 1 :c 10} (process-step {:a 1} (readline (nth split-sample 2))))
  (expect {:a 1 :c -10} (process-step {:a 1 :c 10} (readline (nth split-sample 3)))))

(defexpect process-tests
  (expect {:a 1 :c -10} (process (map readline split-sample))))
  ; (println (process (map readline split-input))))

(defexpect solve1-tests
  (expect 1 (solve1 split-sample))
  (let [r (solve1 split-input)]
    (println "day08 solve1" r)
    (expect 4066 r)))

; part 2
(defexpect solve2-tests
  (println "day08 solve2" (solve2)))
