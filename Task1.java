// Написать программу, показывающую последовательность действий для игры “Ханойская башня”
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int disks = readNumberOfDisks();

        SortKhanoi('a', 'b', 'c', disks);
    }

    private static int readNumberOfDisks() {
        try (Scanner iScanner = new Scanner (System.in)) {
            while (true) {
                System.out.printf("Please enter number of disks: ");
                String line = iScanner.nextLine();
                try {
                    int disks = Integer.parseInt(line);
                    if (disks <= 0) {
                        System.out.printf("Number of disks should be a positive number\n");
                    } else {
                        return disks;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Number of disks should be an integer");
                }
            }
        }
    }

    public static void printMove(char spire1, char spire2) {
        System.out.println(spire1 + "-->" + spire2);
    }

    static void SortKhanoi(char spire1, char spire2, char spire3, int disksNumber) {
        if (disksNumber == 1) {
            printMove(spire1, spire2);
        } else {
            SortKhanoi(spire1, spire3, spire2, disksNumber - 1);
            printMove(spire1, spire2);
            SortKhanoi(spire3, spire2, spire1, disksNumber - 1);
        }
    }
}