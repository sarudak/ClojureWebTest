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

