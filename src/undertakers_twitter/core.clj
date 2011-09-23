(ns undertakers-twitter.core)

(require 'twitter
  ['oauth.client :as 'oauth])

;; Make a OAuth consumer
(def oauth-consumer (oauth/make-consumer (System/getenv "UNDERTAKERS_KEY")
  (System/getenv "UNDERTAKERS_SECRET")
  "https://api.twitter.com/oauth/request_token"
  "https://api.twitter.com/oauth/access_token"
  "https://api.twitter.com/oauth/authorize"
  :hmac-sha1))

;; token/secret
(def oauth-access-token (System/getenv "UNDERTAKERSNOVI_TOKEN"))

(def oauth-access-token-secret (System/getenv "UNDERTAKERSNOVI_SECRET"))

;; Post to twitter
;; (twitter/with-oauth oauth-consumer
;;   oauth-access-token
;;   oauth-access-token-secret
;;   (twitter/update-status "posting from #clojure with #oauth"))

;; Find out who follows dons
(twitter/followers-of-name "undertakersnovi")

(defn -main [& m]
  (let [ids (twitter/followers-of-name "undertakersnovi")
        users (filter #(identity %) ids)
        each (twitter/lookup-users-by-id (apply str (interpose "," users)))]
    (for [x each] (println (:screen_name x)))))
