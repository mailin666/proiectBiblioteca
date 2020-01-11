import clase.*;
import enumuri.CategorieFilm;
import enumuri.CategorieMuzica;
import enumuri.CategoriePublicatie;

import java.time.LocalDate;

public class Main {
   private static Biblioteca biblioteca;      //pentru a putea utiliza biblioteca in metoda main(), am definit obiectul in clasa Main, ci nu in metoda  getBibliotecaPopulata().
                                        // l-am facut static deoarece in metodele statice pot fi utilizate doar variabile statica.
    private static Biblioteca getBibliotecaPopulata() {
        biblioteca = new Biblioteca();
        biblioteca.adaugaPublicatie(new Carte("Jonathan Coe", "Casa somnului", 1997, CategoriePublicatie.FICTIUNE.toString())); // utilizam .toString() pentru a introduce un Enum intr-un String (cosntructorul nostru are String categorie in constructor )
        biblioteca.adaugaPublicatie(new Carte("Anna Gavalda", "Impreuna", 2004, CategoriePublicatie.FICTIUNE.toString()));
        biblioteca.adaugaPublicatie(new Articol("Pavel Carol", "Scurta istorie a macaroanelor", CategoriePublicatie.STIINTA.toString(), "Good Food", LocalDate.of(2011,10, 3)));
        biblioteca.adaugaPublicatie(new Articol("John Meyer", "Internetul in mileniul 3", CategoriePublicatie.STIINTA.toString(), "The Scientist", LocalDate.of(1999,12, 1)));
        biblioteca.adaugaPublicatie(new Carte("Neagu Djuvara", "O scurta istorie ilustrata a romanilor", 2013, CategoriePublicatie.ISTORIE.toString()));
        biblioteca.adaugaPublicatie(new Carte("Frank Herbert", "Dune", 1965, CategoriePublicatie.SF.toString()));
        biblioteca.adaugaPublicatie(new Articol("Francois Auteuil", "Limba franceza a evului mediu", CategoriePublicatie.ISTORIE.toString(), "Journal de l'Academie Francaise", LocalDate.of(1867, 6, 17)));
        biblioteca.adaugaPublicatie(new Articol("Ygor Swozkowicz", "Plante farmaceutice", CategoriePublicatie.STIINTA.toString(), "British Journal of Natural History", LocalDate.of(1960, 10, 9)));
        biblioteca.adaugaPublicatie(new Carte("Franz Kafka", "Procesul", 1925, CategoriePublicatie.FICTIUNE.toString()));

        biblioteca.adaugaMedia(new Film("DVD", "Inglourious Basterds", 2009, CategorieFilm.ACTIUNE.toString(), "Quentin Tarantino"));
        biblioteca.adaugaMedia(new Film("Blu-Ray", "Casablanca", 1941, CategorieFilm.DRAMA.toString(), "Michael Curtiz"));
        biblioteca.adaugaMedia(new Film("Blu-Ray", "Superbad", 2007, CategorieFilm.COMEDIE.toString(), "Greg Mottola"));
        biblioteca.adaugaMedia(new Film("HDDVD", "BD la munte si la mare", 1971, CategorieFilm.COMEDIE.toString(), "Mircea Dragan"));
        biblioteca.adaugaMedia(new AlbumMuzica("CD", "Pink Floyd", "The Wall", CategorieMuzica.ROCK.toString()));
        biblioteca.adaugaMedia(new AlbumMuzica("Vinil", "Orchestra Filarmonica Viena", "Beethoven - Simfonia nr. 5", CategorieMuzica.CLASICA.toString()));
        biblioteca.adaugaMedia(new AlbumMuzica("CD", "Stromae", "Racine Carree", CategorieMuzica.POP.toString()));
        biblioteca.adaugaMedia(new AlbumMuzica("CD", "Satyricon", "The Age of Nero", CategorieMuzica.ROCK.toString()));
        return biblioteca;

    }

    public static void main(String[] args) throws Exception {
        getBibliotecaPopulata();

        System.out.println("CAZUL 1:");
        biblioteca.catalogPublicatii();
        biblioteca.imprumutaPublicatie(3, LocalDate.of(2017, 12, 20));
        biblioteca.returneazaPublicatie(3, LocalDate.of(2018, 1, 3));

        System.out.println("\nCAZUL 2:");
        biblioteca.imprumutaPublicatie(3, LocalDate.of(2017, 12, 20));
        biblioteca.publicatiiImprumutate();
        biblioteca.returneazaPublicatie(4, LocalDate.of(2018, 1, 3));

        System.out.println("\nCAZUL 3:");
        LocalDate data = LocalDate.of(2017, 11, 1);
        biblioteca.imprumutaPublicatie(1, data);
        biblioteca.imprumutaPublicatie(2, data);
        biblioteca.imprumutaPublicatie(3, data);
        biblioteca.imprumutaPublicatie(4, data);
        biblioteca.imprumutaPublicatie(5, data);
        biblioteca.publicatiiDisponibile();

        //returnam publicatiile imprumutate, altfel vor fi afisate la apelarea metodei "biblioteca.publicatiiImprumutate();"
        System.out.println();
        for(int i=1; i<6; i++)
            biblioteca.returneazaPublicatie(i, data);

        System.out.println("\nCAZUL 4:");
        biblioteca.imprumutaPublicatie(3, LocalDate.of(2017, 12, 1));
        biblioteca.publicatiiImprumutate();
        biblioteca.returneazaPublicatie(3, LocalDate.of(2018, 2, 2));

        System.out.println("\nCAZUL 5:");
        biblioteca.consultarePublicatieDupaCategorie(CategoriePublicatie.FICTIUNE.toString());
        biblioteca.imprumutaPublicatie(2, LocalDate.now());
        biblioteca.imprumutaPublicatie(2, LocalDate.now());

        System.out.println("\nCAZUL 6:");
        biblioteca.consultarePublicatieDupaAutor("Neagu Djuvara");
        biblioteca.imprumutaPublicatie(10, LocalDate.now());
        biblioteca.returneazaPublicatie(11, LocalDate.now());

        //La zacul 2 a fost imprumutata publicatia 2 cu data de azi si trebuie sa o returnam si sa o imprumutam cu o alta data pentru a putea depasi termenul
        System.out.println("\n\n");
        biblioteca.returneazaPublicatie(2, LocalDate.of(2017, 6, 1));
        biblioteca.imprumutaPublicatie(2, LocalDate.of(2017, 11, 3));
        System.out.println("\nCAZUL 7:");

        biblioteca.imprumutaPublicatie(1, LocalDate.of(2017, 12, 10));
        biblioteca.returneazaPublicatie(1, LocalDate.of(2017, 1, 3));
        biblioteca.imprumutaPublicatie(2, LocalDate.of(2018, 1, 1));

        System.out.println("\nCAZUL 8:");
        biblioteca.catalogMedia();
        biblioteca.consultaMedia(10);
        biblioteca.elibereazaMedia(10);

        System.out.println("\nCAZUL 9:");
        biblioteca.consultaMedia(20);
        biblioteca.elibereazaMedia(21);

        System.out.println("\nCAZUL 10:");
        biblioteca.consultaMedia(14);
        biblioteca.elibereazaMedia(15);
        biblioteca.consultaMedia(16);
        biblioteca.elibereazaMedia(16);
    }
}
