public class Code2 {

    
    /*
        n개의 음이 아닌 한 자리 정수를 입력받아 배열에 저장한다. 
        이들중에서 1개 이상의 연속된 정수들을 합하여(각 자리수로) 얻을 수 있는 소수 들중에서
        최대값을 구하는 프로그램 
    */
    
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int[] data = new int[n];
        
         for(int i = 0; i < n; i++)
             data[i] = sc.nextInt();
         sc.close();
        
         int max = 0;
         for(int i = 0; i < n; i++) {
             int val = 0;
             for(int j = i; j < n; j++) {
                 //배열의 각자리수로 더해서  소수판단 해야한다.
                 val = val *10 + data[j];
                
                 //val >1인경우만 소수판단 해줌
                 boolean isPrime = true;
                 for(int k = 2; k*k <= val && isPrime; k++) {
                     if(val % k == 0) isPrime = false;
                 }
                
                 if(isPrime && val > 1 && val > max) max = val;
             }
         }
         if(max > 0) System.out.println(max);
         else System.out.println("no prime");
     }
}