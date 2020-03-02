package com.liping.Util;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum HandleTestCaseInput {
    INSTANCE;

    /**
     * @param input: such as [1,2,3]
     * */
    public int[] getList(String input){
        if(input == null){
            throw new IllegalArgumentException("input is invalid");
        }
        input = input.replace(" ", "");
        if(!checkListInput(input)){
            throw new IllegalArgumentException("input is invalid");
        }
        List<String> lines = getPatternMatcherList(input, "\\d[,\\d]*");
        return parseFormat(lines.get(0).split(",").length, lines.get(0));
    }

    public boolean checkListInput(String input){
        return Pattern.matches("^\\[\\d[,\\d]*\\]$", input);
    }

    /**
     * @param input: such as [[1,2,3],[4,5,6],[7,8,9]]
     * */
    public int[][] getMatrix(String input){
        if(input == null){
            throw new IllegalArgumentException("input is invalid");
        }
        input = input.replace(" ", "");
        if(!checkMatrixInput(input)){
            throw new IllegalArgumentException("input is invalid");
        }
        List<String> lines = getPatternMatcherList(input, "\\d[,\\d]*");
        if(lines.size() == 0){
            return new int[][]{};
        }else{
            int m = lines.get(0).split(",").length, linePos = 0;
            int[][] result = new int[lines.size()][m];
            for(int i = 0; i < lines.size(); i++){
                int[] tmp = parseFormat(m, lines.get(i));
                result[linePos++] = tmp;
            }
            return result;
        }
    }

    public int[] parseFormat(int m, String eachLines) {
        int[] tmp = new int[m];
        String[] line = eachLines.split(",");
        int pos = 0;
        while(pos < m){
            tmp[pos] =  Integer.parseInt(line[pos++]);
        }
        return tmp;
    }

    @NotNull
    public List<String> getPatternMatcherList(String input, String format) {
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(input);

        List<String> lines = new ArrayList<>();
        while(matcher.find()){
            lines.add(matcher.group());
        }
        return lines;
    }

    public boolean checkMatrixInput(String input){
        return Pattern.matches("^\\[\\[\\d[,\\d]*\\][,\\[\\d[,\\d]*\\]]*\\]$", input);
    }
}
