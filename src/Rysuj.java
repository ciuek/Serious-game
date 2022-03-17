import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Klasa rysuj odpowiada za stale aktualizowanie pola gry.
 */
public class Rysuj extends JPanel implements MouseMotionListener {

    Gra nowa;
    Color myColour = new Color(255, 255, 255, 127);

    /**
     * Metoda mouseDragged jest w tym  programie nieuzywana,
     * pozostawiona dla zgodnosci listenera.
     * @param e Zmienna zdarzenia
     */
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    /**
     * Metoda odpowiada za aktualizacje pozycji kosza w stosunku do
     * aktualnej pozycji kursora myszy.
     * @param e
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        nowa.kosz_wsp_x=e.getX();
    }

    /**
     * Konstruktor dodaje MouseMotionListener.
     */
    Rysuj(){
        addMouseMotionListener(this);
    }

    /**
     * Metoda wywoluje pole gry w zaleznosci od wybranego poziomu.
     * Nastepnie gra jest aktualizowana co 20ms.
     * @param poziom Pobiera poziom z wcisnietego przycisku.
     */
    public void wywolaj_gre(int poziom)
    {
        nowa = new Gra();
        nowa.rozpocznij(poziom);

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {

            /**
             * Metoda klasy timer, ktora wykonuje sie wedlug zdefiniowanej
             * czestotliwosci.
             */
            @Override
            public void run() {
                repaint();
                nowa.aktualizuj();
                if(nowa.czy_koniec())
                {
                    timer.cancel();
                    timer.purge();
                    nowa.zakoncz();
                }
            }
        }, 20, 20);
    }

    /**
     * Metoda przemalowujaca pole gry. Odmalowuje ikonki kosza oraz jedzenia, oraz
     * wypisuje oczekiwania i wynik gracza.
     * @param g Uzycie grafiki.
     */
    public void paint(Graphics g) {
        g.drawImage(Gra.tlo, 0, 0, 800, 800, null);
        g.drawImage(Gra.imgkosz, nowa.kosz_wsp_x, Gra.kosz_wsp_y, Gra.kosz_wym, Gra.kosz_wym, null);
        int odstep = 0;

        for (Jedzenie element : nowa.lista)
            g.drawImage(Gra.lista_obrazow.get(element.typ), element.wsp_x, element.wsp_y, Jedzenie.wym, Jedzenie.wym, null);

        g.setColor(myColour);
        g.fillRect(0,0,800,130);
        g.setColor(Color.black);
        g.setFont(new Font("comic sans ms", Font.PLAIN, 18));
        g.drawString("Do złapania:", 50, 18);
        g.drawString(String.format("Ilość pomyłek do końca gry: %d", 5-nowa.zle_trafienia), 450, 80);
        for(int i = 0; i < Jedzenie.ilosc_typow; i++) {
            if (Gra.oczekiwany_typ[i] > 0) {
                g.drawString(String.format("%1$s - %2$d", Gra.nazwy.wypisz_nazwe(i), Gra.oczekiwany_typ[i]), 50+odstep%2 * 200, 40 + odstep/2 * 22);
                odstep++;
            }
        }
    }
}
