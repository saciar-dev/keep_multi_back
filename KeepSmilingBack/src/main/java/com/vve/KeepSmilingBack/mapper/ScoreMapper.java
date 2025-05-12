package com.vve.KeepSmilingBack.mapper;

import com.vve.KeepSmilingBack.model.Score;
import com.vve.KeepSmilingBack.model.dto.ScoreResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScoreMapper {

    ScoreMapper mapper = Mappers.getMapper(ScoreMapper.class);

    ScoreResponse toScoreResponse(Score score);

    Score scoreResponseToScore(ScoreResponse scoreResponse);
}
