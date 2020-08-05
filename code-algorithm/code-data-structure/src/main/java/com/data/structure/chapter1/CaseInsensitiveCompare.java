package com.data.structure.chapter1;

import java.util.Comparator;

/**
 * Desc
 *
 * @author weijinsheng
 * @date 2017/8/20 17:53
 */
public class CaseInsensitiveCompare implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
    }
}
