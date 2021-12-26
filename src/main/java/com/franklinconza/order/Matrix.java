package com.franklinconza.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Matrix {

    public static int[][] convertFromList(RequestDTO requestDTO) {
        int[][] array = new int[requestDTO.getHeight()][requestDTO.getWidth()];
        int row = 0;
        int column = 0;
        for (int number : requestDTO.getNumbers()) {
            array[row][column] = number;
            column++;
            if (column == requestDTO.getWidth()) {
                row++;
                column = 0;
            }
        }
        return array;
    }

    public static int sum(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public static int average(List<Integer> numbers) {
        return sum(numbers) / numbers.size();
    }

    public static List<Integer> spiral(int[][] matrix, RequestDTO requestDTO) {
        List<Integer> listSpiral = new ArrayList<Integer>();
        int row = 0;
        int column = 0;
        int width = requestDTO.getWidth();
        int height = requestDTO.getHeight();
        int cycle = (width < height) ? (int) Math.ceil(width / (double) 2) : (int) Math.ceil(height / (double) 2);

        width--;
        height--;

        for (int count = 1; count <= cycle; count++) {

            for (int i = column; i <= width; i++) {
                listSpiral.add(matrix[row][i]);
            }

            for (int i = row + 1; i <= height; i++) {
                listSpiral.add(matrix[i][width]);
            }

            for (int i = width - 1; i >= column; i--) {
                listSpiral.add(matrix[height][i]);
            }

            for (int i = height - 1; i >= row + 1; i--) {
                listSpiral.add(matrix[i][column]);
            }

            row++;
            column++;
            width--;
            height--;
        }
        return listSpiral;
    }

    public static List<Integer> alternativeSpiral(int[][] matrix, RequestDTO requestDTO) {
        List<Integer> listSpiral = new ArrayList<Integer>();
        int row = 0;
        int column = 0;
        int width = requestDTO.getWidth() - 1;
        int height = requestDTO.getHeight() - 1;
        int cycle = 0;
        int sizeArray = requestDTO.getNumbers().size();

        for (int x = 1; x <= sizeArray; x++) {
            listSpiral.add(matrix[row][column]);

            if (column == 0 && row == cycle + 1) {
                cycle++;
            }
            if (column == 0 && row != cycle) {
                row--;

            }
            if (row == height - cycle) {
                column--;
            }
            if (column == width - cycle) {
                row++;
            }
            if (row == cycle) {
                column++;
            }
        }
        return listSpiral;
    }
}