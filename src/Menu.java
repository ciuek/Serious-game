import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Klasa menu wyswietla panel z przyciskami odpowiadajacymi za
 * wyswietlanie poziomow, instrukcji lub wyjscia z gry.
 */
public class Menu extends JPanel{

    public JButton lvl1, lvl2, lvl3, lvl4, tutorial, exit;
    static BufferedImage logo;

    /**
     * Konstruktor klasy menu wczytuje obrazek logo, oraz definiuje i rozklada
     * przyciski.
     */
    Menu(){
        this.setLayout(null);

        try {

            logo = ImageIO.read(new File("img/logo.png"));

        } catch (IOException e)
        {
            System.out.println("Nie udało się załadować obrazu "+e);
        }


        lvl1 = new JButton("Tylko warzywa");
        lvl2 = new JButton("Tylko owoce");
        lvl3 = new JButton("Sałatka owocowo-warzywna");
        lvl4 = new JButton("Złap tylko zdrowe produkty");
        tutorial = new JButton("Zasady gry");
        exit = new JButton("Wyjdź z gry");

        lvl1.setBounds(300,240,200,70);
        lvl2.setBounds(300,320,200,70);
        lvl3.setBounds(300,400,200,70);
        lvl4.setBounds(300,480,200,70);
        tutorial.setBounds(300,560,200,70);
        exit.setBounds(300,670,200,70);

        this.add(lvl1);
        this.add(lvl2);
        this.add(lvl3);
        this.add(lvl4);
        this.add(tutorial);
        this.add(exit);
    }

    /**
     * Klasa paintComponent rysuje tlo graficzne panelu oraz logo gry.
     * @param g Uzycie grafiki.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Gra.tlo, 0, 0, 800, 800, null);
        g.drawImage(logo, 250, 30, 300, 240, null);
    }
}
