package ss12_java_collection_framework.exercise.count_eachword_map;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Người dùng nhập: ");
        String str = scanner.nextLine();
        str.toLowerCase().replace(" ","");

        Map<Character,Integer> stringMap = new TreeMap<>();
        for (int i = 0; i < str.length() ; i++) {
            if (stringMap.containsKey(str.charAt(i))){
                Integer value = stringMap.get(str.charAt(i));
                value++;
                stringMap.replace(str.charAt(i),value);
            }else {
                stringMap.put(str.charAt(i),1);
            }
        }
        for(Map.Entry<Character,Integer> entry : stringMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }


    }
}
