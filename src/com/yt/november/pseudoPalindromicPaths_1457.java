package com.yt.november;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pseudoPalindromicPaths_1457 {
    public static void main(String[] args) {
        TreeNode leftTree = new TreeNode(3, new TreeNode(3), new TreeNode(1));
        TreeNode rightTree = new TreeNode(1, null, new TreeNode(1));
        TreeNode root = new TreeNode(2, leftTree, rightTree);

        System.out.println(pseudoPalindromicPaths(root));


    }
    public static List<List<String>> list = new ArrayList<>();
    public static int pseudoPalindromicPaths (TreeNode root) {
        int res = 0;
        // 依次从根节点遍历到叶节点，判断每一条路径，是否属于回文串
        List<String> s = new ArrayList<>();
        List<String> temp_ls = new ArrayList<>();
        temp_ls.add("9");
        temp_ls.add("5");
        temp_ls.add("5");
        temp_ls.add("5");
        temp_ls.add("1");
        temp_ls.add("1");
        temp_ls.add("9");
        temp_ls.add("5");
//
//        temp_ls.add("4");
        list.add(temp_ls);
        dfs(root, s);

        // 对得到得list进行判断，哪个属于伪回文串
        // 伪回文串得条件：长度为奇数时-异或操作为1，长度为偶数时-异或为0
        for(List<String> ls : list) {
            System.out.println(ls.toString());
            if(check(ls)) {
                res++;
            }

        }



        return res;
    }

    // 如果判断是否为伪回文
    public static boolean check(List<String> ls) {
        // 如果string的长度为奇数，则需要n-1 / 2个相同对的数字
        // 如果string的长度为偶数，则所有数字的异或值为0
        int n = ls.size();
        if(n == 1) {
            return true;
        }
        if(n % 2 == 0) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0;i < n;i++) {
                int tmp = Integer.parseInt(ls.get(i));
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
            // 如果map为奇数的值超过1个，那就不是回文串
            int cnt = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue() % 2 == 1) {
                    cnt++;
                }

            }
            if(cnt == 0) {
                return true;
            }
        } else {
            // 长度为奇数，
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0;i < n;i++) {
                int tmp = Integer.parseInt(ls.get(i));
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
            // 如果map为奇数的值超过1个，那就不是回文串
            int cnt = 0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(entry.getValue() % 2 == 1) {
                    cnt++;
                }

            }
            if(cnt == 1) {
                return true;
            }

        }

        return false;
    }

    public static void dfs(TreeNode node, List<String> s) {
        if(node == null) {
            return;
        }
        if(node.left == null && node.right == null) {
            s.add(String.valueOf(node.val));
            list.add(new ArrayList<>(s));
            s.remove(s.size() - 1);
            return ;
        }
        s.add(String.valueOf(node.val));

        dfs(node.left, s);
        dfs(node.right, s);

        s.remove(s.size() - 1);
    }

}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
