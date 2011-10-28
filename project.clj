;; TODO Move to Clojure 1.3
(defproject undertakers-twitter "1.0.0-SNAPSHOT"
  :description "Posts reminders and what-not to the Undertakers Twitter feed" 
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo
            :comments "same as Clojure"}
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [clojure-twitter "1.2.5"]
                 [joda-time "2.0"]]
  :dev-dependencies [[com.stuartsierra/lazytest "1.1.2"]]
  :repositories {"stuartsierra-releases" "http://stuartsierra.com/maven2"}
  :main "undertakers-twitter.core")
