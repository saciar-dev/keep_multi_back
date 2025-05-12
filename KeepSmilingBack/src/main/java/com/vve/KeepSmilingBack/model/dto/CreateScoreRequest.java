package com.vve.KeepSmilingBack.model.dto;

import jakarta.validation.constraints.NotNull;

public class CreateScoreRequest {

    private Long points;

    @NotNull(message = "Se debe especificar el id del jugador")
    private Long playerId;

    public CreateScoreRequest() {
    }

    public CreateScoreRequest(Long points, Long playerId) {
        this.points = points;
        this.playerId = playerId;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }
}
