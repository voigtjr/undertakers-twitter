(ns undertakers-twitter.core
  (:use [clojure.contrib.duck-streams :only (read-lines)]
        undertakers-twitter.utility
        undertakers-twitter.twitif)
  (:import [org.joda.time DateTime LocalDate]
           [java.io File]))

(def date-regex #"^(\d{1,2})/(\d{1,2})/(\d{4})\s+(\d{2}):(\d{2})\s*$")

(defn parse-hockey-game-date [s]
  (let [[month day year hour minute] (map parse-int (re-captures date-regex s))]
    (DateTime. year month day hour minute)))

(defn today? [other-date]
  (= (.toLocalDate other-date) (LocalDate/now)))

;; TODO handle two games on the same day
;; (first sidesteps this issue by only returning one thing)
(defn load-next-game [file]
  (first (filter today? (load-schedule (resource file)))))

(def post-reminder identity)

(def schedule-file "schedule.txt")

(defn -main [& _]
  (if-let [game-info (load-next-game schedule-file)]
    (post-reminder game-info)))
