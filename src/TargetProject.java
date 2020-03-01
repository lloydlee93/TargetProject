import java.util.List;

public class TargetProject {
    public static void main(String args[]) {
        String temporaryData[] = {"{48 192 351 515207}", "48 392 351 407     ", "   120 52 135 547", "    52 275 547      551   "};
        List<int[]> list = StringConverterUtility.getCoordinates(temporaryData);
    }
}
