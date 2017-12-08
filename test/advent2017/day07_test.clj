(ns advent2017.day07-test
  (:require [advent2017.day07 :refer :all]
            [expectations.clojure.test :refer :all]
            [clojure.java.io :as io]))

(def sample "pbga (66)
xhth (57)
ebii (61)
havc (66)
ktlj (57)
fwft (72) -> ktlj, cntj, xhth
qoyq (66)
padx (45) -> pbga, havc, qoyq
tknk (41) -> ugml, padx, fwft
jptl (61)
ugml (68) -> gyxo, ebii, jptl
gyxo (61)
cntj (57)
")

(def input (slurp (io/resource "day07")))

; part 1

(defexpect tokenize-tests
  (expect {:fwft {:weight 72 :children #{:ktlj :cntj :xhth}}}
          (tokenize "fwft (72) -> ktlj, cntj, xhth")))
  ; (println "tokenize" (tokenize sample)))

(defexpect find-parent-tests
  (expect :tknk (find-parent :fwft (tokenize sample)))
  (expect nil (find-parent :tknk (tokenize sample))))

(defexpect solve1-tests
  (expect :tknk (solve1 sample))
  (let [r (solve1 input)]
    (println "day07 solve1" r)
    (expect :bpvhwhh r)))

; part 2

(defexpect weight-tests
  (expect 66 (weight :pbga (tokenize sample)))
  (expect 251 (weight :ugml (tokenize sample))))

(defexpect balanced?-tests
  (expect true (balanced? :gyxo (tokenize sample)))
  (expect true (balanced? :ugml (tokenize sample)))
  (expect false (balanced? :tknk (tokenize sample))))

; (defexpect solve2-tests)
  ; (expect 60 (solve2 sample)))

(println "day07 solve2 (kinda)" (solve2 input))
; 10588 10596 10588
; 628   4402  96
; 10596 - 10588 = 8
; 4402 - 8 = 4394 <===== why isn't this the answer?
; 4402 + 6194 = 10596
