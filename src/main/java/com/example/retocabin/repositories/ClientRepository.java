package com.example.retocabin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.retocabin.entities.Client;

public interface ClientRepository  extends JpaRepository<Client, Integer>{
}
