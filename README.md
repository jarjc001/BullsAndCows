"# BullsAndCows" 

Overview
In this activity, you will write a REST server to facilitate playing a number guessing game known as "Bulls and Cows" / Mastermind /Wordle. 
In each game, a 4-digit number is generated where every digit is different. 
For each round, the user guesses a number and is told the exact and partial digit matches.
•	An exact match occurs when the user guesses the correct digit in the correct position.
•	A partial match occurs when the user guesses the correct digit but in the wrong position.
o	These two checks don’t need to be done in the same looping construct. 
	One for loop to check in-line (CounterInLine++)
	Second to check in-position (CounterInPosn++, CounterInLine--) 
 	 	 	 	 	3,5,8	8 is in Posn so dec In Line
 	P	P	o	E	In Line	In Posn
Guess	3	5	7	8	2	1
Line	1	3	5	8		 
1358
Once the number is guessed the user wins the game. 
If (InPosn == 4) Won
Requirements
You'll create a 
a.	Spring Boot REST application using 
b.	JDBC Template to access the database.

A Game should have an answer and a status (in progress or finished). While the game is in progress, users should not be able to see the answer. The answer will be a 4-digit number with no duplicate digits.

Each Round will have 
1.	a guess, 
2.	the time of the guess (optional!!!) 
3.	and the result of the guess in the format "e:0:p:0" where "e" stands for exact matches and "p" stands for partial matches.
You will need several REST endpoints for this:
•	"begin" - POST – Starts a game, generates an answer, and sets the correct status. Should return a 201 CREATED message as well as the created gameId.
o	Instantiates a game with all the details e.g. Game a = new Game();
•	"guess" – POST – Makes a guess by passing the guess and gameId in as JSON. 
o	E.g. a.guess(1,4,6,2) … talking to the method guess() which takes in 4 ints
o	The program must calculate the results of the guess and mark the game finished if the guess is correct. 
•	"game" – GET – Returns a list of all games. Be sure in-progress games do not display their answer.
o	Select * from games … A Statement into theTable storing all results from previous games
•	"game/{gameId}" - GET – Returns a specific game based on ID. Be sure in-progress games do not display their answer.
o	Select * from games where ID = ? … A PreparedStatment intoTable storing all results from previous games


You should include a Service layer to manage the game rules, such as 
1.	generating initial answers for a game and 
2.	calculating the results of a guess.
All of your public DAO interface methods should be tested thoroughly.
Additional Notes
•	Use Postman to verify your endpoints behave the way you expect them to be.
General Flow 
1.	Start the game
2.	Main Menu
a.	Play New Game
b.	List All Games Played Historically
c.	Find Previous Game by ID
3.	Playing of Game
a.	Game object (GO) created for that game – Not all fields will be updated yet! 
i.	Time of Game (nice to have!)
ii.	Answer – The combination in maybe an Array of ints
iii.	Status – Boolean? 
b.	Computer Generates Combination
i.	Unique values between 1-9 inclusive
c.	You take a guess
i.	EP combination given for that guess 
ii.	Easy v Difficult 
d.	Continue until Game Won or # of Rounds met
4.	Once Game Won / Ended (Lost) 
a.	Write to DB 
b.	Map 
5.	Listing of all games – Historical record of all COMPLETED games 
a.	SQL Query – Select * … Use a Mapper object
6.	Find game by ID 



Feedback
Graded by Eugene O'Regan
100.00 %
Comments:
The only thing missing from this is the kitchen sink. Oh wait on!!  An exemplary project - as per usual
