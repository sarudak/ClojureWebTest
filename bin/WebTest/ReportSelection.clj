(ns WebTest.ReportSelection
  (:use compojure.core)
  (:require [WebTest.Database :as data]
            [WebTest.Mapping :as mapping]))

(defn columnMapping [mappings]
  (map #(zipmap [:columnName :dataMapper] %) (partition 2 mappings)))

(def reportColumns {:QuickLetter (columnMapping 
                                 ["Short Name" :short_name
                                  "Company Name" :company_name
                                  "Email" :email
                                  "Assets Under management" :ending_aum])
                    :Quarterly (columnMapping 
                                 ["Short Name" :account_short_name
                                  "Company Name" :company
                                  "Email" :email
                                  "Assets Under management" :estimated_aum
                                  "Contact Name" #(str (:last_name %) "," (:first_name %)) ])})

(defn getDataFor [report yearmonth] 
  (hash-map :columns (report reportColumns)
            :data (take 500 (data/getReport report yearmonth))))

