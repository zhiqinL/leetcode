package leetcode.google;

public class SwapAdjacentinLRString_777 {
    public static void main(String[] args) {
        String start = "RXXLRXRXL";
        String end = "XRLXXRRLX";
        System.out.println(new SwapAdjacentinLRString_777().canTransform(start, end));
    }


    public boolean canTransform(String start, String end) {
//        if(start.length() != end.length()) return false;
//        int len = start.length();
//
//        int eIndex = len - 1, sIndex = len - 1;
//        while(eIndex >= 0) {
//            while(eIndex >= 0 && end.charAt(eIndex) != 'R') eIndex--;
//            while(sIndex >= 0 && start.charAt(sIndex) != 'R') sIndex--;
//
//            if(sIndex < 0 && eIndex > 0) return false;
//            if(sIndex > eIndex) return false;
//
//            if(eIndex < 0) break;
//
//            int index = sIndex;
//            while(index <= eIndex) {
//                if(start.charAt(index++) == 'L') return false;
//            }
//
//            eIndex--;
//            sIndex--;
//        }
//
//        sIndex = 0; eIndex = 0;
//        while(eIndex < len) {
//            while(sIndex < len && start.charAt(sIndex) != 'L') sIndex++;
//            while(eIndex < len && end.charAt(eIndex) != 'L') eIndex++;
//
//            if(sIndex == len && eIndex < len) return false;
//            if(sIndex < eIndex) return false;
//
//            if(eIndex == len) break;
//
//            int index = sIndex;
//            while(index >= eIndex) {
//                if(start.charAt(index--) == 'R') return false;
//            }
//
//            sIndex++;
//            eIndex++;
//        }
//
//        return true;

        int len = start.length();

        int sIndex = 0, eIndex = 0;
        while(sIndex < len && eIndex < len) {
            while(sIndex < len && start.charAt(sIndex) == 'X') sIndex++;
            while(eIndex < len && end.charAt(eIndex) == 'X') eIndex++;

            if(!((sIndex < len) && (eIndex < len))) return false;

            if(start.charAt(sIndex) != end.charAt(eIndex)) return false;

            if(start.charAt(sIndex) == 'L') {
                if(sIndex < eIndex) return false;
            } else {
                if(sIndex > eIndex) return false;
            }

            sIndex++; eIndex++;
        }
        return true;
    }
}
