package com.yt.october;

import java.util.*;

public class topStudents_2512 {

    public static void main(String[] args) {
        System.out.println(topStudents(new String[]{"xrezzxgdvg","bcgx","wcfzmfosr"}, new String[]{"qyouhus","ukou","eirhfbt","qciw","for"},
                new String[]{"bcgx bcgx eirhfbt kvcrym bcgx cxzs eirhfbt wcfzmfosr v qciw","bcgx xrezzxgdvg bcgx xrezzxgdvg wcfzmfosr chap qyouhus biyt wcfzmfosr qciw",
                        "xrezzxgdvg wcfzmfosr ukou qcr clnj xrezzxgdvg gvtkvb qciw hi wcfzmfosr",
                        "for for mnxpqrdth bcgx bcgx qciw wcfzmfosr lspvgjvk wcfzmfosr eirhfbt",
                        "loxyg bcgx jwdesdu xrezzxgdvg wcfzmfosr rrych qyouhus wcfzmfosr klcwo xrezzxgdvg",
                        "rvbd wcfzmfosr lj xrezzxgdvg xuwguhgyyy fuz eirhfbt ukou h bcgx",
                        "bcgx wpmxyvbhc for qciw wcfzmfosr wjdm qyouhus qciw for xrezzxgdvg",
                        "bcgx sj xrezzxgdvg yjoklk bcgx hpc xrezzxgdvg lqfrvk xrezzxgdvg wcfzmfosr",
                        "qc wcfzmfosr jkjpgjalc tm v wcfzmfosr orgsqjzwa wcfzmfosr hh bfnxcx"},
                new int[]{686276715,934288178,625397331,519945877,864052244,971253305,512505036,865635090,281613863}, 9));
    }
    public static List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        int n = student_id.length;

        List<Integer> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(String posi : positive_feedback) {
            map.put(posi, 3);
        }
        for(String nag : negative_feedback) {
            map.put(nag, -1);
        }
        // 第一纬为下标，第二纬为分数
        int [][] credit = new int[n][2];

        for(int i = 0;i < n;i++) {
            String rp = report[i];
            credit[i][0] = student_id[i];
            for(String word : rp.split(" ")) {
                credit[i][1] += map.getOrDefault(word, 0);
            }
        }
        // 排序,当分数相同时，按照下标从小到大，否则，按照分数从大到小
        Arrays.sort(credit, (a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        for(int i = 0;i < k;i++) {
            res.add(credit[i][0]);
        }
        return res;


    }
}
