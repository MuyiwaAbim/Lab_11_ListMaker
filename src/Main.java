

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean isRunning = true;
        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("""
                Welcome to ListMaker! Here are following choices as follows:\s
                A/a - add an item to the list
                D/d - Delete an item from the list
                P/p - Print/Display the list
                Q/q - Quit the program
                ---------------------""");

        do {

            String input = SafeInput.getRegExString(in, "Enter a choice: ", "[AaDdPpQq]");

            if (input.equalsIgnoreCase("a")) {
                System.out.println("You printed an A");
                System.out.println("Enter an int to add to the list: ");
                int userIntInput;
                if (in.hasNextInt()) {
                    userIntInput = in.nextInt();
                    addItem(arr, userIntInput);
                } else {
                    System.out.println("Invalid item");
                }

            } else if (input.equalsIgnoreCase("d")) {
                System.out.println("Enter 'e' to delete an item at the end of the list. Enter 's' to delete a specific index:");
                String deletionChoice = in.nextLine();
                if (deletionChoice.equalsIgnoreCase("e")) {
                    deleteItem(arr);
                } else if (deletionChoice.equalsIgnoreCase("s")) {
                    displayList(arr);
                    System.out.println("Enter the index you'd like to delete the item from: ");
                    int userIndex = in.nextInt();
                    deleteItemAtIndex(arr, userIndex);
                }
            } else if (input.equalsIgnoreCase("p")) {
                displayList(arr);
            } else if (input.equalsIgnoreCase("q")) {
                isRunning = SafeInput.getYNConfirm(in, "Enter y to end. Enter n to not end:");

            }


        } while (isRunning);
    }

    private static void displayList(ArrayList<Integer> arrList) {

        if (arrList == null) {
            System.out.println("List is empty or null.");
        } else {
            for (int i : arrList) {
                System.out.print("[" + i + "]" + " ");
            }
        }
        System.out.println();
    }

    private static void addItem(ArrayList<Integer> arrList, int item) {
        arrList.add(item);
        System.out.println("Added " + item + " to the list.");
    }

    private static void deleteItem(ArrayList<Integer> arrList) {
        try {
            System.out.println("Removed " + arrList.get(arrList.size()-1) + " from the list.");
            arrList.remove(arrList.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds or arraylist is empty");
        }
    }

    private static void deleteItemAtIndex(ArrayList<Integer> arrList, int index) {
        try {
            System.out.println("Removed " + arrList.get(index) + " from the list at index " + index + ".");
            arrList.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds or arraylist is empty");
        }
    }
}