package leetcode.google;

public class DecodeString_394 {
    public static void main(String[] args) {
        System.out.println(new DecodeString_394().decodeString("3[a]2[bc]"));
    }

    public String decodeString(String s) {
        return helper(s);
    }

    private int index = 0;
    private String helper(String s) {
        StringBuilder str = new StringBuilder();

        while(index < s.length()) {
            char curt = s.charAt(index++);
            if(Character.isLetter(curt)) str.append(curt);
            else if(Character.isDigit(curt)) {
                String temp = String.valueOf(curt);
                while(s.charAt(index) != '[')
                    temp += String.valueOf(s.charAt(index++));

                int num = Integer.valueOf(temp);
                String base = helper(s);

                for(int i = 0; i < num; i++)
                    str.append(base);
            } else if(curt == ']') break;
        }
        return str.toString();
    }
}
