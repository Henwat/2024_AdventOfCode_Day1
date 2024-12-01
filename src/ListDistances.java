import java.io.*;
import java.util.*;

import static java.lang.Math.abs;


public class ListDistances {


    public static void main(String[] args) {
        List<Integer> leftCol = new ArrayList<>();
        List<Integer> rightCol = new ArrayList<>();

        try {
            File file = new File("./resources/input.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);

            String line;
            while((line = br.readLine()) != null) {
                String[] numbs = line.split(" {3}");
                leftCol.add(Integer.parseInt(numbs[0]));
                rightCol.add(Integer.parseInt(numbs[1]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        leftCol.sort(Collections.reverseOrder());
        rightCol.sort(Collections.reverseOrder());

        int totalDiff = 0;
        for(int i = 0; i < leftCol.size(); i++) {
            totalDiff += abs(leftCol.get(i) - rightCol.get(i));
        }

        int totalProd = 0;
        for(Integer leftNumber : leftCol) {
            totalProd += leftNumber * Collections.frequency(rightCol, leftNumber);
        }

        System.out.println(totalDiff);
        System.out.println(totalProd);
    }
}