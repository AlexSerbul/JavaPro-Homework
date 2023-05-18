package dz12;

import dz12.phonebook.Entry;
import dz12.phonebook.PhoneDictionary;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        PhoneDictionary dictionary = new PhoneDictionary();

        dictionary.add(new Entry("Alex","123456"));
        dictionary.add(new Entry("Max","5912837120"));
        dictionary.add(new Entry("Tom","32781923"));
        dictionary.add(new Entry("Alex","5023901293"));

        System.out.println(dictionary.find("Tom").getPhoneNumber());

        for(Entry e: dictionary.findAll("Alex")){
            System.out.println(e.getPhoneNumber());
        }

    }

    public static int countOccurance(List<String> stringList, String string){
        int count = 0;

        for(String s: stringList){
            if(s.equals(string)){
                count++;
            }
        }

        return count;
    }

    public static List<Integer> findUnique(List<Integer> list){
        List<Integer> uniqueList = new ArrayList<>();
        for(int i: list){
            if(!uniqueList.contains(i)){
                uniqueList.add(i);
            }
        }
        return uniqueList;
    }

    public static void calcOccurance(List<String> stringList){
        for(Map.Entry entry : createMap(stringList).entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static Map<String,Integer> findOccurance(List<String> stringList){
        Map<String,Integer> map = createMap(stringList);

        System.out.println("[");
        for(Map.Entry entry : map.entrySet()){
            System.out.println("    {name: " + entry.getKey() + " ,occurrence: " + entry.getValue() +" }");
        }
        System.out.println("]");

        return map;
    }

    private static Map<String,Integer> createMap(List<String> stringList) {
        Map<String, Integer> map = new HashMap<>();

        for(String s : stringList){
            int i=1;
            if(map.containsKey(s)){
                i = map.get(s).intValue();
                i++;
            }
            map.put(s,i);
        }

        return map;
    }
}
