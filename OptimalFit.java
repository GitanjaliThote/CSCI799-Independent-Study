import java.util.Arrays;
import java.util.Collections;

public class OptimalFit {

    public static int firstFit(Integer weight[], int n, int c)
    {
        int count_bin = 0;


        int [] bins = new int[n];


        for (int i=0; i<n; i++)
        {

            int j;
            for (j=0; j<count_bin; j++)
            {
                if (bins[j] >= weight[i])
                {
                    bins[j] = bins[j] - weight[i];
                    break;
                }
            }


            if (j==count_bin)
            {
                bins[count_bin] = c - weight[i];
                count_bin++;
            }
        }
        return count_bin;
    }
    public static int  firstFitDec(Integer weight[], int n, int c)
    {
        Arrays.sort(weight, Collections.reverseOrder());

        return firstFit(weight, n, c);
    }

    public static void main(String[] args)
    {
//        int weight[] = {2, 5, 4, 7, 1, 3, 8};
        Integer weight[] = {8,5,1,2,};
        int c = 10;
        int n = weight.length ;
        System.out.println("Number of bins required in Best Fit : "
                + firstFitDec(weight, n, c));
    }
}
