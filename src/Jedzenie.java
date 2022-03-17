import javax.swing.*;
import java.util.Random;

/**
 * Klasa jedzenie przechowuje informacje o obiektach
 * spadajacych w grze.
 */
public class Jedzenie extends JPanel {
    public int wsp_x, wsp_y, typ;
    public static final int wym = 50, odleglosc = 100;
    public static int ilosc_typow = 11;
    public final static int szybkosc_spadania = 3;
    Random los = new Random();

    /**
     * Konstruktor klasy jedzenie, ustawia wartosci poczatkowe obiektu
     * @param y Definiuje pozycje poczatkowe obiektow.
     */
    public Jedzenie(int y){
        wsp_y = y;
        gen_x();
        gen_typ();
    }

    /**
     * Metoda generuje losowa wspolrzedna x dla obiektu.
     */
    public void gen_x() { wsp_x = los.nextInt(Board.windowwidth-2*wym)+wym; }

    /**
     * Metoda aktualizuje wartosc wspolrzednej y o wartosc zdefiniowanej
     * w kodzie predkosci spadania.
     */
    public void update_y(){

        wsp_y = wsp_y + szybkosc_spadania;
    }

    /**
     * Metoda resetujaca wspolrzedna y do pozycji poczatkowej.
     */
    public void reset_y() { wsp_y = -wym; }

    /**
     * Metoda generujaca nowy typ dla obiektu, ktory zakonczyl spadanie i wraca
     * na poczatek.
     */
    public void gen_typ() { typ = los.nextInt(ilosc_typow); }

}
