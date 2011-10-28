(ns undertakers-twitter.test.core
    (:use [lazytest.describe :only (describe it)]
          undertakers-twitter.core
          undertakers-twitter.twitif
          undertakers-twitter.utility)
    (:import [org.joda.time DateTime]))

(describe parse-hockey-game-date
  (it "parses a double digit month day"
    (= (DateTime. 2011 10 30 22 30) (parse-hockey-game-date "10/30/2011 22:30")))
  (it "parses a single digit month"
    (= (DateTime. 2011 1 30 22 30) (parse-hockey-game-date "1/30/2011 22:30")))
  (it "parses a single digit day"
    (= (DateTime. 2011 11 3 22 30) (parse-hockey-game-date "11/3/2011 22:30")))
  (it "parses a single both month day"
    (= (DateTime. 2011 1 3 22 30) (parse-hockey-game-date "1/3/2011 22:30"))))

(describe load-schedule
  (it "reads lines from file"
    (= 3 (count (load-schedule (resource "test-3-lines.txt")))))
  (it "parses simple lines correctly"
    (= "10/30/2011 22:30" (first (load-schedule (resource "test-3-lines.txt"))))))

(describe today?
  (it "is not when this test was written"
    (= false (today? (DateTime. 2011 10 25 00 00))))
  (it "is today"
    (= true (today? (DateTime/now))))
  (it "isn't tomorrow"
    (= false (today? (.plusDays (DateTime/now) 1)))))
