package com.vve.KeepSmilingBack.service;

import com.vve.KeepSmilingBack.exceptions.PlayerNotFoundException;
import com.vve.KeepSmilingBack.mapper.PlayerMapper;
import com.vve.KeepSmilingBack.model.Player;
import com.vve.KeepSmilingBack.model.dto.CreatePlayerRequest;
import com.vve.KeepSmilingBack.model.dto.PlayerResponse;
import com.vve.KeepSmilingBack.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService implements IPlayerService{

    @Autowired
    private IPlayerRepository playerRepository;

    @Override
    public PlayerResponse findById(Long id) {
        return playerRepository.findById(id)
                .map(PlayerMapper.mapper::toPlayerResponse)
                .orElseThrow(PlayerNotFoundException::new);
    }

    @Override
    public List<PlayerResponse> findAll() {
        List<Player> players = playerRepository.findAll();
        List<PlayerResponse> playerResponses = players.stream()
                .map(player -> PlayerMapper.mapper.toPlayerResponse(player))
                .collect(Collectors.toList());
        return playerResponses;
    }

    @Override
    public PlayerResponse save(CreatePlayerRequest createPlayerRequest) {
        Player player = new Player();
        player.setName(createPlayerRequest.getName());
        player.setPhone(createPlayerRequest.getPhone());
        return PlayerMapper.mapper.toPlayerResponse(playerRepository.save(player));
    }

    @Override
    public PlayerResponse update(Long id, CreatePlayerRequest createPlayerRequest) {
        return playerRepository.findById(id)
                .map(player -> {
                    player.setName(createPlayerRequest.getName());
                    player.setPhone(createPlayerRequest.getPhone());
                    return PlayerMapper.mapper.toPlayerResponse(playerRepository.save(player));
                })
                .orElseThrow(PlayerNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if(playerRepository.findById(id).isEmpty()){
            throw new PlayerNotFoundException();
        }
        playerRepository.deleteById(id);
    }
}
