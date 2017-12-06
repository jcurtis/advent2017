(ns advent2017.day05
  (:require [clojure.string :as str]
            [advent2017.utils :as utils]))

; part 1
(defn tokenize [input]
  (-> input
    (str/split #"\n")
    (->> (map utils/parse-int))))

(defn jump
  [i ins step]
  (let [offset (nth ins i)]
    [(+ i offset) (assoc ins i (inc offset)) (inc step)]))

(defn escaped? [i ins]
  (>= i (count ins)))

(defn solve [input jumpf]
  (loop [i 0
         ins (vec (tokenize input))
         step 0]
        (if (escaped? i ins)
          step
          (let [[idx v s] (jumpf i ins step)]
            (recur idx v s)))))

(defn solve1 [input]
  (solve input jump))

; part 2

(defn jump2 [i ins step]
  (let [offset (nth ins i)
        offset_bal (if (>= offset 3) (dec offset) (inc offset))]
      [(+ i offset) (assoc ins i offset_bal) (inc step)]))

(defn solve2 [input]
  (solve input jump2))
