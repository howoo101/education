package project;

import java.util.*;

public class Code4 {

    public static void main(String[] args) {
        // 사용자로부터 n개의 정수를 입력받고
        // 정수가 하나씩 입력될 때 마다 현재까지 입력된 정수들을 
        // 오름차순으로 정렬하여 출력하라
        
        //입력받은 숫자들중에서 뒤에서 부터 검사를해서 넣으려는 숫자보다 크면
        // 한자리 뒤로 넘기고 계속 검사하다가 넣으려는 숫자보다 작은수가 나오면
        // 마지막으로 시프트한 자리에 넣어주면 된다. 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        
        for(int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            int j = i;
            while(j >= 1 && data[j-1] > tmp) {
                data[j] = data[j-1];
                j--;
            }
            data[j] = tmp;
            System.out.println(Arrays.toString(data));
        }
        sc.close();
        
    }
}
