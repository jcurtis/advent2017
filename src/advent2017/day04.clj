(ns advent2017.day04
  (:require [clojure.string :as str]
            [clojure.math.combinatorics :as combo]))

; part 1

(defn tokenize [line]
  (str/split line #"\s"))

(defn combins [line]
  (combo/combinations (tokenize line) 2))

(defn validate [line]
  (not (some
        (fn [[a b]] (= a b))
        (combins line))))

(defn solve1 [input]
  (->> input
       (str/split-lines)
       (map validate)
       (filter true?)
       (count)))

; part 2

(defn anagram? [a b]
  (= (sort a) (sort b)))

(defn validate2 [line]
  (not (some
        (fn [[a b]] (anagram? a b))
        (combins line))))

(defn solve2 [input]
  (->> input
       (str/split-lines)
       (map validate2)
       (filter true?)
       (count)))
