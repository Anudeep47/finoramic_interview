public class Solution {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int n = A.size();
        int close_sum = A.get(0)+A.get(1)+A.get(2);
        for(int i=0; i<n-2; i++){
            int j=i+1, k=n-1;
            while(j<k){
                int sum = A.get(i)+A.get(j)+A.get(k);
                if(sum == B)return sum;
                if(Math.abs(sum-B) < Math.abs(close_sum-B)){
                    close_sum = sum;
                }
                if(sum < B)j++;
                else k--;
            }
        }
        return close_sum;
    }
}
