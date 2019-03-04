package leetcode.google;

public class ReadNCharactersGivenRead4II_158 {
    int index = 0, num = 0;
    char[] temp = new char[4];
    public int read(char[] buf, int n) {
        int i = 0;
        while(i < n) {
            if(index == num) {
                num = read4(temp);
                index = 0;
                if(num == 0) break;
            }
            buf[i++] = temp[index++];
        }
        return i;
    }

    int read4(char[] buf) {
        return -1;
    }
}
