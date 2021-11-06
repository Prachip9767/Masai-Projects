import java.util.Scanner;

public class ArrayList {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        java.util.ArrayList<String> name=new java.util.ArrayList<>();
        name.add("Prachi");
        name.add("Aditya");
        name.add("Sudarshan");
        name.add("Arya");
        name.add("Shubham");
        System.out.println(name);

        for (int i=0;i<name.size();i++){
            int size=name.get(i).length();
            if (size>5){
                System.out.print(name.get(i)+" ");
            }
        }
        name.remove(2);
        System.out.println(name);

        name.add(3,"Masai");
        System.out.println(name);
    }
}
