(ns WebTest.ReportSelection
  (:use compojure.core)
  (:require [WebTest.Database :as data]))

(defn columnMapping [mappings]
  (map #(zipmap [:columnName :dataMapper] %) (partition 2 mappings)))

(defn mapAsMoney [key collection] (format "$%.2f" (key collection)))

(def reportColumns {:QuickLetter (columnMapping 
                                 ["Short Name" :short_name
                                  "Company Name" :company_name
                                  "Email" :email
                                  "Assets Under management" (partial mapAsMoney :ending_aum)])
                    :Quarterly (columnMapping 
                                 ["Short Name" :account_short_name
                                  "Company Name" :company
                                  "Email" :email
                                  "Assets Under management" (partial mapAsMoney :estimated_aum)
                                  "Contact Name" #(str (:last_name %) "," (:first_name %))
                                  "Something" #(str "something" (:notinthemap %))])
                    :TMC (columnMapping
                           ["Account Name" :account_name
                            "Short Name" :account_short_name
                            "Market Value" (partial mapAsMoney :mkt_value)])})

(defn getDataFor [report yearmonth] 
  (hash-map :columns (report reportColumns)
            :report report
            :data (take 500 (data/getReport report yearmonth))))

