package org.example;

/**
 * Lesson_6 Levin Vladimir
 */
public class App {
    public static void main(String[] args) {
        String filename = "src/data.csv";
        AppData appData1 = new AppData(new String[]{"one", "two", "three", "four"},
                new int[][]{{12, 11, 21, 12}, {30, 35, 40, 67}, {444, 555, 688, 75}});
        System.out.println("Записано в файл:");
        System.out.println(appData1);
        //Write to file
        AppData.save(appData1);
        // Save from file to data structure;
        AppData dataFromFile = AppData.load(filename);
        System.out.println("Считано из файла:");
        System.out.println(dataFromFile);
    }
}
