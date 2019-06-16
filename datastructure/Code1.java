public class Code1 {

    /**
     * n개의 정수를 입력받아 배열에 저장
       이들중에서 0개 이상의 연속된 정수들을 더하여 얻을수있는 최대값을 구하는 프로그램 
     */
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int[] data = new int[n];
        
         for(int i = 0; i < n; i++)
             data[i] = sc.nextInt();
         sc.close();
        
         int maxSum = 0;
        
         for(int i= 0; i < n; i++) {
             int sum = 0;
             for(int j = i; j < n; j ++) {
                 sum += data[j];
                 if(maxSum < sum) maxSum = sum;
             }
         }
        
         System.out.println(maxSum);
        
     }
}