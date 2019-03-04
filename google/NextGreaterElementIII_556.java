package leetcode.google;

public class NextGreaterElementIII_556 {

    public int nextGreaterElement(int n) {
        if(n >= 0 && n <= 10) return -1;

        char[] chs = String.valueOf(n).toCharArray();
        int i = chs.length - 2;
        while(i >= 0 && chs[i + 1] <= chs[i]) i--;

        if(i < 0) return -1;

        int j = chs.length - 1;
        while(j >= 0 && chs[j] <= chs[i]) j--;

        swap(chs, i, j);
        reverse(chs, i + 1, chs.length - 1);

        try {
            return Integer.parseInt(String.valueOf(chs));
        } catch(Exception e) {
            return -1;
        }
    }

    private void reverse(char[] chs, int left, int right) {
        while(left < right) {
            swap(chs, left, right);
            left++; right--;
        }
    }

    private void swap(char[] chs, int left, int right) {
        char temp = chs[left];
        chs[left] = chs[right];
        chs[right] = temp;
    }
}
