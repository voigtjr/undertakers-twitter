(ns undertakers-twitter.utility
  (:use [clojure.contrib.duck-streams :only (read-lines)])
  (:import [java.io File]))

(defn resource [file]
  (str (File. (File. (System/getProperty "user.dir") "resources") file)))

(defn parse-int [s]
  (Integer/parseInt s))

(defn load-schedule [file]
  (read-lines file))

(def re-captures (comp rest re-matches))
