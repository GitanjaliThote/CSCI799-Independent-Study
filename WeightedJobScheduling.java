import java.util.Arrays;
import java.util.Comparator;

public class WeightedJobScheduling {

    public static class Job{
        int start;
        int finish;
        int profit;

        Job(int s, int e, int p){
            start = s;
            finish = e;
            profit =p;
        }


        public String toString() {
            System.out.println(start + " " + finish + " "+ profit);
            return "";
        }
    }

    public static int findLatestNonOverLappingJob(Job[]jb, int index){
       int start =0;
       int end = index-1;
       while(start<=end){
           int mid = (start + end)/2;
           if(jb[mid].finish <= jb[index].start && jb[mid + 1].finish > jb[index].start){
               return mid;
           } else if(jb[mid].finish < jb[index].start ){
               start = mid + 1;
           } else{
               end = mid -1;
           }
       }

       return -1;
    }
    public static int maxNonOverLappingProfit(Job[] jb){

        Arrays.sort(jb, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.finish-o2.finish;
            }
        });

        System.out.println(jb.toString());

        if(jb.length == 0){
            return 0;
        }
        int maxProfit = jb[0].profit;

        int [] currProfit = new int[jb.length];
        currProfit[0] = maxProfit;

        for(int i =1; i<jb.length;i++){

            int idx = findLatestNonOverLappingJob(jb,i);
            if(idx != -1){
                currProfit[i] = Math.max(jb[i].profit,jb[i].profit+currProfit[idx]);
            } else{
                currProfit[i] = jb[i].profit;
            }
            maxProfit = Math.max(maxProfit,currProfit[i]);


        }

//        System.out.println(currProfit);
        return maxProfit;

    }

    public static void main(String[] args) {

        Job arr[] = {new Job(1, 2, 200),new Job(3, 5, 20),new Job(3, 10, 20), new Job(2, 10, 50),new Job (6, 19, 100)};

        System.out.println(maxNonOverLappingProfit(arr));

    }
}
