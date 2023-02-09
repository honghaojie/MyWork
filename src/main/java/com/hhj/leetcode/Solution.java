package com.hhj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
      String[] folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
      removeSubfolders(folder);
    }

    public static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> newFolders = new ArrayList();
        newFolders.add(folder[0]);
        for(int i = 1;i<folder.length;i++){
            int pre = newFolders.get(newFolders.size()-1).length();
            if(!(pre<folder[i].length()&&newFolders.get(newFolders.size()-1).equals(folder[i].substring(0,pre))&&folder[i].charAt(pre) == '/')){
                newFolders.add(folder[i]);
            }
        }
        return newFolders;
    }

 /*   public static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<String>();
        ans.add(folder[0]);
        for (int i = 1; i < folder.length; ++i) {
            int pre = ans.get(ans.size() - 1).length();
            if (!(pre < folder[i].length() && ans.get(ans.size() - 1).equals(folder[i].substring(0, pre)) && folder[i].charAt(pre) == '/')) {
                ans.add(folder[i]);
            }
        }
        return ans;
    }*/


}
