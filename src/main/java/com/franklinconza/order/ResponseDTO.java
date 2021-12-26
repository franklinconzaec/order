package com.franklinconza.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResponseDTO {
    private List<Integer> order;
    private int sum;
    private int average;
}
