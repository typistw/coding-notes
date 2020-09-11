package com.leetcode.medium;

/**
 * @Auther: jinsheng.wei
 * @Description:
 */
public class CompareVersionNumbers {

    public static void main(String[] args) {
        String v11 = "0.1", v21 = "1.1";
        String v12 = "1.0.1", v22 = "1";
        String v13 = "7.5.2.4", v23 = "7.5.3";
        String v14 = "1.01", v24 = "1.001";
        String v15 = "1.0", v25 = "1.0.0";
        String v16 = "4.9", v26 = "4.5";
        System.out.println(compareVersion(v11, v21));
        System.out.println(compareVersion(v12, v22));
        System.out.println(compareVersion(v13, v23));
        System.out.println(compareVersion(v14, v24));
        System.out.println(compareVersion(v15, v25));
        System.out.println(compareVersion(v16, v26));
    }

    public static int compareVersion(String version1, String version2) {
        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");

        int idx1 = 0, idx2 = 0;
        while (idx1 < array1.length && idx2 < array2.length) {
            int ret = compareTwoStr(array1[idx1],  array2[idx2]);
            if (ret != 0)
                return ret;

            idx1++;
            idx2++;
        }

        while (idx1 < array1.length) {
            String str = array1[idx1];
            str = removeLeadingZero(str);
            if (!str.equals("")) {
                return 1;
            }
            idx1++;
        }

        while (idx2 < array2.length) {
            String str = array2[idx2];
            str = removeLeadingZero(str);
            if (!str.equals("")) {
                return -1;
            }
            idx2++;
        }

        return 0;
    }

    private static int compareTwoStr(String str1, String str2) {
        str1 = removeLeadingZero(str1);
        str2 = removeLeadingZero(str2);

        if (str1.equals("") && str2.equals(""))
            return 0;

        if (str1.equals(""))
            return -1;

        if (str2.equals(""))
            return 1;

        if(str1.length() > str2.length())
            return 1;
        if(str1.length() < str2.length())
            return -1;

        int ret = str1.compareToIgnoreCase(str2);
        if(ret > 0)
            return 1;
        if(ret < 0)
            return -1;
        return 0;
    }

    private static String removeLeadingZero(String str) {
        int idx = str.indexOf('0');
        while (idx == 0) {
            str = str.substring(1);
            idx = str.indexOf('0');
        }

        return str;
    }

}
