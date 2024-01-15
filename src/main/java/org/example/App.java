package org.example;

public class App {
    public static void main(String[] args) {
        String[][] stringsValid = new String[][]{
                {"1", "2", "3", "4"}, {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}, {"1", "2", "3", "4 "}
        };
        String[][] stringsWithNull = new String[][]{
                {" 1", "2", "3", "4"}, null,
                {"1", "2", "3", "4"}, {"1", "2", "3", "4 "}
        };
        String[][] stringsWrongSize = new String[][]{
                {" 1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4 "}
        };
        String[][] stringsWithNullValueInCell = new String[][]{
                {null, "2", "3", "4"}, {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}, {"1", "2", "3", "4 "}
        };
        String[][] stringsWithWrongValueInCell = new String[][]{
                {"1", "2", "3", "4"}, {"1", "foo", "3", "4"},
                {"1", "2", "3", "4"}, {"1", "2", "boo", "4 "}
        };
        InputArrayValidator inputArrayValidator = new InputArrayValidator();
        System.out.println("*For stringsValid : ");
        try {
            System.out.println("Sum cell in Array is " + inputArrayValidator.sumArrayElements(stringsValid) + ".");
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e);
        }
        try {
            System.out.println(inputArrayValidator.sumArrayElements(stringsWithNull));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("*For stringsWithNull : ");
            System.err.println(e);
        }
        try {
            System.out.println(inputArrayValidator.sumArrayElements(stringsWrongSize));
        } catch (Exception e) {
            System.err.println("*For stringsWrongSize : ");
            System.err.println(e);
        }
        // Передаю null вместо массива;
        try {
            System.out.println(inputArrayValidator.sumArrayElements(null));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("*For null : ");
            System.err.println(e);
        }
        try {
            System.out.println(inputArrayValidator.sumArrayElements(stringsWithNullValueInCell));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("*For stringsWithNullValueInCell : ");
            System.err.println(e);
        }
        try {
            System.out.println(inputArrayValidator.sumArrayElements(stringsWithWrongValueInCell));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("*For stringsWithWrongValueInCell : ");
            System.err.println(e);
        }
    }
}
