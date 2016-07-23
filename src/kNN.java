import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by adithyasukumar on 2016-07-23.
 */
public class kNN {

    // The classification
    int classify;

    
    public kNN(int[][] a, int[] b, int k) {

        // Creates an ArrayList of Double arrays to be filled in the form {label, distance}
        ArrayList<Double[]> distances = new ArrayList<Double[]>();

        for(int i = 0; i < a.length; i++){

            int sum = 0;

            for(int j = 1; j < a[i].length; j++){

                sum = sum + (a[i][j] - b[j-1])*(a[i][j] - b[j-1]);

            }

            // Finds the Euclidean distance to the point
            Double distance = Math.sqrt(sum);

            // Adds the point to the distances ArrayList
            Double[] classify = {(double) a[i][0],distance};
            distances.add(classify);

        }

        // Sorts the points in ascending order of distance
        distances.sort(new Comparator<Double[]>() {

            @Override
            public int compare(final Double[] a, final Double[] b) {
                final Double time1 = a[1];
                final Double time2 = b[1];
                return time1.compareTo(time2);
            }

        });

        // Finds the most popular label for the first k points
        int max = 0;
        int classification = 0;

        for(int i = 0; i < k; i++){

            int num = distances.get(i)[0].intValue();
            int count = 0;

            for(int j = 0; j < k; j++){

                if(distances.get(j)[0].intValue() == num) {

                    count++;

                }

            }

            if(count > max){

                max = count;
                classification = num;

            }

        }

        classify = classification;

    }

    public int getClassify(){

        return classify;

    }

}
