package ex33;

import java.util.Random;
import java.util.Scanner;

public class App {
    private static final String[] ans = new String[] {
                                            "Yes.",
                                            "No.",
                                            "Maybe.",
                                            "Ask again later."
                                                    };

    public static String run() {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("What's your question?");
            // I don't care about your question.
            scan.nextLine();
            return magicEight();
        }
    }

    /**
     * Does magical stuff
     * @return super secret message
     */
    private static String magicEight() {
        // get random value from ans indexes (0-3)
        return ans[(new Random().nextInt(4))];
    }
}
