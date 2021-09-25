package com.trains.steve.repository;

import com.trains.steve.model.Trains;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainInfoRepository extends JpaRepository<Trains, Integer> {
    Page<Trains> findById(int id, Pageable pageable);
}
