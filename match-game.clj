(defn setNumberOfComputerDraw [i]
  (- 4 i)
)

(defn stop []
  (System/exit 0)
)

(defn draw [matchesTotal userName]
  (println "Number of matches on table:" matchesTotal)
  (println "It's your turn," userName "!")
  (println "You can draw 1-3 matches from the table.") (flush)
  (let [userDraw (read-string (read-line))
        computerDraw (setNumberOfComputerDraw userDraw)]
    (if (= (- matchesTotal userDraw) 0)
      (println "You took the last match! You lost!")
      (do
        (if (> userDraw 3)
          (do
            (println "This input is not allowed!")
            (println "Please try again!")
            (stop))
          (do  
            (println "We now have" (- matchesTotal userDraw) "matches on the table")))
        (if (= computerDraw 1)
          (do
            (println "The computer took" computerDraw "match away!\n"))
          (do
            (println "The computer took" computerDraw "matches away!\n")))
        (draw (- matchesTotal userDraw computerDraw) userName)))))

(defn greeting []
  (println "Hello Stranger!")
  (println "What's your name?") (flush) 
    (let [userName (read-line)]
      (println "Welcome" userName "! Nice to meet you :)")
      (draw 17 userName)))

(defn start []
    (greeting))

(start)