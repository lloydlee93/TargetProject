import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TargetProject {
    public static void main(String args[]) {
        ArrayList<String> data = readFromSTDIN();
        List<int[]> list = StringConverterUtility.getCoordinates(data);
        System.out.println(list.size());
    }

    /**
     * Reads the data from STDIN.
     * @return an ArrayList of Strings from the data read from STDIN.
     */
    public static ArrayList<String> readFromSTDIN() {
        ArrayList<String> results = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;

        System.out.println("***************************************************************************************************************");
        System.out.println("***************************************************************************************************************");
        System.out.println("Please enter 4 coordinates for the barren rectangles that are separated by spaces. Enter Nothing once complete:");

        while(shouldContinue) {
            String input = scanner.nextLine();
            if(input.equals("")){
                scanner.close();
                shouldContinue = false;
            } else {
                results.add(input);
            }
        }

        return results;
    }
}
