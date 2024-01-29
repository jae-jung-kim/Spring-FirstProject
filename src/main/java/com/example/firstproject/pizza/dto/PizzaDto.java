package com.example.firstproject.pizza.dto;

import com.example.firstproject.pizza.entity.Pizza;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PizzaDto {
    private String name;
    private Long price;

    public static PizzaDto createPizzaDto(Pizza p) {
        return new PizzaDto(p.getName(), p.getPrice());
    }
}
