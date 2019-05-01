import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static int findLongestIncreasingSubsequence(int []arr){

        int len = 0;
        int []tempIndex = new int[arr.length];
        int []tracePath = new int[arr.length];


        for(int i =0; i<tracePath.length;i++){
            tracePath[i] = -1;
        }

        tempIndex[0] = 0;
        int lastfilledIdx  = 0;

        for(int i=1; i <arr.length;i++){
            if(arr[i]>arr[tempIndex[lastfilledIdx]]){
                lastfilledIdx++;
                tempIndex[lastfilledIdx] = i;
                len++;
                tracePath[i] = tempIndex[lastfilledIdx-1];
            } else if( arr[i] < arr[tempIndex[0]] ){
                tempIndex[0] = i;
            } else{
                int st = 0;
                int ed = lastfilledIdx;
                int repIdx = 0;

                while(st <=  ed  ){
                    int idx = (st +  ed )/2;
                    if(idx < lastfilledIdx && arr[tempIndex[idx]] < arr[i] && arr[i] <= arr[tempIndex[idx+1]]){
                        repIdx = idx + 1;
                        break;
                    } else if(arr[i]>=arr[tempIndex[idx]]){
                        st = idx + 1;
                    }
                    else{
                        ed = idx-1;
                    }
                }

                tempIndex[repIdx] = i;
                tracePath[i] = tempIndex[repIdx - 1];

            }
        }

        for(Integer i : tracePath){
            System.out.println(i);
        }

        System.out.println("-----------");

        return len;
    }



    //[2,5,3,4,7]
    public static void main(String[] args) {
        int [] arr = new int[]{3,4,-1,5,8,2,3,12,7,9,10};
        System.out.println("--------");
        System.out.println(findLongestIncreasingSubsequence(arr));
    }
}
