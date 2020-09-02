package com.example.lobsters.repository;

import com.example.lobsters.model.Lobster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LobsterRepository extends JpaRepository<Lobster, Long> {

}