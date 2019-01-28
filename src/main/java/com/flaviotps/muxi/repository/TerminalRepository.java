package com.flaviotps.muxi.repository;


import com.flaviotps.muxi.domain.model.TerminalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminalRepository extends JpaRepository<TerminalModel, Integer> {
    TerminalModel findByLogic(int logic);
}
