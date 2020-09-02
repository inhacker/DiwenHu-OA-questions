package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Main test = new Main();
        String result = test.mergeTwoString("hello", "lobster");
        System.out.println(result);
    }
    private String mergeTwoString(String one, String two){
        if(one == null && two == null){
            return "";
        }
        if(one == null || two == null){
            return one == null ? two : one;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while(i < one.length() && j < two.length()){
            sb.append(one.charAt(i++));
            sb.append(two.charAt(j++));
        }
        while(i < one.length()){
            sb.append(one.charAt(i++));
        }
        while(j < two.length()){
            sb.append(two.charAt(j++));
        }
        return sb.toString();
    }
}
