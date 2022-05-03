package com.example.demo.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Greeting {

    /** ID. */
    private long id;

    /** 内容. */
    private String content;

}
