package test.java;

import main.java.BarrenLandAnalysis;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Unit test class for BarrenLandAnalysis.java
 */
public class BarrenLandAnalysisTest {
    /**
     * Instance of BarrenLandAnalysis
     */
    private BarrenLandAnalysis mBarrenLandAnalysis;
    /**
     * List of coordinates for barren land
     */
    private List<int[]> mBarrenLandList;
    /**
     * Width of the land, both fertile and barren.
     */
    private final int WIDTH = 400;
    /**
     * Height of the land, both fertile and barren.
     */
    private final int HEIGHT = 600;

    /**
     * Setup run before each test.
     */
    @Before
    public void setUp() {
        mBarrenLandList = new ArrayList<>();
    }

    /**
     * Tear down run after each test.
     */
    @After
    public void tearDown() {
        mBarrenLandList = null;
    }

    /**
     * Tests input with a single list of coordinates.
     */
   @Test
    public void testGetFertileLandAreaSingleInput() {
       String expectedFertileLand = "116800 116800";
       mBarrenLandList.add(new int[] {0, 292, 399, 307});
       mBarrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, mBarrenLandList);

       assertEquals(expectedFertileLand, mBarrenLandAnalysis.getFertileLandArea());
    }

    /**
     * Tests input with multiple list of coordinates.
     */
    @Test
    public void testGetFertileLandAreaMultipleInput() {
        String expectedFertileLand = "22816 192608";
        mBarrenLandList.add(new int[] {48, 192, 351, 207});
        mBarrenLandList.add(new int[] {48, 392, 351, 407});
        mBarrenLandList.add(new int[] {120, 52, 135, 547});
        mBarrenLandList.add(new int[] {260, 52, 275, 547});
        mBarrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, mBarrenLandList);

        assertEquals(expectedFertileLand, mBarrenLandAnalysis.getFertileLandArea());
    }

    /**
     * Tests null set of barren data.
     */
    @Test (expected = NullPointerException.class)
    public void testGetFertileLandAreaNullData() {
        mBarrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, null);

        mBarrenLandAnalysis.getFertileLandArea();
    }

    /**
     * Tests empty set of barren data
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetFertileLandAreaEmptyData() {
        mBarrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, mBarrenLandList);

        mBarrenLandAnalysis.getFertileLandArea();
    }

    /**
     * Tests invalid size of barren data, smaller.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetFertileLandAreaInvalidCoordinatesSizeSmaller() {
        mBarrenLandList.add(new int[] {1, 2, 3});
        mBarrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, mBarrenLandList);

        mBarrenLandAnalysis.getFertileLandArea();
    }

    /**
     * Tests invalid size of barren data, larger.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetFertileLandAreaInvalidCoordinatesSizeLarger() {
        mBarrenLandList.add(new int[] {1, 2, 3, 4, 5});
        mBarrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, mBarrenLandList);

        mBarrenLandAnalysis.getFertileLandArea();
    }

    /**
     * Tests invalid coordinates for X1.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetFertileLandAreaInvalidCoordinatesX1() {
        mBarrenLandList.add(new int[] {-1, 1, 1, 1});
        mBarrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, mBarrenLandList);

        mBarrenLandAnalysis.getFertileLandArea();
    }

    /**
     * Tests invalid coordinates for Y1.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetFertileLandAreaInvalidCoordinatesY1() {
        mBarrenLandList.add(new int[] {1, -1, 1, 1});
        mBarrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, mBarrenLandList);

        mBarrenLandAnalysis.getFertileLandArea();
    }

    /**
     * Tests invalid coordinates for X2.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetFertileLandAreaInvalidCoordinatesX2() {
        mBarrenLandList.add(new int[] {1, 1, -1, 1});
        mBarrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, mBarrenLandList);

        mBarrenLandAnalysis.getFertileLandArea();
    }

    /**
     * Tests invalid coordinates for Y2.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetFertileLandAreaInvalidCoordinatesY2() {
        mBarrenLandList.add(new int[] {1, 1, 1, -1});
        mBarrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, mBarrenLandList);

        mBarrenLandAnalysis.getFertileLandArea();
    }

    /**
     * Tests invalid coordinates for X1, being above the graph width.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetFertileLandAreaInvalidCoordinatesX1AboveWidth() {
        mBarrenLandList.add(new int[] {WIDTH, 1, 1, 1});
        mBarrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, mBarrenLandList);

        mBarrenLandAnalysis.getFertileLandArea();
    }

    /**
     * Tests invalid coordinates for Y1, being above the graph height.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetFertileLandAreaInvalidCoordinatesY1AboveHeight() {
        mBarrenLandList.add(new int[] {1, HEIGHT, 1, 1});
        mBarrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, mBarrenLandList);

        mBarrenLandAnalysis.getFertileLandArea();
    }

    /**
     * Tests invalid coordinates for X2, being above the graph width.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetFertileLandAreaInvalidCoordinatesX2AboveWidth() {
        mBarrenLandList.add(new int[] {1, 1, WIDTH, 1});
        mBarrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, mBarrenLandList);

        mBarrenLandAnalysis.getFertileLandArea();
    }

    /**
     * Tests invalid coordinates for Y2, being above the graph height.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetFertileLandAreaInvalidCoordinatesY2AboveHeight() {
        mBarrenLandList.add(new int[] {1, 1, 1, HEIGHT});
        mBarrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, mBarrenLandList);

        mBarrenLandAnalysis.getFertileLandArea();
    }

    /**
     * Tests get height.
     */
    @Test
    public void testGetHeight(){
        int expectedHeight = HEIGHT;

        mBarrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, null);
        assertEquals(expectedHeight, mBarrenLandAnalysis.getGraphHeight());
    }

    /**
     * Tests get width.
     */
    @Test
    public void testGetWidth(){
        int expectedWidth = WIDTH;

        mBarrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, null);
        assertEquals(expectedWidth, mBarrenLandAnalysis.getGraphWidth());
    }

    /**
     * Tests get graph.
     */
    @Test
    public void testGetGraph(){
        int[][] expectedGraph = new int[WIDTH][HEIGHT];

        mBarrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, null);
        Assert.assertArrayEquals(expectedGraph, mBarrenLandAnalysis.getGraph());
    }

    /**
     * Tests get barren list.
     */
    @Test
    public void testGetBarrenList(){
        List<int[]> expectedBarrenLandList = new ArrayList<>();
        int[] data = new int[] {0, 292, 399, 307};
        expectedBarrenLandList.add(data);

        mBarrenLandAnalysis = new BarrenLandAnalysis(WIDTH, HEIGHT, expectedBarrenLandList);
        assertEquals(expectedBarrenLandList, mBarrenLandAnalysis.getBarrenLandList());
    }
}
