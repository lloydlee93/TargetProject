package test.java;

import main.java.StringConverterUtility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Unit test class for StringConverterUtility.java
 */
public class StringConverterUtilityTest {
    /**
     * Coordinates of the barren land.
     */
    ArrayList<String> mCoordinatesList;

    /**
     * Setup run before each test.
     */
    @Before
    public void setUp() {
        mCoordinatesList = new ArrayList<>();
    }

    /**
     * Tear down run after each test.
     */
    @After
    public void tearDown() {
        mCoordinatesList = null;
    }

    /**
     * Tests valid coordinates
     */
    @Test
    public void testValidCoordinates(){
        mCoordinatesList.add("0 292 399 307");
        int[] coordinates = StringConverterUtility.getCoordinates(mCoordinatesList).get(0);

        assertEquals(0, coordinates[0]);
        assertEquals(292, coordinates[1]);
        assertEquals(399, coordinates[2]);
        assertEquals(307, coordinates[3]);
    }

    @Test
    public void testMultipleValidCoordinates(){
        mCoordinatesList.add("0 292 399 307");
        mCoordinatesList.add("9999 651561 56151 1111111");
        int[] coordinates1 = StringConverterUtility.getCoordinates(mCoordinatesList).get(0);
        int[] coordinates2 = StringConverterUtility.getCoordinates(mCoordinatesList).get(1);

        assertEquals(0, coordinates1[0]);
        assertEquals(292, coordinates1[1]);
        assertEquals(399, coordinates1[2]);
        assertEquals(307, coordinates1[3]);

        assertEquals(9999, coordinates2[0]);
        assertEquals(651561, coordinates2[1]);
        assertEquals(56151, coordinates2[2]);
        assertEquals(1111111, coordinates2[3]);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testInvalidCoordinateSizeSmaller() {
        mCoordinatesList.add("0 292 399");

        StringConverterUtility.getCoordinates(mCoordinatesList);
    }


    @Test (expected = IllegalArgumentException.class)
    public void testInvalidCoordinateSizeLarger() {
        mCoordinatesList.add("0 292 399 515 15");

        StringConverterUtility.getCoordinates(mCoordinatesList);
    }

    @Test
    public void testWhiteSpaceDataIsCorrected(){
        mCoordinatesList.add("     0    292 \n\n\n\t   399      307   \n\n\n\t\t\t\t  ");
        int[] coordinates = StringConverterUtility.getCoordinates(mCoordinatesList).get(0);

        assertEquals(0, coordinates[0]);
        assertEquals(292, coordinates[1]);
        assertEquals(399, coordinates[2]);
        assertEquals(307, coordinates[3]);
    }

    @Test
    public void testSpecialCharactersDataIsCorrected(){
        mCoordinatesList.add("{0 292....399..!@#$%^&*()307}");
        int[] coordinates = StringConverterUtility.getCoordinates(mCoordinatesList).get(0);

        assertEquals(0, coordinates[0]);
        assertEquals(292, coordinates[1]);
        assertEquals(399, coordinates[2]);
        assertEquals(307, coordinates[3]);
    }

    @Test
    public void testAlphabetDataIsCorrected(){
        mCoordinatesList.add("0 is the first coordinate, 292 is the second coordinate, 399 is the third coordinate, 307 is the fourth coordinat.asdfghjkl;qwertyuiop.zxcvbnm.");
        int[] coordinates = StringConverterUtility.getCoordinates(mCoordinatesList).get(0);

        assertEquals(0, coordinates[0]);
        assertEquals(292, coordinates[1]);
        assertEquals(399, coordinates[2]);
        assertEquals(307, coordinates[3]);
    }

}
