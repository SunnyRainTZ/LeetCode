/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

public String longestCommonPrefix(String[] strs) {
    if(strs.length == 0) return "";
    String longestPrefix = strs[0];
    for(int i=1;i<strs.length;i++){
        for(int j=0;j<=strs[i].length()&&j<=longestPrefix.length();j++){
            if(!strs[i].substring(0,j).equals(longestPrefix.substring(0,j))){
              longestPrefix =strs[i].substring(0,j-1);
              System.out.println(longestPrefix);
                break;
            }
            if(j==strs[i].length()){
              longestPrefix = strs[i];
            }
        }
    }
    return longestPrefix;
  }
