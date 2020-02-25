package com.liping.Structure;

import java.util.HashMap;
import java.util.Map;

public enum TestData {
    INSTANCE;

    private static Map<Object, Object> sortTestData = new HashMap<>();
    static {
        sortTestData.put(new int[]{5,1,3,8,4,9}, new int[]{1,3,4,5,8,9});
        sortTestData.put(new int[]{1,2,9,3,4,5}, new int[]{1,2,3,4,5,9});
        sortTestData.put(new int[]{5,4,3,2,1}, new int[]{1,2,3,4,5});
        sortTestData.put(new int[]{1,2,2,2,3,1}, new int[]{1,1,2,2,2,3});
    }

    public Map<Object, Object> getSortTestData(){
        return sortTestData;
    }
}
