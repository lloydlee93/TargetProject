import java.util.List;
import java.util.Queue;

/**
 * Class to determine the fertile land in square meters.
 */
public class BarrenLandAnalysis {
    /**
     * Psuedo code to implement:
     *
     * 1. Initialize 2D array              DONE
     * 2. Set Barren indexes in graph.     DONE
     * 3. implement BFS                    IN PROGRESS
     * 4. store area into hashmap
     * 5. sort the hashmap
     * 6. print
     * 7. test
     */
    private int[][] mGraph;
    private int mGraphWidth;
    private int mGraphHeight;
    private List<int[]> mBarrenLandList;
    private Queue<int[]> mQueue;
    final int BARREN = -1;

    public BarrenLandAnalysis(int width, int height, List<int[]> barrenLandList) {
        mGraphWidth = width;
        mGraphHeight = height;
        mGraph = new int[width][height];
        mBarrenLandList = barrenLandList;
    }

    /**
     * Gets the area of the smallest and largest fertile land areas.
     * @return an int[] array of size 2 of smallest and largest fertile land areas.
     */
    public int[] getFertileLandArea() {
        final int SIZE_OF_COORDINATE = 2;
        final int UNVISITED = 0;
        int area;

        setBarrenLand(getBarrenLandList());

        for(int i = 0; i < getGraphWidth(); i++) {
            for(int j = 0; j < getGraphHeight(); j++) {
                if((getGraph()[i][j] != BARREN) && (getGraph()[i][j] != UNVISITED)) {
                    //Add the current coordinate to queue.
                    int[] coordinate = new int[SIZE_OF_COORDINATE];
                    coordinate[0] = i;
                    coordinate[1] = j;
                    mQueue.add(coordinate);

                    //reset area count.
                    area = 0;
                }

                while(!mQueue.isEmpty()) {
                    /**
                     * TODO:
                     * Add all neighboring nodes to the queue.
                     * Mark the coordinate as visited by initializing it to some value.
                     * increment area count.
                     */
                }

                //TODO store area count here.

            }
        }
        return null;
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

            for(int i = x1; i < x2; i++) {
                for(int j = y1; j < y2; j++) {
                    getGraph()[i][j] = BARREN;
                }
            }
        }
    }
}
