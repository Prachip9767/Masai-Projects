import java.util.Scanner;
public class Students {
    String name;
    int age;
    String address;

    public Students(String name,int age,String address) {
    this.name=name;
    this.age=age;
    this.address=address;


    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        for(int i=0;i<n;i++) {
            Students students = new Students(sc.next(), sc.nextInt(), sc.nextLine());
            System.out.println(students.name);
            System.out.println(students.age);
            System.out.println(students.address);
        }

    }


}

