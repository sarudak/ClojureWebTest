(ns WebTest.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [WebTest.Content :as pages]
            [WebTest.Database :as data]))

(defroutes app-routes
  (GET "/" [] (pages/report (take 1000 (data/getQuickLetters 201212))))
  (GET "/Greeting/:name" [name] (pages/index (str "Hello to you " name) true))
  (GET "/Date/:year/:month/:day" [year month day] (str "<h1>It is " month "/" day "/" year "</h1>"))
  (GET "/Quickletters" [] (pages/report (take 6 (data/getQuickLetters 201212))))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

