(ns arrays.Destruction)

(def v [1 "vector" 2 [3 4 [7 8]]])
(let [[x _ _ [y _ [_ z]]] v] (println (+ x y z)))

(def m {:a 1 :b 2})
(let [{x :a} m] (println (* 2 x)))
