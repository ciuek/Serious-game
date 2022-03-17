import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Klasa Gra przechowuje wszystkie zmienne potrzebne do poprawnego dzialania
 * gry.
 */
public class Gra {

    static ArrayList<BufferedImage> lista_obrazow = new ArrayList();
    static BufferedImage img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,tlo,imgkosz;
    ArrayList<Jedzenie> lista = new ArrayList();
    Jedzenie a,b,c,d,e,f,g,h;
    static int[] oczekiwany_typ;
    Random los = new Random();
    public static int kosz_wsp_y = 700, kosz_wym = 50;
    public int kosz_wsp_x = 400;
    public int zle_trafienia = 0;

    /**
     * nazwy przechowuje nazwy mozliwych obiektow w liscie,
     * oraz posiada metode pozwalajaca na wypisanie nazwy.
     */
    public enum nazwy {
        BANAN,
        TRUSKAWKA,
        WINOGRONA,
        MARCHEWKA,
        POMIDOR,
        BROKUL,
        BAKLAZAN,
        ANANAS,
        FRYTKI,
        BURGER,
        CHIPSY;

        private static nazwy[] list = nazwy.values();

        public static nazwy wypisz_nazwe(int i) {
            return list[i];
        }
    }

    /**
     * Metoda rozpocznik przygotowuje obiekty w odpowiednim miejscu startowym,
     * dodaje je do listy, oraz wybiera odpowiednia ilosc wymaganych zlapan
     * w zaleznosci od poziomu.
     * @param poziom Okresla poziom ktorego zasady maja byc brane pod uwage.
     */
    public void rozpocznij(int poziom){

        a = new Jedzenie(-Jedzenie.odleglosc);
        b = new Jedzenie(-Jedzenie.odleglosc*2);
        c = new Jedzenie(-Jedzenie.odleglosc*3);
        d = new Jedzenie(-Jedzenie.odleglosc*4);
        e = new Jedzenie(-Jedzenie.odleglosc*5);
        f = new Jedzenie(-Jedzenie.odleglosc*6);
        g = new Jedzenie(-Jedzenie.odleglosc*7);
        h = new Jedzenie(-Jedzenie.odleglosc*8);

        lista.add(a);
        lista.add(b);
        lista.add(c);
        lista.add(d);
        lista.add(e);
        lista.add(f);
        lista.add(g);
        lista.add(h);

        oczekiwany_typ = new int[Jedzenie.ilosc_typow];
        try {
            switch (poziom) {
                case 1:
                    oczekiwany_typ[0] = 0;
                    oczekiwany_typ[1] = 0;
                    oczekiwany_typ[2] = 0;
                    oczekiwany_typ[3] = 2;
                    oczekiwany_typ[4] = 2;
                    oczekiwany_typ[5] = 2;
                    oczekiwany_typ[6] = 2;
                    oczekiwany_typ[7] = 0;
                    oczekiwany_typ[8] = 0;
                    oczekiwany_typ[9] = 0;
                    oczekiwany_typ[10] = 0;
                    break;
                case 2:
                    oczekiwany_typ[0] = 2;
                    oczekiwany_typ[1] = 2;
                    oczekiwany_typ[2] = 2;
                    oczekiwany_typ[3] = 0;
                    oczekiwany_typ[4] = 0;
                    oczekiwany_typ[5] = 0;
                    oczekiwany_typ[6] = 0;
                    oczekiwany_typ[7] = 2;
                    oczekiwany_typ[8] = 0;
                    oczekiwany_typ[9] = 0;
                    oczekiwany_typ[10] = 0;
                    break;
                case 3:
                    for(int i = 0; i < 8; i++)
                        oczekiwany_typ[i] = los.nextInt(3);
                    break;
                case 4:
                    oczekiwany_typ[0] = 1;
                    oczekiwany_typ[1] = 1;
                    oczekiwany_typ[2] = 1;
                    oczekiwany_typ[3] = 1;
                    oczekiwany_typ[4] = 1;
                    oczekiwany_typ[5] = 1;
                    oczekiwany_typ[6] = 1;
                    oczekiwany_typ[7] = 1;
                    oczekiwany_typ[8] = 0;
                    oczekiwany_typ[9] = 0;
                    oczekiwany_typ[10] = 0;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e)
        {
            System.out.println("Wystąpił nieoczekiwany błąd " + e);
        }
    }

    /**
     * Metoda wczytuje pliki graficzne, oraz dodaje je do listy.
     */
    public static void load_img(){

        try {

            img1 = ImageIO.read(new File("img/1.png"));
            img2 = ImageIO.read(new File("img/2.png"));
            img3 = ImageIO.read(new File("img/3.png"));
            img4 = ImageIO.read(new File("img/4.png"));
            img5 = ImageIO.read(new File("img/5.png"));
            img6 = ImageIO.read(new File("img/6.png"));
            img7 = ImageIO.read(new File("img/7.png"));
            img8 = ImageIO.read(new File("img/8.png"));
            img9 = ImageIO.read(new File("img/9.png"));
            img10 = ImageIO.read(new File("img/10.png"));
            img11 = ImageIO.read(new File("img/11.png"));
            tlo = ImageIO.read(new File("img/background.jpg"));
            imgkosz = ImageIO.read(new File("img/kosz.png"));

            lista_obrazow.add(img1);
            lista_obrazow.add(img2);
            lista_obrazow.add(img3);
            lista_obrazow.add(img4);
            lista_obrazow.add(img5);
            lista_obrazow.add(img6);
            lista_obrazow.add(img7);
            lista_obrazow.add(img8);
            lista_obrazow.add(img9);
            lista_obrazow.add(img10);
            lista_obrazow.add(img11);

        } catch (IOException e)
        {
            System.out.println("Nie udało się załadować obrazu "+e);
        }

    }

    /**
     * Metoda wywoluje aktualizacje polozenia, a nastepnie sprawdza czy jeden z
     * dwoch warunkow nie zaszedl. Sa to dojscie do dolnej granicy planszy lub
     * kolizja z koszem.
     */
    public void aktualizuj(){

        for (Jedzenie element : lista){

            element.update_y();

            if (element.wsp_y > Board.windowheight) {
                element.reset_y();
                element.gen_x();
                element.gen_typ();
            }
            else if (element.wsp_y > 690 && element.wsp_x>=kosz_wsp_x - Jedzenie.wym/2 && element.wsp_x<=kosz_wsp_x + Jedzenie.wym/2){
                oczekiwany_typ[element.typ]--;
                if(oczekiwany_typ[element.typ]<0)
                {
                    zle_trafienia++;
                }
                if(zle_trafienia == 5)
                    gameover();
                element.reset_y();
                element.gen_x();
                element.gen_typ();
            }
        }
    }

    /**
     * Metoda sprawdzajaca czy gra moze sie zakonczyc na podstawie analizy tablicy
     * oczekiwanych produktow.
     * @return Zwraca prawde, jezeli gra ma zakonczyc sie w danym momencie.
     */
    public boolean czy_koniec(){
        int ukonczone = 0;

        for(int i = 0; i < Jedzenie.ilosc_typow; i++) {
            if(oczekiwany_typ[i] <= 0)
                ukonczone++;
        }
        return ukonczone == Jedzenie.ilosc_typow;
    }

    /**
     * W metodzie zawarte sa instrukcje postepowania w przypadku wygranej
     * gracza.
     */
    public void zakoncz()
    {
        lista.clear();
        zle_trafienia = 0;
        Board.cardLayout.show(Board.tresc, "informacje");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        Board.cardLayout.show(Board.tresc, "menu");
        Informacje.czy_przegrana = false;
    }

    /**
     * W metodzie zawarte sa instrukcje postepowania w przypadku przegranej
     * gracza.
     */
    public void gameover()
    {
        lista.clear();
        zle_trafienia = 0;
        Informacje.czy_przegrana = true;
        Board.cardLayout.show(Board.tresc, "informacje");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        Board.cardLayout.show(Board.tresc, "menu");
        Informacje.czy_przegrana = false;

    }
}
