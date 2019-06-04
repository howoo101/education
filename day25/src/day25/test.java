package day25;

import java.util.ArrayList;

public class test {
	public static void main(String[] args) {
		int answer = 1;
		int n = 100000;
		long[] b = new long[n + 1];
		b[0] = 0;
		b[1] = 1;
		b[2] = 2;
		for (int i = 3; i <= n; i++) {
			if (i % 2 == 0)
				b[i] = 0;
			else
				b[i] = i;
		}
		for (long i = 3; i < b.length; i++) {
			for (long j = i * i; j <= n; j += i) {
				b[(int) j] = 0;
			}
		}
		for (int i = 3; i < b.length; i += 2) {
			if (b[i] != 0)
				answer++;
		}

		System.out.println(answer);
	}
}
