package code.problems.array.hashing;

public class ProductExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int n =  nums.length;
        if (n == 0)
            return new int[0];
        int[] lprod = new int[n]; lprod[0] = 1;
        int[] rprod = new int[n]; rprod[n-1] = 1;
        int[] prod = new int[n];

        for (int i=1;i<n;i++){
            lprod[i] =  lprod[i-1]*nums[i-1];
        }

        for (int i=n-2;i>=0;i--){
            rprod[i] =  rprod[i+1]*nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            prod[i] =  lprod[i] * rprod[i];
        }
        return prod;
    }
}
