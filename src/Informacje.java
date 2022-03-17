import javax.swing.*;
import java.awt.*;

/**
 * Klasa informacje wyswietla rozne informacje, jak monit o
 * wygranej lub przegranej, czy poradnik.
 */
public class Informacje extends JPanel{
    public static boolean czy_przegrana = false;
    public static boolean czy_tutorial = false;
    public JButton powrot;
    private Color bialy_przezroczysty = new Color(255,255,255,200);

    /**
     * Konstruktor dodaje przycisk powrotu do menu glownego.
     */
    Informacje(){
        this.setLayout(null);
        powrot = new JButton("Powrót do menu");
        powrot.setBounds(560,10,200,70);
        this.add(powrot);
    }

    /**
     * Funkcja maluje napisy w zaleznosci od zmiennych definiowanych przez wynik gracza
     * badz operacje wyswietlenia instrukcji.
     * @param g Uzycie grafiki/
     */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(Gra.tlo, 0, 0, 800, 800, null);
            if(czy_tutorial)
            {
                g.setFont(new Font("comic sans ms", Font.PLAIN, 20));
                String text = "Witaj w grze złap warzywo!\nAby zagrać wybierz poziom z menu, a następnie złap odpowiednią\nilość produktów do koszyka. " +
                        "Omijaj produkty których nie ma na liście!\nZa 5 niepoprawnych produktów gra zakończy się!";
                int wysokosc = 300;
                for (String line : text.split("\n"))
                {
                    g.setColor(bialy_przezroczysty);
                    g.fillRect(0,wysokosc+10,800,g.getFontMetrics().getHeight());
                    g.setColor(Color.black);
                    g.drawString(line, 50, wysokosc += g.getFontMetrics().getHeight());
                }
            }
            else
            {
                if(czy_przegrana) {
                    g.setFont(new Font("comic sans ms", Font.BOLD, 22));
                    g.drawString("Przegrałeś!", 350, 300);
                    g.setFont(new Font("comic sans ms", Font.PLAIN, 20));
                    g.drawString("Za chwilę powrócisz do menu głównego", 235, 400);
                }
                else
                {
                    g.setFont(new Font("comic sans ms", Font.BOLD, 22));
                    g.drawString("Wygrałeś!", 350, 300);
                    g.setFont(new Font("comic sans ms", Font.PLAIN, 20));
                    g.drawString("Za chwilę powrócisz do menu głównego", 235, 400);

                }
            }
    }
}

