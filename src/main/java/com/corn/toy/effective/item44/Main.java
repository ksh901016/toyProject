package com.corn.toy.effective.item44;

public class Main {
    public static void main(String[] args) {
         //MyLinkedHashMap<String, String> linkedHashMap = new MyLinkedHashMap<>();
        MyLinkedHashMap<String, String> linkedHashMap = new MyLinkedHashMap<>((map, eldest)-> map.size() > 100);
        linkedHashMap.put("a", "a");
        linkedHashMap.put("b", "a");
        linkedHashMap.put("c", "a");
        linkedHashMap.put("d", "a");
        System.out.println(linkedHashMap);
    }
}
