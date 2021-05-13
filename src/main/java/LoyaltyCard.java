import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoyaltyCard {

    private Long numCarta;
    private static final int min_lenght = 12;
    private static final int max_lenght = 13;

    public LoyaltyCard() {
    }

    public LoyaltyCard(long numCarta) {
        this.numCarta = numCarta;
        if (isMin() || isMax()) {
            this.numCarta = numCarta;
        } else {
            this.numCarta = null;
        }
    }


    public boolean isMax() {
        return numCarta.toString().length() == max_lenght;
    }


    public boolean isMin() {
        return numCarta.toString().length() == min_lenght;
    }

    /**
     * Ritotrna true se il numero di carta e' a 13 cifre
     * @return
     */
    public boolean checkVal() {
        if (isMax()) {
            String code = numCarta.toString();
            int fDig = Character.getNumericValue(code.charAt(code.length() - 1));
            return checkDigit() == fDig;
        }
        return false;
    }

    /**
     * Metodo che restituisce tutti i valori di una  carta piu' il check digit
     * @return
     */
    public long getFullCardNumb() {
        if (isMax()) {
            return numCarta;
        } else {
            String c = numCarta.toString();
            String cD = Integer.toString(checkDigit());
            long fNumCarta = Long.decode(c + cD);
            return fNumCarta;
        }
    }

    /**
     * Metodo che calcola il check digit di una carta con 12 valori
     * @return
     */
    public int checkDigit() {
        String s = numCarta.toString();
        List<Integer> in = new ArrayList<>();
        for (int i = 0; i < min_lenght; i++) {
            in.add(i, Character.getNumericValue(s.charAt(i)));
        }

        int a = 0;
        int b = 0;

        for (int i = 0; i < min_lenght; i++) {
            if (i == 0 || (i % 2) == 0) {
                a = a + in.get(i);
            } else {
                b = b + in.get(i);
            }
        }

        Integer uDig = a + (b * 3);
        String sUDig = uDig.toString();
        int uD = Character.getNumericValue(sUDig.charAt(sUDig.length() - 1));
        int cDig = 10 - uD;
        return cDig;
    }

    public void setNumCarta(Long numCarta) {
        this.numCarta = numCarta;
    }
}
