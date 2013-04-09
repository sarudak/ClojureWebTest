(ns WebTest.Content
  (:use hiccup.page ))

(defn defaultTemplate [& body] 
  (html5 [:body
          
          body]))

(defn reportRow [reportLine columnData] (identity
                               [:tr
                                (for [column columnData] (vector :td ((:dataMapper column) reportLine)))
                                ]))

(defn report [reportData] 
  (defaultTemplate [:h1 (name (:report reportData)) " Report"]
           [:table
            [:thead
             [:tr
              (for [column (:columns reportData)] (vector :th (:columnName column)))
              ]
             ]
            (for [row (:data reportData)] (reportRow row (:columns reportData)))
            ]))
