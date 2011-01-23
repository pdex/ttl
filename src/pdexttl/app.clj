(ns pdexttl.app
  (:gen-class :extends javax.servlet.http.HttpServlet)
  (:use compojure.core
        [ring.util.servlet   :only [defservice]]
        [ring.util.response  :only [redirect]]
        [hiccup.core         :only [h html]]
        [hiccup.page-helpers :only [doctype include-css link-to xhtml-tag]]
        [hiccup.form-helpers :only [form-to text-area text-field]])
  (:import (com.google.appengine.api.datastore Query))
  (:require [compojure.route          :as route]
            [appengine.datastore.core :as ds]
            [appengine.users          :as users]))

(set! *warn-on-reflection* true)

(defn page [elements]
    (html [:html
        [:title (:title elements)]
        [:body (:body elements)]]))

(def add-player-form (form-to [:post "/addPlayer.post"]
    [:fieldset 
        [:legend "Add a new player"]
            [:ol
                [:li [:label {:for :email} "Email"] (text-field :email)]
                [:li [:label {:for :name} "Name"] (text-field :name)]
                [:li [:label {:for :ranking} "Ranking"] (text-field :ranking)]]
        [:button {:type "submit"} "Add!"]]))

(defn add-player [email name ranking]
    (ds/create-entity {:kind "player" :email email :name name :ranking ranking})
    (redirect "/"))

(defn get-players []
    (ds/find-all (Query. "player")))
(defn list-players-page [] (page 
   {:title "List Players"
    :body [:ol (map #(vector :li (:name %1)) (get-players))]}))
(defroutes example
    (GET "/" [] (page {
        :title "This is the title"
        :body "<h1>Hello World Wide Web!</h1>"}))
    (GET "/addPlayer" [] (page {:title "Add Player" :body add-player-form}))
    (POST "/addPlayer.post" [email name ranking] (add-player email name ranking))
    (GET "/players" [] (list-players-page))
    ;(POST "/newSeason" [name] (create-season name))
    (route/not-found "Page not found"))

(defservice example)
