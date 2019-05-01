import java.lang.reflect.Array;
import java.util.Arrays;

public class TrappingRainWater {

    public static int trapRainWater(int [] waterLevel){

        int trapped_water = 0;

        if(waterLevel.length == 0)
            return 0;

        int [] left_max_height = new int[waterLevel.length];
        int [] right_max_height = new int[waterLevel.length];

        left_max_height[0] = waterLevel[0];
        right_max_height[waterLevel.length-1] = waterLevel[waterLevel.length-1];


        for(int l = 1 ;l < waterLevel.length; l++){
            left_max_height[l] = Math.max(waterLevel[l], left_max_height[l-1]);
        }


        for(int r = waterLevel.length - 2 ; r >= 0; r--){
            right_max_height[r] = Math.max(waterLevel[r], right_max_height[r+1]);
        }


        for(int index = 0; index < waterLevel.length; index++){
            trapped_water += Math.min(left_max_height[index], right_max_height[index]) - waterLevel[index];
        }
        return trapped_water;
    }

    public static void main(String[] args) {
        int [] waterLevel = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapRainWater(waterLevel));
    }
}
