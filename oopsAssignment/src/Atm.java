public class Atm extends Bank{
    double withDrawAmt;
    double totalBalance;
    public Atm (double withDrawAmt, double totalBalance){
        this.withDrawAmt=withDrawAmt;
        this.totalBalance=totalBalance;
    }

    @Override
    public void name() {
        String S ="Ram Das Gokhale";
        System.out.println("Welcome " +S+ "to HDFC Bank ATM");
        super.name();
    }

    @Override
    public void balance() {
        double bal = totalBalance-withDrawAmt;
        System.out.println(" Remaining balance is : " +bal);
        super.balance();

    }
}
