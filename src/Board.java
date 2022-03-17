import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasa Board tworzy okno aplikacji, w ktorym wyswietlane bedzie wyswietlany
 * panel, w ktorym za pomoca cardLayout przelaczane beda inne "subpanele".
 */
public class Board extends JFrame {

    public static int windowwidth = 800, windowheight = 800;
    public static CardLayout cardLayout = new CardLayout();
    public static JPanel tresc = new JPanel(cardLayout);

    /**
     * Konstruktor klasy Board ustawia nazwe i parametry okna.
     * Nastepnie tworzy wszystkie klasy dziedziczace z JPanel ktore beda
     * uzyte, oraz definiuje ich parametry. Do glownego panelu z cardLayout
     * dodane zostaja pozostale "subpanele", po czym pokazywany jest domyslny
     * ekran startowy - menu. Nastepnie wczytane zostaja obrazy oraz dodane
     * sa klasy sluchajace nacisniec przyciskow.
     * @param nazwa Definiuje nazwe okna.
     */
    Board(String nazwa){
        super(nazwa);
        setResizable(false);
        setSize(windowwidth, windowheight);

        Menu menu = new Menu();
        Rysuj pole = new Rysuj();
        Informacje informacje = new Informacje();


        menu.setOpaque(false);
        menu.setSize(windowwidth,windowheight);
        pole.setOpaque(false);
        pole.setSize(windowwidth,windowheight);
        informacje.setOpaque(false);
        informacje.setSize(windowwidth,windowheight);


        setLayout(new BorderLayout());
        add(tresc, BorderLayout.CENTER);

        tresc.add(menu, "menu");
        tresc.add(pole, "gra");
        tresc.add(informacje, "informacje");

        cardLayout.show(tresc, "menu");

        Gra.load_img();

        menu.lvl1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Board.cardLayout.show(Board.tresc, "gra");
                pole.wywolaj_gre(1);
            }
        });

        menu.lvl2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Board.cardLayout.show(Board.tresc, "gra");
                pole.wywolaj_gre(2);
            }
        });

        menu.lvl3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Board.cardLayout.show(Board.tresc, "gra");
                pole.wywolaj_gre(3);
            }
        });

        menu.lvl4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Board.cardLayout.show(Board.tresc, "gra");
                pole.wywolaj_gre(4);
            }
        });

        menu.tutorial.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Informacje.czy_tutorial = true;
                Board.cardLayout.show(Board.tresc, "informacje");
            }
        });

        menu.exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });

        informacje.powrot.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Board.cardLayout.show(Board.tresc, "menu");
                Informacje.czy_tutorial = false;
            }
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}