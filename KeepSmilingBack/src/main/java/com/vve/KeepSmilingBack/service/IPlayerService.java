package com.vve.KeepSmilingBack.service;

import com.vve.KeepSmilingBack.model.dto.CreatePlayerRequest;
import com.vve.KeepSmilingBack.model.dto.PlayerResponse;

import java.util.List;

public interface IPlayerService {

    PlayerResponse findById(Long id);
    List<PlayerResponse> findAll();
    PlayerResponse save (CreatePlayerRequest createPlayerRequest);
    PlayerResponse update(Long id, CreatePlayerRequest createPlayerRequest);
    void deleteById(Long id);

}
