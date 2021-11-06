import java.util.Iterator;
import java.util.Set;

public class HashSet {
    public static void main(String[] args) {
        Set<String> name=new java.util.HashSet<>();
        name.add("India");
        name.add("Pak");
        name.add("china");
        name.add("India");
        name.add("Aus");
        name.add("Pak");
        name.add("Jap");
        System.out.println(name);
        Iterator<String> item=name.iterator();
        while (item.hasNext()){
            String country=item.next();
            if (country.length()>=3) System.out.print(country+" ");
        }
        System.out.println();
        name.remove("India");
        System.out.println(name);
    }

}
