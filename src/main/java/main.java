public class main {


    public static void main(String[] args) {
        LoyaltyCard l = new LoyaltyCard(978014102662L);
        l.checkDigit();
        System.out.println("il check digit e' " + l.checkDigit());
        System.out.println("Carta completa " + l.getFullCardNumb());
        l.setNumCarta(9780141026626L);
        System.out.println(l.checkVal());
    }
}
