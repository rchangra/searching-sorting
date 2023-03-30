
class Mergesort {

	public static void conquer(int arr[], int li, int ri, int mid) {
		int merged[] = new int[ri-li + 1];

		int index1 = li;
		int index2 = mid+1;
		int x = 0;
		while (index1 <= mid && index2 <= li) {
			if (arr[index1] <= arr[index2]) {
				merged[x++] = arr[index1++];
			} else {
				merged[x++] = arr[index2++];
			}
		}
		while (index1 <= mid) {
			merged[x++] = arr[index1++];
		}

		while (index2 <= mid) {
			merged[x++] = arr[index2++];
		}
		for (int i = 0, j = li; i < merged.length; i++, j++) {
			arr[j] = merged[i];
		}

	}

	public static void divide(int arr[], int li, int ri) {
		if (li > ri) {
			return;
		}
		int mid =li +(li-ri)/2;
		
		divide(arr,li,mid);
		divide(arr,mid+1,ri);
		conquer(arr, li, mid, ri);

	}

	public static void main(String arg[]) {
		int arr[] = { 15, 55, 5, 69, 22, 89 };
		int n = arr.length;
		divide(arr, 0, n-1);
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i] + " ");
		}
		System.out.println();
	}
}
