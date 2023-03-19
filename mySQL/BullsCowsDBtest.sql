-- Defines the test data base and creates the tables in it


-- Drops any existing databases, then rebuilds a database with the same name. It will then be ready to use

DROP DATABASE IF EXISTS bullscowstest;
CREATE DATABASE bullscowstest;
USE bullscowstest;


CREATE TABLE game(
gameId int PRimary KEY AUTO_INCREMENT,
numberOfGuesses int,
answer int,
won boolean);

describe  game;
SELECT * FROM game;