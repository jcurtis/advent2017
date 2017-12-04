(ns advent2017.day03-test
  (:require [advent2017.day03 :refer :all]
            [expectations.clojure.test :refer :all]))

; part 1

(defexpect solve1samples
  ; (expect 0 (solve1 1))
  (expect 3 (solve1 12))
  (expect 2 (solve1 23))
  (expect 31 (solve1 1024)))

(defexpect spiral-layers-test
  (expect [0 1 1] (nth spiral-layers 0))
  (expect [1 3 9] (nth spiral-layers 1))
  (expect [2 5 25] (nth spiral-layers 2)))

(defexpect find-layer-of-tests
  (expect 0 (first (find-layer-of 1)))
  (expect 1 (first (find-layer-of 3)))
  (expect 2 (first (find-layer-of 25)))
  (expect 3 (first (find-layer-of 26))))

(defexpect find-position-in-layer-tests
  ; (expect 0 (find-position-in-layer 1))
  (expect 0 (find-position-in-layer (find-layer-of 2) 2))
  (expect 1 (find-position-in-layer (find-layer-of 3) 3))
  (expect 7 (find-position-in-layer (find-layer-of 9) 9)))

(let [r (solve1 347991)]
  (println "day03 solve1" r)
  (expect 480 r))

; part 2

(defexpect spiral-expo-tests
  (expect [1 1 2 4 5 10 11 23 25 26 54 57 59 122 133 142 147 304 330 351 362 747 806]
    (take 23 (spiral-expo))))
