(ns advent2017.utils)

(defn parse-int [s]
  (Integer/parseInt (str s)))

(defn distance [a b]
  (+ (Math/abs a) (Math/abs b)))

(defn index-of [item coll]
  (count (take-while (partial not= item) coll)))
