(ns WebTest.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] (slurp "src/Content/Home.html"))
  (GET "/Greeting/:name" [name] (str "<h1>Hello " name "</h1>"))
  (GET "/Date/:year/:month/:day" [year month day] (str "<h1>It is " month "/" day "/" year "</h1>"))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

