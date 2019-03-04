package leetcode.google;

public class BackspaceStringCompare_844 {
    public static void main(String[] args) {
        BackspaceStringCompare_844 test = new BackspaceStringCompare_844();
        test.backspaceCompare("xywrrmp", "xywrrmu#p");
    }

    public boolean backspaceCompare(String S, String T) {
        return generate(S).equals(generate(T));
    }

    private String generate(String str) {
        StringBuilder temp = new StringBuilder();
        for(char ch : str.toCharArray()) {
            if(ch == '#') {
                if (temp.length() > 0) temp.deleteCharAt(temp.length() - 1);
            } else temp.append(ch);
        }
        return temp.toString();
    }
}
