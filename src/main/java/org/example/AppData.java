package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public static void save(AppData appData) {
        String filename = "src/data.csv";
        File file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.printf("File %s created\n", file.getName());
            } catch (IOException e) {
                System.out.println("Error creating File");
                System.out.println(e);
            }
        }
        try (FileWriter fileWriter = new FileWriter(filename)) {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(String.join(";", appData.getHeader()));
            for (int i = 0; i < appData.getData().length; i++) {
                printWriter.println(IntStream.of(appData.getData()[i])
                        .mapToObj(Integer::toString)
                        .collect(Collectors.joining(";")));
            }
            printWriter.flush();
            System.out.println("data added to file with save(AppData) method");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static AppData load(String filename) {
        File file = new File(filename);
        int rowCount = 0;
        int colCount;
        int rowNumber = 0;
        try {
            //count row and column to initialize array size
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String contents;
            colCount = bufferedReader.readLine().split(";").length;
            while ((bufferedReader.readLine()) != null) {
                rowCount++;
            }
            String[] header = new String[colCount];
            int[][] data = new int[rowCount][colCount];
            bufferedReader = new BufferedReader(new FileReader(file));
            while ((contents = bufferedReader.readLine()) != null) {
                if (rowNumber == 0) {
                    header = contents.split(";");

                } else {
                    String[] s = (contents.split(";"));
                    data[rowNumber - 1] = (Arrays.stream(s).mapToInt(o -> Integer.parseInt(o.trim()))).toArray();
                }
                rowNumber++;
            }
            return new AppData(header, data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(";", getHeader()));
        sb.append('\n');
        for (int i = 0; i < data.length; i++) {
            sb.append(IntStream.of(getData()[i]).mapToObj(Integer::toString).collect(Collectors.joining(";")));
           if(i < data.length - 1) {
               sb.append('\n');
           }
        }
        return sb.toString();
    }
}
