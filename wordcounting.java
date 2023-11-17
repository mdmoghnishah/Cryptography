package cns;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class wordcounting{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Prompt the user
        System.out.print("Enter text or provide a file path: ");
        String input = scanner.nextLine();

        // Step 2: Read input text or file
        String content;
        if (isFilePath(input)) {
            content = readFileContent(input);
        } else {
            content = input;
        }

        // Step 3: Split the string into words
        String[] words = splitIntoWords(content);

        // Step 4: Initialize counter variable
        int wordCount = 0;

        // Step 5: Iterate through the array of words
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            // Increment the counter for each word encountered
            wordCount++;

            // Track word frequency
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        // Step 6: Display the total count of words to the user
        System.out.println("Total words: " + wordCount);

        // Additional features
        displayWordFrequency(wordFrequency);
    }

    private static boolean isFilePath(String input) {
        // Simple check for whether input is a file path
        return input.contains(File.separator);
    }

    private static String readFileContent(String filePath) {
        try {
            return new String(Files.readAllBytes(new File(filePath).toPath()));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
            return null; // Unreachable, added to satisfy compiler
        }
    }

    private static String[] splitIntoWords(String content) {
        // Split the string into words using space or punctuation as delimiters
        return Pattern.compile("\\W+").split(content);
    }

    private static void displayWordFrequency(Map<String, Integer> wordFrequency) {
        System.out.println("\nWord Frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
