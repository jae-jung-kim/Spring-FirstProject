package com.example.firstproject.pizza.service;

import com.example.firstproject.pizza.dto.PizzaDto;
import com.example.firstproject.pizza.entity.Pizza;
import com.example.firstproject.pizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;
    public List<PizzaDto> index() {
        List<Pizza> pizzas = pizzaRepository.findAll();

        List<PizzaDto> pizzaDtos = new ArrayList<PizzaDto>();

        for (Pizza p : pizzas) {
            PizzaDto pdto = PizzaDto.createPizzaDto(p);
            pizzaDtos.add(pdto);
        }

        return pizzaDtos;
    }
}
