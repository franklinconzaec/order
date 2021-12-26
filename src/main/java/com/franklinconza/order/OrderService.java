package com.franklinconza.order;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {

    public ResponseDTO operations(RequestDTO requestDTO) {
        int columns = requestDTO.getWidth();
        int rows = requestDTO.getHeight();
        if (columns <= 0 || rows <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "the width or/and height <= 0");
        }

        int expectedLength = columns * rows;
        int sizeList = requestDTO.getNumbers().size();
        if (sizeList != expectedLength) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "the matrix is invalid size");
        }

        int sum = Matrix.sum(requestDTO.getNumbers());
        int average = Matrix.average(requestDTO.getNumbers());
        int[][] matrix = Matrix.convertFromList(requestDTO);
        List<Integer> listSpiral = Matrix.spiral(matrix, requestDTO);

        return new ResponseDTO(listSpiral, sum, average);
    }


}
