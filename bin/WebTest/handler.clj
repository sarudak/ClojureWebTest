(ns WebTest.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [WebTest.Content :as pages]))

(defroutes app-routes
  (GET "/" [] (pages/index "Good morning sir" false))
  (GET "/Greeting/:name" [name] (pages/index (str "Hello to you " name) true))
  (GET "/Date/:year/:month/:day" [year month day] (str "<h1>It is " month "/" day "/" year "</h1>"))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

