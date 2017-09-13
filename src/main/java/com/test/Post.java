package com.test;

import java.lang.reflect.Array;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors (chain = true)
//@EqualsAndHashCode(of = {"id"})

public class Post {

    private int userId;
    private int id;
    private String title;
    private String body;


    public Post() {

    }

}