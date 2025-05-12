package com.vve.KeepSmilingBack.repository;

import com.vve.KeepSmilingBack.model.Player;
import com.vve.KeepSmilingBack.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IScoreRepository extends JpaRepository<Score, Long> {

    List<Score> findAllByPlayer(Player player);
}
