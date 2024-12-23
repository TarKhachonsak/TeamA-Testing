import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TeamA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name: "); //1
        String name = scanner.nextLine();

        System.out.print("Enter Christian Era (e.g., 1998): "); //2
        int christianEra = scanner.nextInt();

        System.out.print("Enter Software Testing Score: "); //3
        int score = scanner.nextInt();

        int currentYear = java.time.Year.now().getValue(); //4
        int age = currentYear - christianEra;

        String grade = getGrade(score);

        String filePath = "D:\\Java\\New folder\\Score_Grade_Table.txt";

        try (FileWriter writer = new FileWriter(filePath, true)) { //5
            writer.write("Name : " + name + "\n");
            writer.write("Age : " + age + "\n");
            writer.write("Software Testing Grade : " + grade + "\n");
            writer.write("----------------------------\n");
            System.out.println("File written successfully at: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }
        scanner.close();
    }

    public static String getGrade(int score) {
        if (score >= 80) return "A";
        else if (score >= 75) return "B+";
        else if (score >= 70) return "B";
        else if (score >= 65) return "C+";
        else if (score >= 60) return "C";
        else if (score >= 55) return "D+";
        else if (score >= 50) return "D";
        else return "F";
    }
}