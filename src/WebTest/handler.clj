(ns WebTest.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [WebTest.Content :as pages]
            [WebTest.ReportSelection :as reports]))

(defn renderReport [report yearmonth]
  (pages/report (reports/getDataFor report yearmonth)))

(defroutes app-routes
  (GET "/Quickletter/:yearmonth" [yearmonth] (renderReport :QuickLetter yearmonth))
  (GET "/Quarterly/:yearmonth" [yearmonth] (renderReport :Quarterly yearmonth))
  (GET "/TMC/:yearmonth" [yearmonth] (renderReport :TMC yearmonth))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))


