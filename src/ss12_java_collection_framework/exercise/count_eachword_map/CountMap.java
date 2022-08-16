package ss12_java_collection_framework.exercise.count_eachword_map;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Người dùng nhập: ");
        String str = scanner.nextLine().toLowerCase();

        Map<String,Integer> stringMap = new TreeMap<>();
        String[] strs = str.split(" ");

        for (int i = 0; i < strs.length ; i++) {
            if (stringMap.containsKey(strs[i])){
                int value = stringMap.get(strs[i]);
                value++;
                stringMap.replace(strs[i], value);
            }else {
                stringMap.put(strs[i],1);
            }
        }
        for(Map.Entry<String,Integer> entry : stringMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }


    }
}
