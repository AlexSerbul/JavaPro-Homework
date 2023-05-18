package dz12.phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Entry> entryList;

    public PhoneDictionary() {
        this.entryList = new ArrayList<>();
    }

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void add(Entry entry){
        entryList.add(entry);
    }

    public Entry find(String name){
        Entry entry = null;
        for(Entry e : entryList){
            if(e.getName().equals(name)){
                entry = e;
                break;
            }
        }
        return entry;
    }

    public List<Entry> findAll(String name){
        List<Entry> entries = null;

        for(Entry e : entryList){
            if(e.getName().equals(name)){
                if(entries==null){
                    entries = new ArrayList<>();
                }
                entries.add(e);
            }
        }

        return entries;
    }
}
