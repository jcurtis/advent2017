(ns advent2017.day06
  (:require [clojure.string :as str]
            [advent2017.utils :as utils]))

; part 1

(defn tokenize [input]
  (map utils/parse-int (str/split input #"\s")))

(defn max-index [v]
  (utils/index-of (apply max v) v))

(defn reallocate [banks]
  (let [i (max-index banks)
        blocks-at-i (nth banks i)
        zeroed (assoc (vec banks) i 0)
        num-banks (count banks)]
    (loop [index (mod (inc i) num-banks)
           to-distribute blocks-at-i
           new-banks zeroed]
      (if (<= to-distribute 0)
        new-banks
        (recur
         (mod (inc index) num-banks)
         (dec to-distribute)
         (assoc new-banks index (inc (nth new-banks index))))))))

(defn cycles [banks]
  (loop [i 0
         v banks
         history [banks]]
    (let [newV (reallocate v)]
      (if (some #(= newV %) history)
        [i newV history]
        (recur (inc i) newV (conj history newV))))))

(defn solve1 [input]
  (inc (first (cycles (tokenize input)))))

; part 2

(defn solve2 [input]
  (let [[i v history] (cycles (tokenize input))]
    (inc (first (cycles v)))))
