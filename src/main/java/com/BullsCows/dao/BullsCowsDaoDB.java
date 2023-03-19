package com.BullsCows.dao;

import com.BullsCows.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BullsCowsDaoDB implements BullsCowsDao{


    @Autowired
    private JdbcTemplate jdbc;


    @Override
    public void addGame(Game game) {
        //SQL query to insert a game object into data base
        final String INSERT_GAME = "INSERT INTO game(numberOfGuesses, answer, won) VALUES(?,?,?)";
        jdbc.update(INSERT_GAME,
                game.getNumberOfGuessesUsed(),
                game.getAnswerInt(),
                game.getIsWon());
    }

    @Override
    public Game getGameFromId(int id) throws BullsCowsDataException {
        try {

            //SQL query to get the game with gameId = id
            final String SELECT_GAME_BY_ID = "SELECT * FROM game WHERE gameId= ?";
            //returns a List of Game objects of all games
            return jdbc.queryForObject(SELECT_GAME_BY_ID, new GameMapper(), id);
        }catch (DataAccessException e){
            throw new BullsCowsDataException("Game not found in DataBase",e);
        }
    }

    @Override
    public List<Game> getAllGames() {
        //SQL query to get all the games
        final String SELECT_ALL_GAMES = "SELECT * FROM game";
        //returns a List of Game objects of all games
        return jdbc.query(SELECT_ALL_GAMES, new GameMapper());
    }

    @Override
    public void clearDatabase() {

        final String DELETE_CONTENTS = "TRUNCATE TABLE game;";
        jdbc.update(DELETE_CONTENTS);

    }
}

