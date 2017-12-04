(ns advent2017.utils-test
  (:require [expectations.clojure.test :refer :all]
            [advent2017.utils :refer :all]))

(defexpect parse-int-tests
  (expect (parse-int "1") 1)
  (expect (parse-int "1234") 1234)
  (expect (parse-int 1234) 1234))

(defexpect distance-tests
  (expect 0 (distance 0 0))
  (expect 3 (distance 2 1))
  (expect 2 (distance 0 -2)))
