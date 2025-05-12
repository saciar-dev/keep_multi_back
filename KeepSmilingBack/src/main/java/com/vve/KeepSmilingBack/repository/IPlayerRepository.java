package com.vve.KeepSmilingBack.repository;

import com.vve.KeepSmilingBack.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Long> {
}
