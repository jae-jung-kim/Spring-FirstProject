package com.example.firstproject.dto;

import com.example.firstproject.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Setter
@NoArgsConstructor
public class CoffeeDto {
    private Long id;
    private String name;
    private Long price;

    public Coffee toEntity(){
        return new Coffee(id, name, price);
    }
}
