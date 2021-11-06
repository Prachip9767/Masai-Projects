public class HotelDriver {
    public static void main(String[] args) {
        System.out.println();
        KFC kfc=new KFC();
        kfc.friedChickenRecipe();
        kfc.setToken(102);
        System.out.println( "KFC token number is "+kfc.getDisplay());
        System.out.println();
        FiveStarChicken fiveStarChicken=new FiveStarChicken();
        fiveStarChicken.setToken(345);
        System.out.println("FiveStarChicken token number is " +fiveStarChicken.getDisplay());
    }
}
