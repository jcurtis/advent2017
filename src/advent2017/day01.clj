(ns advent2017.day01
  (:require [clojure.string :as str]
            [advent2017.utils :refer :all]))

; part 1

(defn tokenize
  [input]
  (map parse-int (str/split input #"")))

(defn validate-vector-item
  [i v f]
  (let [val (nth v i)]
    (if (= val (nth v (f i v)))
      val nil)))

(defn next-index [i v]
  (mod (inc i) (count v)))

(defn filter-vector
  [v f]
  (keep-indexed
   (fn [i x]
     (validate-vector-item i v f))
   v))

(defn solve1
  [input]
  (apply + (filter-vector (tokenize input) next-index)))

; part 2

(defn halfway
  [i v]
  (let [size (count v)]
    (mod (+ i (/ size 2)) size)))

(defn solve2
  [input]
  (apply + (filter-vector (tokenize input) halfway)))
