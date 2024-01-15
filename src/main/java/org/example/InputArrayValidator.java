package org.example;

import java.util.regex.Pattern;

public class InputArrayValidator {
    public int sumArrayElements(String[][] strings) throws MyArraySizeException, MyArrayDataException {
        String message = "Input Array size is not 4 x 4.";
        if (strings == null || strings.length != 4) {
            throw new MyArraySizeException(message);
        }
        int row = 0;
        for (String[] s :
                strings) {
            if (s == null || s.length != 4) {
                throw new MyArraySizeException(message + " row " + row + " size is incorrect.");
            }
            row++;
        }
        int result = 0;
        //String cell = "";
        StringBuilder wrongTypeIndex = new StringBuilder();
        String regex = "^[0-9]+$";
        boolean isValidInput = true;
        for (String[] string : strings) {
            for (String s : string) {
                if (s != null && Pattern.matches(regex, s.trim())) {
                    result += Integer.parseInt(s.trim());
                } else {
                    isValidInput = false;
                    break;
                }
            }
        }
        if (!isValidInput) {
            for (int i = 0; i < strings.length; i++) {
                for (int j = 0; j < strings[i].length; j++) {
                    if (strings[i][j] == null || !Pattern.matches(regex, strings[i][j].trim())) {
                        wrongTypeIndex.append(String.format("[%d][%d], ", i, j));
                    }
                }
            }
            throw new MyArrayDataException("Wrong Data format in cell " + wrongTypeIndex.toString()
                    .replaceAll(", $", "."));
        }
        return result;
    }
}

