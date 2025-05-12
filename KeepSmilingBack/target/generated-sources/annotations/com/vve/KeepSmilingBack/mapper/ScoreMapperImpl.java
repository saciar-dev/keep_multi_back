package com.vve.KeepSmilingBack.mapper;

import com.vve.KeepSmilingBack.model.Player;
import com.vve.KeepSmilingBack.model.Score;
import com.vve.KeepSmilingBack.model.dto.PlayerResponse;
import com.vve.KeepSmilingBack.model.dto.ScoreResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-10T19:47:56-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class ScoreMapperImpl implements ScoreMapper {

    @Override
    public ScoreResponse toScoreResponse(Score score) {
        if ( score == null ) {
            return null;
        }

        ScoreResponse scoreResponse = new ScoreResponse();

        scoreResponse.setId( score.getId() );
        scoreResponse.setPoints( score.getPoints() );
        scoreResponse.setScoreDate( score.getScoreDate() );
        scoreResponse.setPlayer( playerToPlayerResponse( score.getPlayer() ) );

        return scoreResponse;
    }

    @Override
    public Score scoreResponseToScore(ScoreResponse scoreResponse) {
        if ( scoreResponse == null ) {
            return null;
        }

        Score score = new Score();

        score.setId( scoreResponse.getId() );
        score.setPoints( scoreResponse.getPoints() );
        score.setScoreDate( scoreResponse.getScoreDate() );
        score.setPlayer( playerResponseToPlayer( scoreResponse.getPlayer() ) );

        return score;
    }

    protected PlayerResponse playerToPlayerResponse(Player player) {
        if ( player == null ) {
            return null;
        }

        PlayerResponse playerResponse = new PlayerResponse();

        playerResponse.setId( player.getId() );
        playerResponse.setName( player.getName() );
        playerResponse.setPhone( player.getPhone() );

        return playerResponse;
    }

    protected Player playerResponseToPlayer(PlayerResponse playerResponse) {
        if ( playerResponse == null ) {
            return null;
        }

        Player player = new Player();

        player.setId( playerResponse.getId() );
        player.setName( playerResponse.getName() );
        player.setPhone( playerResponse.getPhone() );

        return player;
    }
}
