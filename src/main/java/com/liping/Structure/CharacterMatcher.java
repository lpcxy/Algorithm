package com.liping.Structure;

public enum CharacterMatcher {
    INSTANCE;

    /**
     * 暴力法字符串匹配，时间复杂度O(n^2)
     * */
    public int indexOf(String t, String p){
        if(t == null || p == null || t.length() < p.length()){
            return -1;
        }
        for(int pos = 0; pos <= t.length() - p.length(); pos ++){
            if(matchStartWithPos(t, p, pos)){
                return pos;
            }
        }
        return -1;
    }

    public boolean matchStartWithPos(String t, String p, int pos){
        if(pos + p.length() > t.length()){
            return false;
        }
        int pPos = 0, tPos = pos;
        while (pPos < p.length()){
            if(t.charAt(tPos) == p.charAt(pPos)){
                tPos ++;
                pPos ++;
            }else{
                return false;
            }
        }
        return true;
    }

    public int force(String t, String p){
        int i = 0, j = 0;
        while(i < t.length() && j < p.length()){
            if(t.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }else{
                i = i - j + 1;
                j = 0;
            }
        }
        return i - j;
    }

    public int kmp(String t, String p){
        if(t == null || p == null || t.length() < p.length()){
            return -1;
        }
        int[] next = getNext(p);
        int i = 0, j = 0;
        while(i < t.length() && j < p.length()){
            if(j < 0 || t.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j == p.length()) return i - j;
        else return -1;
    }

    public int[] getNext(String p){
        int[]  N = new int[p.length()];
        int t = N[0] = -1;
        int j = 0;
        while(j < p.length() - 1){
            if(t < 0 || p.charAt(j) == p.charAt(t)){
                N[++j] = ++t;
            }else{
                t = N[t];
            }
        }
        return N;
    }

    public int[] getNextUpdate(String p){
        int[]  N = new int[p.length()];
        int t = N[0] = -1;
        int j = 0;
        while(j < p.length() - 1){
            if(t < 0 || p.charAt(j) == p.charAt(t)){
                j++;
                t++;
                N[j] = p.charAt(j) != p.charAt(t) ? t : N[t];
            }else{
                t = N[t];
            }
        }
        return N;
    }
}
