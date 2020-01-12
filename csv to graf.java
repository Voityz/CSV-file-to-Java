import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class CSVReader {


    private static int[][] arr;

    public static void main(String[] args) throws FileNotFoundException,
            IOException  {
        CSVReader obj = new CSVReader();
        obj.run();
        printer(arr);
    }


    public static String passInCSV() throws IOException {
        System.out.println("Zadejte název souboru CSV. Pokud soubor není v " +
                           " této složky zadejte celou cestu k souboru.");
        Scanner kb = new Scanner(System.in);
        String fileName = kb.nextLine();
        arr = new int[LineCounter.count(fileName)][];
        return fileName;
    }


    public void run() throws FileNotFoundException, IOException {
        String csvFile = passInCSV();
        Scanner nl = new Scanner(new File(csvFile));
        int count = 0;
        while (nl.hasNextLine()) {
            String str = nl.nextLine();
            Scanner comma = new Scanner(str);
            String[] split = str.split(",");
            int[] numbers = new int[split.length];
            for (int i =0; i<split.length; i++) {
                String numberString = split[i];
                if (numberString.equals("")) {
                    numbers[i] = 0;
                }
                else {
                    numbers[i] = Integer.parseInt(numberString);
                }
            }
            arr[count] = numbers;
            count++;
        }
    }


    public static int[][] getCSVArr() throws IOException {
        CSVReader obj = new CSVReader();
        obj.run();
        return arr;
    }


    public static void printer(int[][] arr){
        System.out.println("CSV Output:");
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
