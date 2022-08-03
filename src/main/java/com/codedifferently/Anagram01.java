package com.codedifferently;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Anagram01 {

    public static String[] problem(String inputWord, String[] inputWordList){
        Map<Character, Integer> mapString = new HashMap<>();
        ArrayList<String> newList = new ArrayList<>(0);
        char[] newWord = inputWord.toCharArray();

        for (int i = 0; i < inputWord.length(); i++){
            if (mapString.containsKey(newWord[i])) {
                mapString.put(newWord[i], mapString.get(newWord[i] + 1));
            } else {
                mapString.put(newWord[i], 1);
            }
        }


        for(String word: inputWordList){
            Map<Character, Integer> mapString2 = new HashMap<>();
            for (int i = 0; i < word.length()-1; i++) {
                if (mapString2.containsKey(newWord[i])) {
                    mapString2.put(newWord[i], mapString2.get(newWord[i] + 1));
                } else {
                    mapString2.put(newWord[i], 1);
                }
            }
            Boolean flag = false;
            for (Character character: mapString2.keySet()){
                Integer first = mapString.get(character);
                Integer second = mapString2.get(character);
                if (first >= second){
                    flag = true;
                }
                if (flag){
                    newList.add(word);
                }
            }
        }
        // check to see if the inputWords matches characters from inputWord
        // iterate newWord that was created by looping through the inputWord.toCharArray
        return newList.toArray(new String[0]);
    }
}
