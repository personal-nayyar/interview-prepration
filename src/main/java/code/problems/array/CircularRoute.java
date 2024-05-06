package code.problems.array;

public class CircularRoute {

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] cost = {6, 5, 3, 5};
        System.out.println(findStartIndex(petrol, cost));

        petrol = new int[]{1,2,3,4,5};
        cost = new int[]{3,4,5,1,2};
        System.out.println(findStartIndex(petrol, cost));

        petrol = new int[]{2,3,4};
        cost = new int[]{3,4,3};
        System.out.println(findStartIndex(petrol, cost));

        petrol = new int[]{4,6,7,4};
        cost = new int[]{6,5,3,5};
        System.out.println(findStartIndex(petrol, cost));


        petrol = new int[]{6,3,7};
        cost = new int[]{4,6,3};
        System.out.println(findStartIndex(petrol, cost));


    }

    static int findStartIndex(int[] petrol, int cost[]){
        int petrolSum = 0, costSum = 0;
        for(int i = 0; i < petrol.length; i++){
            petrolSum += petrol[i];
            costSum += cost[i];
        }
        if(petrolSum < costSum){ // if total cost is greater than total petrol, no possible solution
            return -1;
        }
        int start = 0;
        int curr = 0;
        for(int i = 0; i < petrol.length; i++){
            curr += petrol[i] - cost[i];
            if(curr < 0){
                start = i + 1;
                curr = 0;
            }
        }
        return start;
    }

    static int findStartIndex2(int[] petrol, int cost[]){
        int start = 0, end = 1;
        int curr = 0;
        while (curr < 0 || start != end){
            while(curr < 0 && start!= end){ // if curr is negative, to find possible start
                curr += petrol[start] - cost[start];
                start = (start + 1) % cost.length;
                if(start == 0){
                    return -1;
                }
            }
            curr += petrol[end] - cost[end];
            end = (end + 1) % cost.length;
        }
        return start;
    }

}
