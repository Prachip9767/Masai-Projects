public class DriverClass {
    public static void main(String[] args) {
        Domestic domestic1=new Domestic(5);
        domestic1.setName("Raj Kumar");
        System.out.println("Customer name : " +domestic1.getName());
        domestic1.CalculateBill();

        System.out.println();
        Domestic domestic2=new Domestic(2.5);
        domestic2.setName("Lalith Raj");
        System.out.println("Customer name : " +domestic2.getName());
        domestic2.CalculateBill();

    }
}
