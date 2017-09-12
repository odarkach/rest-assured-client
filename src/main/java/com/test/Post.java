package com.test;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors (chain = true)


public class Post {

    private int userId;
    private int id;
    private String title;
    private String body;

}