(ns WebTest.Database)
(require '[clojure.java.jdbc :as db])
(def conn {:classname "net.sourceforge.jtds.jdbc.Driver"
               :subprotocol "jtds:sqlserver"
               :database "PCR_DEV_CHRISTOPHERB"
               :user "SethTest"
               :password "P@ssw0rd"
               :instance "Dev"
               :subname "//SEA-2400-02"
})
;Add Classpath to your C:\Program Files\Java\JDBC\sqljdbc_3.0\enu\sqljdbc4.jar
;Below code demos how to execute a simple sql select query and print it to console
;This query will print all the user tables in your MS SQL Server Database
(defn printQuery [query] (db/with-connection conn 
      (db/with-query-results rs [query] 
           (doseq [row rs] (println row))
)))

(defn printSysObjects [] (printQuery "select * from sys.objects  where type = 'U'"))
