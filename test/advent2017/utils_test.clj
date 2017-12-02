(ns advent2017.utils-test
  (:require [expectations.clojure.test :refer :all]
            [advent2017.utils :refer :all]))

(defexpect parse-int-tests
  (expect (parse-int "1") 1)
  (expect (parse-int "1234") 1234)
  (expect (parse-int 1234) 1234))
