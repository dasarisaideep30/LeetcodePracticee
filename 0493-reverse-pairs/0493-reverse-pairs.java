class Solution {
    public int reversePairs(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    private int sort(int[] a, int l, int r) {
        if (l >= r) return 0;
        int m = l + (r - l) / 2;
        int c = sort(a, l, m) + sort(a, m + 1, r);

        int j = m + 1;
        for (int i = l; i <= m; i++) {
            while (j <= r && (long)a[i] > 2L * a[j]) j++;
            c += j - m - 1;
        }

        int[] t = new int[r - l + 1];
        int i = l, k = 0;
        j = m + 1;
        while (i <= m && j <= r) t[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= m) t[k++] = a[i++];
        while (j <= r) t[k++] = a[j++];
        System.arraycopy(t, 0, a, l, t.length);

        return c;
    }
}