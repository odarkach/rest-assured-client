package com.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import java.io.IOException;

public class MyPairDeserializer extends KeyDeserializer {

    @Override
    public Object deserializeKey (String keyMap,
                                  DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String [] pairs = keyMap.split("and");
        String firstName = pairs[0].trim();
        String secondName = pairs[1].trim();
        return new MyPair(firstName, secondName);
    }

}
