package com.example.springbootshoppingmallproject.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class LineMessageRequest {

    private List<String> to;
    private List<Messages> messages;

}
