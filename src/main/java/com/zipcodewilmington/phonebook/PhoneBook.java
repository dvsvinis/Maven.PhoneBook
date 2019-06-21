package com.zipcodewilmington.phonebook;

import java.util.*;


/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private Map <String, List<String>> phoneBook;


    public PhoneBook() {
        phoneBook = new LinkedHashMap<>();
    }

    public PhoneBook(Map<String, List<String>> map) {
        this.phoneBook = map;
    }

    public void add(String name, String phoneNumber) {
        List<String> list = new ArrayList();
            list.add(phoneNumber);
        phoneBook.put(name, list);
    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> list = new ArrayList();
        for(String each: phoneNumbers){
            list.add(each);
        }
      phoneBook.put(name, list);
    }

    public void remove(String name) {
        phoneBook.remove(name);
    }

    public Boolean hasEntry(String name) {
        List<String> number = new ArrayList<>();
        number.add(name);
        if(phoneBook.containsKey(name) || phoneBook.containsValue(number)) {
            return true;
        }
        return false;
    }

    public List<String> lookup(String name) {
        return phoneBook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for(String name: phoneBook.keySet()){
            List<String> numberFound = phoneBook.get(name);
            if(numberFound.contains(phoneNumber)){
                return name;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> contacts = new ArrayList<>();
        for (String name : phoneBook.keySet()) {
            contacts.add(name);
        }
        return contacts;
    }

    public Map<String, List<String>> getMap() {
        return this.phoneBook;
    }

}
