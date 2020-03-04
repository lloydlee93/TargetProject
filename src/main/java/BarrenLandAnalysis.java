package main.java;

import java.util.*;

/**
 * Class to determine the fertile land in square meters.
 */
public class BarrenLandAnalysis {
    /**
     * 2D graph of the land
     */
    private int[][] mGraph;
    /**
     * Land width.
     */
    private int mGraphWidth;
    /**
     * Land height
     */
    private int mGraphHeight;
    /**
     * List of coordinates of the barren land
     */
    private List<int[]> mBarrenLandList;
    /**
     * Represents Barren land
     */
    private final int BARREN = -1;
    /**
     * Represents unvisited land
     */
    private final int UNVISITED = 0;
    /**
     * Represents visited land
     */
    private final int VISITED = 1;

    /**
     * Constructor for the BarrenLandAnalysis
     * @param width, width of the land
     * @param height, height of the land
     * @param barrenLandList, list of coordinates of the barren land.
     */
    public BarrenLandAnalysis(int width, int height, List<int[]> barrenLandList) {
        mGraphWidth = width;
        mGraphHeight = height;
        mGraph = new int[width][height];
        mBarrenLandList = barrenLandList;
    }

    /**
     * Gets the area of the smallest and largest fertile land areas.
     * @return a String with the smallest and largest fertile land areas.
     */
    public String getFertileLandArea() {
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<Integer> fertileLandList = new ArrayList<>();
        String smallestLargestFertileLand = "";
        int area = 0;

        verifyDataSet();
        setBarrenLand(getBarrenLandList());

        for(int i = 0; i < getGraphWidth(); i++) {
            for(int j = 0; j < getGraphHeight(); j++) {
                if(getGraph()[i][j] == UNVISITED) {
                    //Add the current coordinate to queue.
                    int[] coordinate = new int[2];
                    coordinate[0] = i;
                    coordinate[1] = j;
                    queue.add(coordinate);

                    //reset area count.
                    area = 0;
                }

                // For each item in the queue, mark it as visited, add all neighboring nodes to the queue, and increment area count.
                while(!queue.isEmpty()) {
                    int[] currentCoordinate = queue.remove();
                    int xCoordinate = currentCoordinate[0];
                    int yCoordinate = currentCoordinate[1];

                    if(getGraph()[xCoordinate][yCoordinate] == UNVISITED) {
                        //Mark the coordinate as VISITED.
                        getGraph()[xCoordinate][yCoordinate] = VISITED;

                        //Add left node.
                        if ((xCoordinate - 1) >= 0) {
                            queue.add(new int[]{xCoordinate - 1, yCoordinate});
                        }

                        //Add the right node.
                        if ((xCoordinate + 1) < getGraphWidth()) {
                            queue.add(new int[]{xCoordinate + 1, yCoordinate});
                        }

                        //Add the below node.
                        if((yCoordinate - 1) >= 0) {
                            queue.add(new int[]{xCoordinate, yCoordinate - 1});
                        }

                        //Add the above node.
                        if((yCoordinate + 1) < getGraphHeight()) {
                            queue.add(new int[] {xCoordinate, yCoordinate + 1});
                        }

                        //Increment area count.
                        area++;
                    } else {
                        //Skip this node since we've already visited it or it's BARREN.
                        continue;
                    }
                }

                fertileLandList.add(area);
            }
        }

        //Gets the smallest and largest elements in the list.
        Collections.sort(fertileLandList);
        smallestLargestFertileLand = String.format("%s %s", fertileLandList.get(0), fertileLandList.get(fertileLandList.size() -1));

        return smallestLargestFertileLand;
    }

    /**
     * Get the 2D graph.
     * @return the 2D graph.
     */
    public int[][] getGraph() {
        return mGraph;
    }

    /**
     * Get the graph width.
     * @return the graph width.
     */
    public int getGraphWidth() {
        return mGraphWidth;
    }

    /**
     * Get the graph height.
     * @return the graph height.
     */
    public int getGraphHeight() {
        return mGraphHeight;
    }

    /**
     * Gets the list of barren land.
     * @return List of int[] arrays of barren land coordinates.
     */
    public List<int[]> getBarrenLandList() {
        return mBarrenLandList;
    }

    /**
     * Initialize the barren points in the graph with BARREN(-1), all other fields are by default initialized to 0.
     * @param barrenLandList, list of coordinates of barren land.
     */
    private void setBarrenLand(List<int[]> barrenLandList) {
        for(int[] item : barrenLandList) {
            int x1 = item[0];
            int y1 = item[1];
            int x2 = item[2];
            int y2 = item[3];

            for(int i = x1; i <= x2; i++) {
                for(int j = y1; j <= y2; j++) {
                    getGraph()[i][j] = BARREN;
                }
            }
        }
    }

    /**
     * Verifies that the data set is within bounds and are valid coordinates.
     */
    private void verifyDataSet() {
        if(getBarrenLandList() == null) {
            throw new NullPointerException("Expecting barren data, but was actually null.");
        } else if (getBarrenLandList().size() == 0){
            throw new IllegalArgumentException("Expecting barren data when none are present.");
        } else {
            for (int[] coordinates : getBarrenLandList()) {
                if (coordinates.length != 4) {
                    throw new IllegalArgumentException("Expecting data to be size of 4.");
                } else if (coordinates[0] < 0 || coordinates[0] > getGraphWidth() - 1 ||
                        coordinates[2] < 0 || coordinates[2] > getGraphWidth() - 1) {
                    throw new IllegalArgumentException("Invalid barren coordinates found for x coordinates.");
                } else if (coordinates[1] < 0 || coordinates[1] > getGraphHeight() - 1 ||
                        coordinates[3] < 0 || coordinates[3] > getGraphHeight() - 1) {
                    throw new IllegalArgumentException("Invalid barren coordinates found for y coordinates.");
                } else {
                    continue;
                }
            }
        }
    }
}