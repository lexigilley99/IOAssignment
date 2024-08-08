package org.example;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> mergedList = new ArrayList<>();
        Set<Integer> commonSet = new HashSet<>();

        // Updated paths for input1.txt and input2.txt
        String input1Path = "src/main/java/org/example/input1.txt";
        String input2Path = "src/main/java/org/example/input2.txt";

        // input1.txt
        try (BufferedReader br = new BufferedReader(new FileReader(input1Path))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    int num = Integer.parseInt(line.trim());
                    list1.add(num);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format in input1.txt: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("input1.txt not found.");
        } catch (IOException e) {
            System.err.println("Error reading input1.txt.");
        }

        // Print list1 for debugging
        System.out.println("List1: " + list1);

        // input2.txt
        try (BufferedReader br = new BufferedReader(new FileReader(input2Path))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    int num = Integer.parseInt(line.trim());
                    list2.add(num);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format in input2.txt: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("input2.txt not found.");
        } catch (IOException e) {
            System.err.println("Error reading input2.txt.");
        }

        // Print list2 for debugging
        System.out.println("List2: " + list2);

        // Merging lists
        mergedList.addAll(list1);
        mergedList.addAll(list2);

        // Print mergedList for debugging
        System.out.println("Merged List: " + mergedList);

        // Finding common integers
        Set<Integer> set1 = new HashSet<>(list1);
        for (int num : list2) {
            if (set1.contains(num)) {
                commonSet.add(num);
            }
        }

        // Print commonSet for debugging
        System.out.println("Common Integers: " + commonSet);

        // merged.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("merged.txt"))) {
            for (int num : mergedList) {
                bw.write(Integer.toString(num));
                bw.newLine();
            }
            System.out.println("Merged file written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing merged.txt.");
        }

        // common.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("common.txt"))) {
            for (int num : commonSet) {
                bw.write(Integer.toString(num));
                bw.newLine();
            }
            System.out.println("Common file written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing common.txt.");
        }
    }
}


