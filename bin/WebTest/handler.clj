(ns WebTest.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [WebTest.Content :as pages]
            [WebTest.ReportSelection :as reports]))

(defroutes app-routes
  (GET "/" [] (pages/index "" false))
  (GET "/:reportName/:yearmonth" [reportName yearmonth] (pages/report (reports/getDataFor (keyword reportName) yearmonth)))
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))


