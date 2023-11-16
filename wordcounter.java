package cns;
import java.util.Scanner;

public class wordcounter {

    public static int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text or provide a file path: ");
        String userInput = scanner.nextLine();

        try {
            // Check if userInput is a file path
            Scanner fileScanner = new Scanner(new java.io.File(userInput));
            StringBuilder fileContent = new StringBuilder();
            while (fileScanner.hasNext()) {
                fileContent.append(fileScanner.next()).append(" ");
            }
            fileScanner.close();
            userInput = fileContent.toString();
        } catch (java.io.FileNotFoundException e) {
            // If not a file path, treat it as plain text
        }

        // Remove punctuation and convert to lowercase for more accurate counting
        String processedText = userInput.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();

        // Count words
        int wordCount = countWords(processedText);

        System.out.println("Total number of words: " + wordCount);

        scanner.close();
    }
}

