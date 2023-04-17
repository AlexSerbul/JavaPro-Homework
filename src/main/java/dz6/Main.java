package dz6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(findSymbolOccurance("Occurance",'c'));
        System.out.println(findWordPosition("Serbul","rbu"));
        System.out.println(stringReverse("Test string"));
        System.out.println(isPalindrome("PolinniloP"));
        whealOfFortune();
    }
    private static int findSymbolOccurance(String string,char ch){
        int result = 0;
        char chars[] = string.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i] == ch) result++;
        }
        return result;
    }
    private static int findWordPosition(String source, String target){
        int result = -1;
        if(source.contains(target)){
            result = source.indexOf(target);
        }
        return result;
    }
    private static String stringReverse(String string){
        char chars[] = string.toCharArray();
        String result = "";
        for(int i=0;i<(chars.length);i++){
            result+=chars[chars.length-i-1];
        }
        return result;
    }
    private static boolean isPalindrome(String string){
        boolean result = true;
        char chars[] = string.toCharArray();
        for(int i=0;i<(chars.length);i++){
            if(chars[i]!=chars[chars.length-i-1]){
                result = false;
                break;
            }
        }
        return result;
    }
    private static void whealOfFortune(){
        Scanner scanner = new Scanner(System.in);
        String[] words = {
                "apple", "orange", "lemon", "banana", "apricot", "avocado" ,
                "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", " pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"
        };

        int rn = new Random().nextInt(words.length-1);
        String word = words[rn];
        System.out.println("Enter your word:");
        String in = scanner.nextLine();
        boolean b = true;

        do {
            int length;
            if(word.length()>in.length()){
                length = in.length();
            }else length = word.length();

            for(int i=0; i<length;i++){
                if(word.charAt(i)!=in.charAt(i)){
                    b = false;
                    System.out.print("#");
                }else System.out.print(word.charAt(i));
            }

            if(!word.equals(in)) {
                System.out.println("#".repeat(15-in.length()));
                System.out.println("Try again:");
                in = scanner.nextLine();
            }else{
                b = true;
                System.out.println("\nCongrats! You win!");
            }
        }while (!b);
    }

}
