package com.vve.KeepSmilingBack.mapper;

import com.vve.KeepSmilingBack.model.Player;
import com.vve.KeepSmilingBack.model.dto.PlayerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlayerMapper {

    PlayerMapper mapper = Mappers.getMapper(PlayerMapper.class);

    PlayerResponse toPlayerResponse(Player player);

    Player playerResponseToPlayer(PlayerResponse playerResponse);
}
