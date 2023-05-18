package dz12;

import dz12.phonebook.Entry;
import dz12.phonebook.PhoneDictionary;

import java.util.*;

public class Main<T> {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("Alex");
        stringList.add("Max");
        stringList.add("Tom");
        stringList.add("Tom");
        stringList.add("Max");
        findOccurance(stringList);

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
    public List<T> toList(T[] items) {
        return Arrays.stream(items).toList();
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
        Map<String, Integer> map = new HashMap<>();

        for(String s : stringList){
            int i=1;
            if(map.containsKey(s)){
                i = map.get(s).intValue();
                i++;
            }
            map.put(s,i);
        }

        for(Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void findOccurance(List<String> stringList){
        class Entry{
            String name;
            int occurence;

            public Entry(String name) {
                this.name = name;
                occurence = 1;
            }

            @Override
            public String toString() {
                String string = "{name: "+name+",occurence: "+occurence+" }";
                return string;
            }
        }

        List<Entry> entries = new ArrayList<>();

        for(String name : stringList){
            boolean isFound = false;
            for(Entry entry : entries){
                if(name.equals(entry.name)){
                    entry.occurence++;
                    isFound = true;
                    break;
                }
            }
            if(!isFound){
                entries.add(new Entry(name));
            }
        }

        System.out.println("[");
        for(Entry entry : entries){
            System.out.println(entry.toString());
        }
        System.out.println("]");
    }

}
