
import Controller.Handler;
import View.Menu;

public class Dictonary {

    Handler handler;

    public Dictonary() {
        handler = new Handler();
    }

    public void displayMainMenu() {
        Menu<String> mainMenu = new Menu<>("Dictionary", new String[]{
            "Add Word",
            "Delete Word",
            "Translate",
            "Exit"
        }) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 ->
                        handler.addWord();
                    case 2 ->
                        handler.delWord();
                    case 3 ->
                        handler.translate();
                    case 4 ->
                        System.exit(0);
                    default ->
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        };
        mainMenu.run();
    }

    public static void main(String[] args) {
        Dictonary main = new Dictonary();
        main.displayMainMenu();
    }
}
