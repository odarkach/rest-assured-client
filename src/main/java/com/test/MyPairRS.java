package com.test;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Map;
import lombok.Data;

@Data
public class MyPairRS {

    @JsonDeserialize (keyUsing = MyPairDeserializer.class)
    private Map<MyPair, String> map;

}
