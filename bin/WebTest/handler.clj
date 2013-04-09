(ns WebTest.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [WebTest.Content :as pages]
            [WebTest.Database :as data]
            [WebTest.Mapping :as mapping]))

(defroutes app-routes
  (GET "/" [] (pages/index "" false))
  (GET "/Quickletters/:yearmonth" [yearmonth] (->> (data/getQuickLetters yearmonth)
																				           (take 500)
																				           (pages/report)))
  (GET "/Quarterly/:yearmonth" [yearmonth]  (->> (data/getQuarterly yearmonth)
																			           (take 500)
																			           (map mapping/quarterlyToView)
																			           (pages/report)))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))


