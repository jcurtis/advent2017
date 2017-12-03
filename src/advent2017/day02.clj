(ns advent2017.day02
  (:require [clojure.string :as str]
            [advent2017.utils :refer :all]
            [clojure.math.combinatorics :as combo]))

; part 1

(defn tokenize [line]
  (map parse-int (str/split line #"\s")))

(defn checksum-vec [v]
  (- (apply max v) (apply min v)))

(defn solve1 [input]
  (apply +
    (map checksum-vec
      (map tokenize (str/split-lines input)))))

; part 2

(defn divide [a b]
  (/ (max a b) (min a b)))

(defn divisible? [a b]
  (= 0 (mod (max a b) (min a b))))

(defn find-divisible [v]
  (first (filter #(divisible? (first %) (last %)) (combo/combinations v 2))))

(defn solve2 [input]
  (->> input
    (str/split-lines)
    (map (comp
           #(apply divide %)
           find-divisible
           tokenize))
    (apply +)))
