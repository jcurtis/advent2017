(ns advent2017.day07
  (:require [clojure.string :as str]
            [advent2017.utils :as utils]))

; part 1

(defn tokenize [input]
  (reduce
   (fn [acc line]
     (let [[name weight _ & children] (str/split line #"\s")]
       (assoc acc
              (keyword name)
              {:weight (->> weight
                            (next)
                            (drop-last)
                            (apply str)
                            (utils/parse-int))
               :children (set (map keyword (map #(.replace % "," "") children)))})))
   {}
   (str/split-lines input)))

(defn find-parent
  [tower towers]
  (first (first (filter
                 (fn [t] (contains? ((second t) :children) tower))
                 towers))))

(defn solve1 [input]
  (let [towers (tokenize input)]
    (loop [tower (first (first towers))
           parent (find-parent tower towers)]
      (if (nil? parent)
        tower
        (recur parent (find-parent parent towers))))))

; part 2

(defn weight [tower towers]
  (reduce
   (fn [v t] (+ v (weight t towers)))
   (:weight (tower towers))
   (vec (val (second (tower towers))))))

(defn balanced? [tower towers]
  (let [childs (:children (tower towers))]
    (if (empty? childs)
      true
      (apply =
             (map
              (fn [branch] (weight branch towers))
              childs)))))

(defn solve2 [input]
  (let [towers (tokenize input)
        unbal (first (filter
                      (fn [tower] (not (balanced? (first tower) towers)))
                      towers))
        childs (second (second (second unbal)))]
    (map (fn [t] [t (weight t towers) (t towers)]) childs)))
