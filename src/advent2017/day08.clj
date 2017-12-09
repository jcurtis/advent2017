(ns advent2017.day08
  (:require [clojure.string :as str]
            [advent2017.utils :as utils]))

; part 1

; b     inc   5     if  a     >           1
; reg1  incr  val1  if  reg2  condition   val2

(defn parse-func [s]
  (case s
    "inc" +
    "dec" -
    ">" >
    "<" <
    "<=" <=
    ">=" >=
    "==" =
    "!=" not=))

(defn readline [s]
  (let [[reg1 increment val1 _ reg2 condition val2] (str/split s #"\s")]
      [(keyword reg1)
       (parse-func increment)
       (utils/parse-int val1)
       (keyword reg2)
       (parse-func condition)
       (utils/parse-int val2)]))

(defn getreg [reg-key registers]
  (let [val (get registers reg-key)]
    (if (nil? val) 0 val)))

; sneaking in part 2
(def max-atom (atom 0))
(defn max-reg [registers]
  (apply max (map val registers)))
(defn update-max [n]
  (if (> n @max-atom)
    (reset! max-atom n)))
(defn solve2 [] @max-atom)
; /part 2

(defn process-step [registers ins]
  (let [[reg1 increment val1 reg2 condition val2] ins
        reg1val (getreg reg1 registers)
        reg2val (getreg reg2 registers)]
    (if (condition reg2val val2)
      (let [res (assoc registers reg1 (increment reg1val val1))]
        (update-max (max-reg res))
        res)
      registers)))

(defn process [instructions]
  (reduce process-step {} instructions))

(defn solve1 [split-input]
  (max-reg (process (map readline split-input))))
