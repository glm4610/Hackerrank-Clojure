(defn evalGrade [grade]
  (let [remainder (memoize #(rem grade 5))]
    (if (or (< grade 38)
            (< (remainder) 3)) ; Remainder < 3 == Distance till next multiple >= 3
      grade
      (+ grade
         (- 5 (remainder))))))

(defn gradingStudents [grades]
  (map evalGrade grades))