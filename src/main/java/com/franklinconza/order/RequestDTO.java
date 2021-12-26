package com.franklinconza.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RequestDTO {
    private int width;
    private int height;
    private List<Integer> numbers;
}
