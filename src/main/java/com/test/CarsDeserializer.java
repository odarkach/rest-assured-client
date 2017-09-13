package com.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import java.io.IOException;

public class CarsDeserializer extends KeyDeserializer {

    @Override
    public Object deserializeKey(String keyCarsMap,
                                 DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String [] pairs = keyCarsMap.split("and");
        String carName = pairs[0].trim();
        String carSpeed = pairs[1].trim();
        return new MyPair(carName, carSpeed);
    }

}
