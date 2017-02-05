(ns arrays.Destruction)

(def v [1 "vector" 2 [3 4 [7 8]]])
(let [[x _ _ [y _ [_ z]]] v] (println (+ x y z)))
