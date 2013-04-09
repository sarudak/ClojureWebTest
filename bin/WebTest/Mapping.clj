(ns WebTest.Mapping)

(defn quarterlyToView [reportData] (hash-map :short_name (:account_short_name reportData)
                                            :company_name (:company reportData)
                                            :email (:email reportData)
                                            :ending_aum (:estimated_aum reportData)
                                            ))