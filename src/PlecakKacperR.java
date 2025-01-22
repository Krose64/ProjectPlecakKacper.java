//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList; // Importujemy klasę ArrayList do przechowywania elementów w plecaku
import java.util.Scanner; // Importujemy klasę Scanner do odczytu danych wejściowych od użytkownika
import java.util.Random;// Importujemy klasę do losowania

public class PlecakKacperR { // Deklaracja głównej klasy programu

    private static String KolorPlecaka;// Deklaracja zmiennej globalnej do przechowywania koloru plecaka

    public static void main(String[] args) {

        String[] kolory = {"Czerwonym", "Zielonym", "Niebieskim", "Żółtym", "Pomarańczowym", "Fioletowym", "Zielonym", "Brzydkim"};// Tablica kolorów, z której będziemy losować


        losujKolor(kolory); // Wywołanie metody do losowania koloru z podanej tablicy

    }

        // Metoda do losowania koloru
        private static void losujKolor (String[]kolory){
            Random random = new Random();// Tworzymy obiekt klasy Random do generowania losowych liczb
            int indeks = random.nextInt(kolory.length); // Losuje indeks z zakresu dostępnych kolorów
            KolorPlecaka = kolory[indeks];// Przypisujemy wylosowany kolor do zmiennej globalnej KolorPlecaka


            System.out.println("Program stworzony przez Kacpra Różejewicza "); // Informacja o autorze programu

            Scanner scanner = new Scanner(System.in);
            // Lista przedmiotów w plecaku
            ArrayList<String> plecak = new ArrayList<>(); // Tworzymy listę przechowującą przedmioty w plecaku
            plecak.add("Miecz"); // Dodajemy "Miecz" do plecaka
            plecak.add("Wiadro"); // Dodajemy "Wiadro" do plecaka
            plecak.add("Mapa"); // Dodajemy "Mapa" do plecaka
            plecak.add("Cebula"); // Dodajemy "Cebula" do plecaka
            plecak.add("Poradnik do Javy"); // Dodajemy "Poradnik do Javy" do plecaka


            while (true) { // Pętla nieskończona pozwalająca na wykonywanie operacji w programie
                System.out.println("\nTwoje opcje:"); // Wyświetlamy dostępne opcje
                System.out.println("1. Wyświetl zawartość plecaka w kolorze " + KolorPlecaka); // Opcja 1: Wyświetlenie zawartości plecaka
                System.out.println("2. Wyjmij przedmiot z plecaka w kolorze " + KolorPlecaka); // Opcja 2: Wyjęcie przedmiotu z plecaka
                System.out.println("3. Włóż przedmiot do plecaka w kolorze " + KolorPlecaka); // Opcja 3: Włożenie przedmiotu do plecaka
                System.out.println("4. Wyjdź z programu"); // Opcja 4: Wyjście z programu
                System.out.print("Wybierz opcję (numer do którego opcja jest przypisana) : "); // Prośba o wybór opcji

                int opcja; // Deklaracja zmiennej do przechowywania wyboru użytkownika
                try { // Próba odczytu liczby od użytkownika
                    opcja = Integer.parseInt(scanner.nextLine()); // Odczytujemy wybór użytkownika i konwertujemy na liczbę całkowitą
                } catch (NumberFormatException e) { // Obsługa błędu, gdy użytkownik poda niepoprawne dane
                    System.out.println("Podałeś zły numer?! Just HOW? Can't read number!?"); // Informacja o błędzie
                    continue; // Przechodzimy do następnej iteracji pętli
                }

                switch (opcja) { // Instrukcja switch do obsługi wyboru użytkownika
                    case 1: // Obsługa opcji 1
                        System.out.println("\nZawartość plecaka w kolorze " + KolorPlecaka); // Wyświetlamy tytuł sekcji
                        if (plecak.isEmpty()) { // Sprawdzamy, czy plecak jest pusty
                            System.out.println("Plecak w kolorze " + KolorPlecaka + " jest pusty."); // Informacja, że plecak jest pusty
                        } else { // Jeśli plecak nie jest pusty
                            for (int i = 0; i < plecak.size(); i++) { // Iteracja przez zawartość plecaka
                                System.out.println((i + 1) + ". " + plecak.get(i)); // Wyświetlamy numer i nazwę przedmiotu
                            }
                        }
                        break; // Kończymy obsługę tej opcji

                    case 2: // Obsługa opcji 2
                        if (plecak.isEmpty()) { // Sprawdzamy, czy plecak jest pusty
                            System.out.println("\nPlecak w kolorze " + KolorPlecaka + " jest pusty, nie możesz wyjąć żadnego przedmiotu."); // Informacja o braku możliwości wyjęcia przedmiotu
                            break; // Kończymy obsługę tej opcji
                        }
                        System.out.println("\nKtóry przedmiot chcesz wyjąć? Wpisz numer:"); // Prośba o wybór przedmiotu do wyjęcia
                        for (int i = 0; i < plecak.size(); i++) { // Iteracja przez zawartość plecaka
                            System.out.println((i + 1) + ". " + plecak.get(i)); // Wyświetlamy numer i nazwę przedmiotu
                        }
                        System.out.print("Twój wybór: "); // Prośba o podanie numeru przedmiotu

                        try { // Próba odczytu wyboru przedmiotu
                            int numer = Integer.parseInt(scanner.nextLine()); // Odczytujemy numer przedmiotu
                            if (numer < 1 || numer > plecak.size()) { // Sprawdzamy, czy numer jest poprawny
                                System.out.println("Nie ma takiego przedmiotu w plecaku w kolorze " + KolorPlecaka + " :(, ale jak włożysz to będzie :)"); // Informacja o błędnym numerze
                            } else { // Jeśli numer jest poprawny
                                String przedmiotWyjety = plecak.remove(numer - 1); // Usuwamy wybrany przedmiot z plecaka
                                System.out.println("Wyjąłeś przedmiot: " + przedmiotWyjety); // Informacja o wyjęciu przedmiotu
                            }
                        } catch (NumberFormatException e) { // Obsługa błędu, gdy użytkownik poda niepoprawne dane
                            System.out.println("To nie jest numer :( "); // Informacja o błędzie a dokładniej jak nie dasz numeru a inny znak
                        }
                        break; // Kończymy obsługę tej opcji

                    case 3: // Obsługa opcji 3
                        System.out.print("\nPodaj nazwę przedmiotu który chcesz włożyć do plecakaw kolorze " + KolorPlecaka + " : " ); // Prośba o nazwę nowego przedmiotu
                        String przedmiot = scanner.nextLine(); // Odczytujemy nazwę przedmiotu
                        plecak.add(przedmiot); // Dodajemy nowy przedmiot do plecaka
                        System.out.println("Dodano przedmiot: " + przedmiot); // Informacja o dodaniu przedmiotu
                        break; // Kończymy obsługę tej opcji

                    case 4: // Obsługa opcji 4
                        System.out.println("\nPlecak w kolorze " + KolorPlecaka + " zamknięty :)"); // Informacja o zamknięciu programu
                        scanner.close(); // Zamykamy obiekt Scanner
                        return; // Kończymy działanie programu

                    default: // Obsługa niepoprawnego wyboru
                        System.out.println(" Podałeś zły numer?! Wpisz poprawny następnym razem"); // Informacja o błędzie
                }
            }
        }
    }
