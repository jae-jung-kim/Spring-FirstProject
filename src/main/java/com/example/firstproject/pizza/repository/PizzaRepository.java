package com.example.firstproject.pizza.repository;

import com.example.firstproject.pizza.dto.PizzaDto;
import com.example.firstproject.pizza.entity.Pizza;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
   @Override
   List<Pizza> findAll();
}
