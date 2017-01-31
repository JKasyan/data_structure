(ns arrays.Person (:import (java.util ArrayList)))
(defn avg
      [numbers]
      (/ (apply + numbers) (count numbers ArrayList)))