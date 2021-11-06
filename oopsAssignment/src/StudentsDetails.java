public class StudentsDetails {
    String name;
    String DOB;
    String Blood_group;
    public StudentsDetails(String name,String DOB,String blood_group){
        this.name=name;
        this.DOB=DOB;
        this.Blood_group=blood_group;
    }

    public static void main(String[] args) {
        StudentsDetails student1=new StudentsDetails("Aman","19-05-1995","O+ve");
        System.out.println("Student 1 Name is "+student1.name);
        int age=student1.calculateDob(student1.DOB);
        System.out.println("Student 1 Age is " +age);
        System.out.println("Student 1 Blood Group "+student1.Blood_group);
        System.out.println();
        StudentsDetails student2=new StudentsDetails("Rahul Vats","18-05-1998","AB -ve");
        System.out.println("Student 2 Name is "+student2.name);
        int age2=student2.calculateDob(student2.DOB);
        System.out.println("Student 2 Age is " +age2);
        System.out.println("Student 2 Blood Group "+student2.Blood_group);

    }
     public int calculateDob(String DOB){
        int ca=2021;
        String[] splitdob=DOB.split("-");
        String yearstr=splitdob[2];
        int year=Integer.parseInt(yearstr);
        int age=ca-year;
        return age;
     }
}
