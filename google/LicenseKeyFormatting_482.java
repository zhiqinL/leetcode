package leetcode.google;

public class LicenseKeyFormatting_482 {
    public static void main(String[] args) {
        LicenseKeyFormatting_482 test = new LicenseKeyFormatting_482();
        System.out.println(test.licenseKeyFormatting("2", 2));
    }

    public String licenseKeyFormatting(String S, int K) {
        char[] chs = S.replaceAll("-", "").toUpperCase().toCharArray();
        int partition = chs.length % K;

        if(partition == 0) partition = K;

        StringBuilder res = new StringBuilder();
        int count = 0;
        for(char ch : chs) {
            if(count == partition) {
                res.append('-');
                partition = K;
                count = 0;
            }
            res.append(ch);
            count++;
        }
        return res.toString();
    }
}
