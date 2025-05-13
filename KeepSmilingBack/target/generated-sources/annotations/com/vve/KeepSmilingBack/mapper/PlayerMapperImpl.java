package com.vve.KeepSmilingBack.mapper;

import com.vve.KeepSmilingBack.model.Player;
import com.vve.KeepSmilingBack.model.dto.PlayerResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-13T00:06:48-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class PlayerMapperImpl implements PlayerMapper {

    @Override
    public PlayerResponse toPlayerResponse(Player player) {
        if ( player == null ) {
            return null;
        }

        PlayerResponse playerResponse = new PlayerResponse();

        playerResponse.setId( player.getId() );
        playerResponse.setName( player.getName() );
        playerResponse.setPhone( player.getPhone() );

        return playerResponse;
    }

    @Override
    public Player playerResponseToPlayer(PlayerResponse playerResponse) {
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
