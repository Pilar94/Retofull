package com.example.retocabin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.retocabin.entities.Cabin;

public interface CabinRepository  extends JpaRepository<Cabin, Integer>{
}
