class Solution {
    public boolean isSubsequence(String s, String t) {
        int ss=0;
        int tt=0;
        while(ss<s.length() && tt<t.length()){
            if(s.charAt(ss)==t.charAt(tt)){
                ss++;
            }
            tt++;
        }
        return ss==s.length();
    }
}