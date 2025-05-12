package com.vve.KeepSmilingBack.controller;

import com.vve.KeepSmilingBack.exceptions.PlayerNotFoundException;
import com.vve.KeepSmilingBack.exceptions.ScoreNotFoundException;
import com.vve.KeepSmilingBack.model.Score;
import com.vve.KeepSmilingBack.model.dto.CreateScoreRequest;
import com.vve.KeepSmilingBack.model.dto.ScoreResponse;
import com.vve.KeepSmilingBack.service.ScoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public ResponseEntity<List<ScoreResponse>> getAllScores(){
        return ResponseEntity.ok(scoreService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getScoreById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(scoreService.findById(id));
        }catch (ScoreNotFoundException snfe){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(snfe.getMessage());
        }
    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<?> getScoresByPlayer(@PathVariable Long playerId){
        try {
            return ResponseEntity.ok(scoreService.findByplayer(playerId));
        } catch (PlayerNotFoundException pnfe){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(pnfe.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createScore(@Valid @RequestBody CreateScoreRequest scoreRequest){
        try {
            ScoreResponse scoreResponse = scoreService.save(scoreRequest);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(scoreResponse.getId())
                    .toUri();
            return ResponseEntity.created(location).body(scoreResponse);
        } catch (PlayerNotFoundException pnfe){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(pnfe.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteScore(@PathVariable Long id){
        try {
            scoreService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Score eliminado correctamente");
        }
        catch (ScoreNotFoundException snfe){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(snfe.getMessage());
        }
    }
}
