(ns WebTest.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [WebTest.Content :as pages]
            [WebTest.Database :as data]))

(defroutes app-routes
  (GET "/" [] (pages/index "" false))
  (GET "/Greeting/:name" [name] (pages/index (str "Hello to you " name) true))
  (GET "/Date/:year/:month/:day" [year month day] (str "<h1>It is " month "/" day "/" year "</h1>"))
  (GET "/Quickletters/:yearmonth" [yearmonth] (pages/report (take 500 (data/getQuickLetters yearmonth))))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

