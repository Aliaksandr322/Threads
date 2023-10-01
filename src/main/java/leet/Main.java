package leet;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrom(121));
        System.out.println(toArabInt("MMMCMXCIV"));
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
    public static boolean isPalindrom(int x){
        String str = ("" + x).toString();
        StringBuilder sb = new StringBuilder(str);
        if(str.equals(sb.reverse().toString()))return true;
        else return false;
    }

    public static int toArabInt(String number){
        final  String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        final  int[] DECIMAL_VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int result = 0;
        String str = number;
        for (int i = 0; i < ROMAN_NUMERALS.length; i++){
            int decimalVal = DECIMAL_VALUES[i];
            String romanNumeralToCheck = ROMAN_NUMERALS[i];
            while (str.startsWith(romanNumeralToCheck)){
                result += decimalVal;
                str = str.substring(romanNumeralToCheck.length());
            }
        }
        return result;
    }

    public static String longestCommonPrefix(String[] strs) {
        String smallestWord = strs[0];
        for (int i = 1 ; i < strs.length ; i++) {
            if ((strs[i].compareTo(smallestWord)) < 0) {
                smallestWord = strs[i];
            }
        }
        String result = "";
        for(int i = 0; i < smallestWord.length(); i++){
            char ch = strs[0].charAt(i);
            boolean isTrue = false;
            for(int j = 0; j < strs.length; j++){
                if (strs[j].charAt(i) == ch){
                    isTrue = true;
                }
                else {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) result += ch;
            else break;
            isTrue = false;
        }
        return result ;
    }


    public static int removeDuplicates(int[] nums) {
        int[] newNums = new int[nums.length];
        int indexCounter = 0;



        nums = newNums;
        System.out.println(Arrays.toString(nums));
        return nums.length;
    }
}
