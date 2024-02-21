package Controller;

import Model.Algorithm;
import java.util.Scanner;

public class Handler {

    Scanner sc;
    Algorithm algorithm;

    public Handler() {
        sc = new Scanner(System.in);
        algorithm = new Algorithm();
    }

    public void addWord() {
        System.out.println("Enter English: ");
        String eng = sc.next();
        System.out.println("Enter Vietnamese: ");
        String vi = sc.next();
        if (algorithm.addWord(eng, vi) == false) {
            char choice = sc.next().charAt(0);
            if (choice == 'y' && choice == 'Y') {
                algorithm.getDictionary().put(eng, vi);
            }
        } else {
            System.out.println("Not updating existing word.");
        }
    }

    public void delWord() {
        System.out.println("Enter Word to delete(Eng): ");
        String eng = sc.next();
        algorithm.removeWord(eng);
    }

    public void translate() {
        System.out.println("Enter word to translate: ");
        String eng = sc.next();
        System.out.println(algorithm.translate(eng));
    }
}
