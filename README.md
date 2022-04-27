Iteration 1:

We completed the implementation of the character and item classes. The user will create a character at the beginning of the game which they will play as throughout the game. Each character comes with a number of attributes which they measure the strength of their character. Items are also another large part of the game as the user can use them to augment their character and improve their strength. We also created a battle class which simply serves as our main method right now to test our code.

In our next iteration we intend to complete the feature where users can intialize and customize their attributes at the beginning of the game. We will also add more classes to represent encounters and monsters the player may face throughout the game. We will also add different classes that the player can choose that will fit their playstyle and how those classes will affect attributes respectively. 

To run our program through the command line, first you must import the project from GitHub. 
Next you would navigate to your git folder using cd git/
Enter the project folder using cd project-herrero_zou_foster/
Enter the src folder using cd src/ 
Compile the program using javac Battle.java	
Run the program using java with java Battle.java. 

Iteration 2:

We added the implementation of the monster class which functions as a class that represents various monsters that the player could encounter during the game. We also implemented the interaction of buying items as well as adding a new player type class (rogue) which has abilities special to its class. We've also made the player class more robust with the player spawning with a set amount of max health and a range of damage values that they can inflict. We've also fixed the main class so that it can test for basic functionality. 

In our next iteration we intend to create more player type classes with specific abilities that the player can choose from. We would also like for the player to be able to use their items and get the intended effects from such uses. We also would like to implement most of the turn based combat between the player and monsters that makes up most of the game. 

We have yet to implement JUnit test cases for our Item class, as well as some of the methods for the player class. Currently our battles are only between one player and monster and are used to test basic functionality. 

To run our program through command line, first you must cd to project-herrero_zou_foster/src. Next, you simply run the script ./textBattle.sh. If an error occurs regarding permissions it may be necessary to run chmod +x textBattle.sh. After you run this command run ./textBattle.sh. 

Iteration 3:
We added the implementation of 2 more classes (warrior and mage) and their respective attributes and abilities. We have also added a shop class that the user can interact with and purchase the items they would like to. The user can now also use different items for different effects. We also slimmed down our main method as well as our startBattle method by adding methods to other classes. 

We have not implemented a win condition or end condition for the game. It runs endlessly until the user prompts the game to quit. 

To run our program through command line, first you must cd to project-herrero_zou_foster/src. Next, you simply run the script ./textBattle.sh. If an error occurs regarding permissions it may be necessary to run chmod +x textBattle.sh. After you run this command run ./textBattle.sh. 
