
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class hashMapWithName {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<String,Integer> name=new HashMap<>();
        name.put("Prachu",1);
        name.put("Shweta",2);
        name.put("Shruti",3);
        name.put("Pooja",4);
        name.put("monu",5);
        System.out.println(name);
        Iterator<String> item= name.keySet().iterator();
        while (item.hasNext()){
            String key= item.next();
            int length=key.length();
            if (length>5) System.out.print(name.get(key)+" ");
        }
        System.out.println();
        while (item.hasNext()){
            String key= item.next();
            int length=key.length();
            if (length>=6){
                name.remove(key);
            }
        }
        System.out.print(name);
    }
}
