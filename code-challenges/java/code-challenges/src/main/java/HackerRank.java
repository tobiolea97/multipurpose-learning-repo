import java.util.Arrays;
import java.util.List;

public class HackerRank {

    public static void plusMinus(List<Integer> arr) {
        Double  positiveRatio = 0d,
                negativeRatio = 0d,
                zeroRatio = 0d;

        positiveRatio = Double.valueOf(arr.stream()
                .filter(n -> n > 0)
                .count() / arr.size());
        negativeRatio = Double.valueOf(arr.stream()
                .filter(n -> n < 0)
                .count() / (double)arr.size());

        zeroRatio = Double.valueOf(arr.stream()
                .filter(n -> n == 0)
                .count() / arr.size());

        System.out.printf("%.6f\n", positiveRatio);
        System.out.printf("%.6f\n", negativeRatio);
        System.out.printf("%.6f\n", zeroRatio);

    }

    public static void miniMaxSum(List<Integer> arr) {
        long    min = Long.MAX_VALUE,
                max = Long.MIN_VALUE;

        for(int i = 0; i < arr.size(); i++) {
            long currentMin = 0, currentMax = 0;
            for(int j = 0; j < arr.size(); j++) {
                if(i==j)
                    continue;
                currentMin += Long.valueOf(arr.get(j));
                currentMax += Long.valueOf(arr.get(j));
            }

            min = min < currentMin ? min : currentMin;
            max = max > currentMax ? max : currentMax;
        }


        System.out.printf("%d %d", min, max);
    }

    public static String timeConversion(String s) {
        if(s.length() == 8)
            return s;

        int hour = Integer.valueOf(s.substring(0, 2)) + 12;
        hour = hour >= 24 ? hour - 24 : hour;

        return new StringBuilder("")
                .append(String.valueOf(hour))
                .append(s.substring(2, 8))
                .toString();

    }

    public static void main(String[] args) {
//        plusMinus(Arrays.asList(-4,3,-9,0,4,1));
//        miniMaxSum(Arrays.asList(256741038,623958417,467905213,714532089,938071625));
        System.out.println(timeConversion("07:05:45PM"));
    }

}
