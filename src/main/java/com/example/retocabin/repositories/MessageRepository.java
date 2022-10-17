package com.example.retocabin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.retocabin.entities.Message;

public interface MessageRepository  extends JpaRepository<Message, Integer>{
}
