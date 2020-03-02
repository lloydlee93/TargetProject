import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TargetProject {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;

    public static void main(String args[]) {
//        ArrayList<String> data = readFromSTDIN();
        ArrayList<String> data = new ArrayList<>();
        data.add("0 292 399 307");

        List<int[]> list = StringConverterUtility.getCoordinates(data);

        BarrenLandAnalysis barrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, list);

        ArrayList<Integer> theFinalList = barrenLandAnalysis.getFertileLandArea();

        for(Integer item: theFinalList) {
            System.out.println(item.toString());
        }
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



