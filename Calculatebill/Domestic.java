public class Domestic extends Commercial{
    double unit;
public Domestic(double unit){
    this.unit=unit;
}

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void CalculateBill() {
    double bill=unit*100;
        System.out.println("Bill Amount = " +bill);
        super.CalculateBill();
    }
}
