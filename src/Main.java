/**
 * Zlap warzywo
 * Zlap warzywo to gra edukacyjna polegajaca na lapaniu pokarmow wedle
 * okreslonych zasad.
 *
 * @author Maciej Mechliński 179965
 * @version 1.0
 */

/**
 * Klasa Main tworzy nowy obiekt dziedziczacy po JFrame
 */
public class Main {
    public static void main(String[] args){
        Board plansza = new Board("Poziom");
        plansza.setVisible(true);
    }
}
