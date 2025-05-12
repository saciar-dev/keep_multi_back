package com.vve.KeepSmilingBack.controller;

import com.vve.KeepSmilingBack.exceptions.PlayerNotFoundException;
import com.vve.KeepSmilingBack.exceptions.ScoreNotFoundException;
import com.vve.KeepSmilingBack.model.Player;
import com.vve.KeepSmilingBack.model.dto.CreatePlayerRequest;
import com.vve.KeepSmilingBack.model.dto.CreateScoreRequest;
import com.vve.KeepSmilingBack.model.dto.PlayerResponse;
import com.vve.KeepSmilingBack.model.dto.ScoreResponse;
import com.vve.KeepSmilingBack.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<PlayerResponse>> getAllPlayers(){
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlayerById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(playerService.findById(id));
        }catch (PlayerNotFoundException pnfe){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(pnfe.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createPlayer(@RequestBody CreatePlayerRequest playerRequest){
        PlayerResponse playerResponse = playerService.save(playerRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(playerResponse.getId())
                .toUri();
        return ResponseEntity.created(location).body(playerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @Valid @RequestBody CreatePlayerRequest createPlayerRequest){
        try{
            return ResponseEntity.ok(playerService.update(id, createPlayerRequest));
        }catch(PlayerNotFoundException pnfe){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(pnfe.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable Long id){
        try {
            playerService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Player eliminado correctamente");
        }
        catch (PlayerNotFoundException pnfe){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(pnfe.getMessage());
        }
    }


}
