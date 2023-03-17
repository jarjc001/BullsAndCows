package com.BullsCows.dao;

import com.BullsCows.dto.Game;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class GameMapper implements RowMapper<Game> {

    /**Maps the data from a line of the Database into a Game object.
     */
    @Override
    public Game mapRow(ResultSet rs, int index) throws SQLException {
        Game newGame = new Game(
                rs.getInt("gameId"),
                rs.getInt("numberOfGuesses"),
                rs.getInt("answer"),
                rs.getBoolean("won")
        );
        return newGame;
    }
}
