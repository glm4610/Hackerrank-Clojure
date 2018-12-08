(defn is-pm? [s]
  (re-matches #"(?i).*PM$" s))

(is-pm? "12341234am")
(is-pm? "12341234pm")

(defn get-hour [s]
  (mod
   (->> s
        (re-find #"(\d\d?):")
        (last)
        (Integer/parseInt))
   12))

(get-hour "12:3:4")

(def replace clojure.string/replace)

(defn timeConversion [s]
  (let [hour (get-hour s)
        new-s (replace s #"^\d\d?"
                       (format "%02d"
                               (if (is-pm? s) (+ 12 hour) hour)))]
    (subs new-s 0 (- (count new-s) 2))))

(timeConversion "12:23:33am")
(timeConversion "12:23:33pm")

;; (def fptr (get (System/getenv) "OUTPUT_PATH"))

(def s (read-line))

;; (def result (timeConversion s))

;; (spit fptr (str result "\n") :append true)

(print (timeConversion s))
