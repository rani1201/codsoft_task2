import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {
        
        System.out.println("Please enter a text or provide a file to count the words.");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter '1' to input text or '2' to input a file path: ");
            String inputOption = scanner.nextLine();

            if (inputOption.equals("1")) {
                System.out.print("Enter the text: ");
                String text = scanner.nextLine();
                int wordCount = countWords(text);
                System.out.println("Total words: " + wordCount);
                break;
            } else if (inputOption.equals("2")) {
                System.out.print("Enter the file path: ");
                String filePath = scanner.nextLine();
                try {
                    File file = new File(filePath);
                    String text = readFile(file);
                    int wordCount = countWords(text);
                    System.out.println("Total words: " + wordCount);
                    break;
                } catch (FileNotFoundException e) {
                    System.out.println("File not found. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        scanner.close();
    }

    private static String readFile(File file) throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
            stringBuilder.append("\n");
        }
        scanner.close();
        return stringBuilder.toString();
    }

    private static int countWords(String text) {
        String[] words = text.split("[\\s.,;:!?]+");
        return words.length;
    }
}