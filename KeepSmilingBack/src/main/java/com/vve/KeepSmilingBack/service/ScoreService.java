package com.vve.KeepSmilingBack.service;

import com.vve.KeepSmilingBack.exceptions.PlayerNotFoundException;
import com.vve.KeepSmilingBack.exceptions.ScoreNotFoundException;
import com.vve.KeepSmilingBack.mapper.ScoreMapper;
import com.vve.KeepSmilingBack.model.Score;
import com.vve.KeepSmilingBack.model.dto.CreateScoreRequest;
import com.vve.KeepSmilingBack.model.dto.ScoreResponse;
import com.vve.KeepSmilingBack.repository.IPlayerRepository;
import com.vve.KeepSmilingBack.repository.IScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class ScoreService implements IScoreService{
    @Autowired
    private IScoreRepository scoreRepository;

    @Autowired
    private IPlayerRepository playerRepository;

    @Override
    public ScoreResponse findById(Long id) {
        return scoreRepository.findById(id)
                .map(ScoreMapper.mapper::toScoreResponse)
                .orElseThrow(ScoreNotFoundException::new);
    }

    @Override
    public List<ScoreResponse> findAll() {
        List<Score> scores = scoreRepository.findAll();

        List<ScoreResponse> scoreResponses = scores.stream()
                .map(score -> ScoreMapper.mapper.toScoreResponse(score)).collect(Collectors.toList());
        return scoreResponses;
    }

    @Override
    public List<ScoreResponse> findByplayer(Long playerId) {
        return playerRepository.findById(playerId)
                .map(scoreRepository::findAllByPlayer)
                .map(scores -> scores.stream()
                        .map(ScoreMapper.mapper::toScoreResponse)
                        .collect(Collectors.toList()))
                .orElseThrow(PlayerNotFoundException::new);
    }

    @Override
    public ScoreResponse save(CreateScoreRequest scoreRequest) {
        return playerRepository.findById(scoreRequest.getPlayerId())
                .map(player -> {
                    Score score = new Score();
                    score.setPoints(scoreRequest.getPoints());
                    score.setScoreDate(LocalDateTime.now());
                    score.setPlayer(player);
                    return scoreRepository.save(score);
                })
                .map(ScoreMapper.mapper::toScoreResponse)
                .orElseThrow(PlayerNotFoundException::new);
    }

    @Override
    public void deleteById(long id) {
        if(scoreRepository.findById(id).isEmpty()){
            throw new ScoreNotFoundException();
        }
        scoreRepository.deleteById(id);
    }
}
