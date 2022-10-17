package com.example.retocabin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.retocabin.entities.Category;

public interface CategoryRepository  extends JpaRepository<Category, Integer>{
}
