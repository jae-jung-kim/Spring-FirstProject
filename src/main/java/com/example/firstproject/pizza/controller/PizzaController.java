package com.example.firstproject.pizza.controller;

import com.example.firstproject.pizza.dto.PizzaDto;
import com.example.firstproject.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class PizzaController {
    @Autowired
    private PizzaService pizzaService;
    @GetMapping("/pizzas")
    public ResponseEntity<List<PizzaDto>> index(){
        List<PizzaDto> pizzaDto = pizzaService.index();
        return ResponseEntity.status(HttpStatus.OK).body(pizzaDto);
    }
}
