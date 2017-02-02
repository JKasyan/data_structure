(ns arrays.Sandbox
      (:import (recursion Recursion)))
(defn avg
      [numbers]
      (/ (apply + numbers) (count numbers)))

(println (avg [1 2 3]))

(let [a 7 b (+ 2 3)] (println (* a b)))

(defn hypot
      [x, y]
      (let [x1 (* x x) y1 (* y y)]
            (Math/sqrt (+ x1 y1))))

(println "Hypot 3 and 4= " (hypot 3 4))

;
;
;
(defn triangle [number] (Recursion/triangleStack number))

(println (triangle 4))

(println (Math/pow 2 2))
