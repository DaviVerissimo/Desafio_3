package com.compass.uol.davi.desafio3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compass.uol.davi.desafio3.model.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Number> {

}
