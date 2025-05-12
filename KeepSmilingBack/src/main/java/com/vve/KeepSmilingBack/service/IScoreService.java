package com.vve.KeepSmilingBack.service;

import com.vve.KeepSmilingBack.model.dto.CreateScoreRequest;
import com.vve.KeepSmilingBack.model.dto.ScoreResponse;

import java.util.List;

public interface IScoreService {
    ScoreResponse findById(Long id);
    List<ScoreResponse> findAll();
    List<ScoreResponse> findByplayer(Long playerId);
    ScoreResponse save(CreateScoreRequest scoreRequest);
    void deleteById(long id);

}
