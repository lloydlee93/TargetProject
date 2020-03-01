import java.util.ArrayList;
import java.util.List;

/**
 * Class for parsing data received from STDIN and returning a list of coordinates.
 */
public class StringConverterUtility {
    /**
     * Represents the size of a single data set. The size of 4 representing the bottom left (x,y) coordinates and the upper right (x,y) coordinates.
     */
    private static final int COORDINATES_SIZE = 4;

    /**
     * Constructor for StringConverterUtility.
     */
    private StringConverterUtility(){
        //Intentionally left blank. Do not want instances being created for the Util class.
    }

    /**
     * Gets a data set and returns a list of coordinates representing the bottom-left (x,y) and upper-right (x,y) coordinates of a rectangle.
     * @param dataSet, Array list of String data to parse.
     * @return a list of integer arrays, with each array being a size of 4.
     */
    public static List<int[]> getCoordinates(ArrayList<String> dataSet) {
        ArrayList<String> correctedData = correctDataSet(dataSet);
        List<int[]> coordinateList = new ArrayList<>();

        for (String data : correctedData) {
            String[] coordinates = data.split("\\s+");
            int[] rectangle = new int[COORDINATES_SIZE];
            for (int i = 0; i < COORDINATES_SIZE; i++) {
                rectangle[i] = Integer.parseInt(coordinates[i]);
            }
            coordinateList.add(rectangle);
        }
        return coordinateList;

    }

    /**
     * Corrects the data set if needed. Removes all characters that are not integers or spaces, removes leading and trailing
     * spaces, and checks if the data contains only 4 integers.
     * @param data, Array list of the data to correct if needed.
     * @return an Array list of the data that can be parsed, otherwise an exception is thrown is the data is invalid.
     */
    private static ArrayList<String> correctDataSet(ArrayList<String> data){
        for(int i = 0; i < data.size(); i++){
            String copy = data.get(i);
            data.set(i, data.get(i).replaceAll("[^0-9 ]", " "));
            data.set(i, data.get(i).trim());
            if(data.get(i).split("\\s+").length != COORDINATES_SIZE){
                throw new IllegalArgumentException(String.format("Unable to parse the data: %s. Coordinates found was not equal to 4.", copy));
            }
        }

        return data;
    }
}
