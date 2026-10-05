class Solution {
    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        return rec(num,0).trim();
    }
    public String rec(int num, int c){
        //base case 
        if(num==0){
            return "";
        }
        StringBuilder ans = new StringBuilder();
        int temp =num;
        if(num/1000>0){
            temp=num%1000;
            String t = rec(num/1000, c+1);
            ans.append(t);
        }
        String tempres = helper(temp);
        String[] bigNum = new String[]{"", "Thousand ", "Million ", "Billion "};
        ans.append(tempres);
        if(c>=0 && temp!=0){
            ans.append(bigNum[c]);
        }
        return ans.toString();
    }
    public String helper(int num){ //actually making num to words 
        String[] digits = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teens = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = new String[]{"","", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        String res = "";
        if(num>99){
            res += digits[num/100] + " Hundred ";
        }
        num%=100;
        if(num<20 && num>9){
            res += teens[num%10] + " ";
        }
        else{
            if(num>19){
                res += tens[num/10] + " ";
            }
            num = num%10;
            if(num>0){
                res +=digits[num] + " ";
            }
        }
        return res;
    }
}