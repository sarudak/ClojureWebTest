(ns WebTest.Content
  (:use hiccup.page ))

(defn defaultTemplate [& body] 
  (html5 [:body
          [:h1 "Hello world"]
          body]))

(defn index [message shouldDisplayMessage] 
  (defaultTemplate [:p "This is a page of important information you should be aware of : " (if shouldDisplayMessage message)
           [:a#GreatLink.button {:href "http://google.com"} "Go to google"]]
    [:p "Something else to say"]))

(defn reportRow [reportLine] (identity
                               [:tr
                                [:td (:short_name reportLine)]
                                [:td (:company_name reportLine)]
                                [:td (:email reportLine)]
                                [:td (:ending_aum reportLine)]
                                ]))

(defn report [reportLines] 
  (defaultTemplate [:p "This is a page of important information you should be aware of : " 
           [:table
            [:thead
             [:tr
              [:th "Short Name"]
              [:th "Company Name"]
              [:th "Email"]
              [:th "AUM"]
              ]
             ]
            (for [row reportLines] (reportRow row))
            ]]))
