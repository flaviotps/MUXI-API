package com.flaviotps.muxi.repository;


import com.flaviotps.muxi.model.domain.TerminalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerminalRepository extends JpaRepository<TerminalModel, Long> {
    List<TerminalModel> findAllByLogic(int logic);
}
