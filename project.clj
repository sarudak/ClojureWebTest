(defproject WebTest "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.5"]
                 [enlive "1.1.1"]
                 [org.clojure/java.jdbc "0.2.3"]
                 [net.sourceforge.jtds/jtds "1.2.4"]
                 ]
  :plugins [[lein-ring "0.8.2"]]
  :ring {:handler WebTest.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}})
