package com.test;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Map;
import lombok.Data;


@Data
public class CarsRS {

    @JsonDeserialize(keyUsing = CarsDeserializer.class)
    private Map<MyPair, String> carsMap;

//  имя переменной зависит от поля джейсона, который мы тестим { "carsMap": {
//                                                                  "AUDI and 100": "AUDI",
//                                                                  "BMW and 100": "BMW"
//                                                                              } }

}
