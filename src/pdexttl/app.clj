(ns pdexttl.app
    (:gen-class :extends javax.servlet.http.HttpServlet)
    (:use 
          compojure.core
          [ring.util.servlet :only [defservice]]
          [ring.util.response :only [redirect]]
          [clojure.contrib.string :only (lower-case)]
          hiccup.core
          hiccup.page-helpers
          hiccup.form-helpers
          appengine.datastore)
    (:require [compojure.route :as route]))


(defn page [elements]
    (html [:html
        [:title (:title elements)]
        [:body (:body elements)]]))
(defentity Player () (
    (email :key lower-case :serialize lower-case)
    (name)
    (ranking)))

;(def get-players ["player1" "player2" "player3"])
;(select "player" ))
(def nothing '["1" "2"])
;(def list-players-page (page 
;    {:title "List Players"
;     :body [:ol (map #([:li %1]) (nothing))]}))
(def add-player-form (form-to [:post "/addPlayer.post"
    [:fieldset [:legend "Add a new player"]
        [:ol [:li [:label {:for :name} "Name"] (text-field :name)]
             [:li [:label {:for :ranking} "Ranking"] (text-field :ranking)]]
        [:button {:type "submit"} "Add!"]]]))

(defn add-player [email name ranking]
    ;(create-entity (player {:email email :name name :ranking ranking}))
    (redirect "/"))

(defroutes example
    (GET "/" [] (page {
        :title "This is the title"
        :body "<h1>Hello World Wide Web!</h1>"}))
    (GET "/addPlayer" [] (page {:title "Add Player" :body (add-player-form)}))
    (POST "/addPlayer.post" [name ranking] (add-player name ranking))
    ;(POST "/newSeason" [name] (create-season name))
    (route/not-found "Page not found"))

(defservice example)
