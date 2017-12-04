(ns advent2017.day03
  (:require [advent2017.utils :as utils]))

; 17  16  15  14  13
; 18   5   4   3  12
; 19   6   1   2  11
; 20   7   8   9  10
; 21  22  23---> ...)

; part 1

; [layer side last]
; [layerIndex lengthOfSide lastNumberInLayer]

(defn layer-size [side]
  (* 4 (dec side)))

(def spiral-layers
  (iterate (fn [[layer side last]]
             (let [newSide (+ side 2)]
               [(inc layer) newSide (+ last (layer-size newSide))]))
          [0 1 1]))

(defn find-layer-of [n]
  (first (filter (fn [[layer side last]]
                   (<= n last))
           spiral-layers)))

(defn find-position-in-layer [[layer side last] n]
  (let [[l s t] (nth spiral-layers (dec layer))]
    (- n t 1)))

(defn find-dist [n]
  (let [[layer side last] (find-layer-of n)
        pos (find-position-in-layer [layer side last] n)
        innerPos (mod pos (dec side))]
    (utils/distance layer (dec (- (/ (dec side) 2) innerPos)))))

(def solve1 find-dist)

; part 2
