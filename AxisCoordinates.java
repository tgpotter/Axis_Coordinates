import java.util.Scanner;
import java.util.stream.IntStream;

public class AxisCoordinates {

    public static void main(String[] args) {

        int a1 = 2;
        int a2 = 4;
        int b1 = 1;
        int b2 = 6;

        // Converts end points into arrays containing full interval values
        int[] A = IntStream.rangeClosed(a1, a2).toArray();
        int[] B = IntStream.rangeClosed(b1, b2).toArray();

        // Prints interval values
        System.out.println("Interval A = [" + a1 + ", " + a2 + "]" );
        System.out.println("Interval B = [" + b1 + ", " + b2 + "]" );

        // Sets value of isTrue to whatever is input from inputScanner
        int isTrue = AxisCoordinates.inputScanner();

        // Boolean variables to store value of isAnElementOf
        boolean inArrayA = isAnElementOf(isTrue, A);
        boolean inArrayB = isAnElementOf(isTrue, B);

        // x in A. x in B
        System.out.println(isTrue + " in A: \t\t\t\t\t\t" + inArrayA);
        System.out.println(isTrue + " in B: \t\t\t\t\t\t" + inArrayB);

        // x is in A but not B
        boolean setDifferenceAB = ((inArrayA) && (!inArrayB));
        System.out.println(isTrue + " in A\\B: \t\t\t\t\t\t" + setDifferenceAB);

        // x is in B but not A
        boolean setDifferenceBA = ((!inArrayA) && (inArrayB));
        System.out.println(isTrue + " in B\\A: \t\t\t\t\t\t" + setDifferenceBA);

        // x is in A and B
        boolean setIntersection = ((inArrayA) && (inArrayB));
        System.out.println(isTrue + " in intersection of A and B: \t" + setIntersection);

        // x is in A or B
        boolean setUnion = ((inArrayA) || (inArrayB));
        System.out.println(isTrue + " in union of A and B: \t\t\t" + setUnion);

        // x is in A or B, but is not in A and B
        boolean symmDiff = ((inArrayA) || (inArrayB)) && ((!inArrayA) || (!inArrayB));
        System.out.println(isTrue + " in symm. diff. of A and B: \t" + symmDiff);

    }

    public static int inputScanner() {
        // This scanner takes user input of type int that will be returned to be used in main method.
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter x : ");
        int isTrue = userInput.nextInt();
        userInput.close();
        return isTrue;
    }

    public static boolean isAnElementOf(int isTrue, int[] arr) {
        // Check if the specified element is present in the array or not
        return IntStream.of(arr).anyMatch(n -> n == isTrue);
    }

}