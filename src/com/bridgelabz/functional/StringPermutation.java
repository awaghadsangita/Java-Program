/*
 * @purpose	:find the all permutation of given string
 * @author	:sangita awaghad
 * @since	:31-07-2019
 */
package com.bridgelabz.functional;
import java.util.ArrayList;
import com.bridgelabz.utility.Utility;

public class StringPermutation {
	static int count = 0;
	static ArrayList<String> permutation = new ArrayList<String>();

	public static void main(String args[]) {
		Utility utility = new Utility();
		int totalPermuation = 1;

		System.out.println("Enter String");
		String s = utility.getString();

		for (int i = 1; i <= s.length(); i++) {
			totalPermuation = totalPermuation * i;
		}

		permute(s, 0, s.length() - 1, totalPermuation);

	}

	public static void permute(String s, int l, int r, int totalPermuation) {
		Utility utility = new Utility();

		if (l == r) {
			permutation.add(s);
			count++;
			if (count == totalPermuation) {
				String[] arr = new String[permutation.size()];
				permutation.toArray(arr);
				int i;
				int j;
				int k = 0;
				for (i = 0; i < count; i++) {
					for (j = 0; j < i; j++) {
						if (arr[j].compareTo(arr[i]) == 0)
							break;
					}
					if (i == j) {
						arr[k] = arr[i];
						k++;
					}
				}

				System.out.print("\n" + k + " Permuation are as follows\n");
				for (int itr = 0; itr < k; itr++) {
					System.out.print(arr[itr] + " ");
				}
			}
		} else {
			for (int i = l; i <= r; i++) {
				s = utility.swap(s, l, i);
				permute(s, l + 1, r, totalPermuation);
				s = utility.swap(s, l, i);
			}
		}

	}
}
