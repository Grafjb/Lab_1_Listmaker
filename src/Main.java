import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> myArrList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String menu = "A - Add\nD - Delete\nI - Insert\nP - Print\nQ - Quit";
        boolean quit = false;

        while (!quit) {
            displayList();
            System.out.println(menu);
            String choice = SafeInput.getRegExString(in, "Enter a choice", "[AaDdIiPpQq]");
            switch (choice.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    quit = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
                    break;
            }
        }
    }

    private static void addItem() {
        Scanner in = new Scanner(System.in);
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to add");
        myArrList.add(item);
    }

    private static void deleteItem() {
        Scanner in = new Scanner(System.in);
        if (myArrList.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        int index = SafeInput.getRangedInt(in, "Enter the item number to delete", 1, myArrList.size()) - 1;
        myArrList.remove(index);
    }

    private static void insertItem() {
        Scanner in = new Scanner(System.in);
        if (myArrList.isEmpty()) {
            System.out.println("The list is empty. Adding item to the start.");
            String item = SafeInput.getNonZeroLenString(in, "Enter the item to add");
            myArrList.add(0, item);
            return;
        }
        int index = SafeInput.getRangedInt(in, "Enter the position to insert the item", 1, myArrList.size()) - 1;
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to insert");
        myArrList.add(index, item);
    }

    private static void printList() {
        displayList();
    }

    private static void displayList() {
        if (myArrList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (int i = 0; i < myArrList.size(); i++) {
                System.out.println((i + 1) + ": " + myArrList.get(i));
            }
        }
    }
}
