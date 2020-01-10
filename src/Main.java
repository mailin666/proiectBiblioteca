import clase.*;
import enumuri.CategorieFilm;
import enumuri.CategorieMuzica;
import enumuri.CategoriePublicatie;

import java.time.LocalDate;

public class Main {
    static Biblioteca biblioteca = new Biblioteca();

    private static Biblioteca getBibliotecaPopulata() {
        biblioteca.adaugaPublicatie(new Carte("Jonathan Coe", "Casa somnului", 1997, CategoriePublicatie.FICTIUNE.toString()));
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

        //CAZUL 1
        biblioteca.catalogPublicatii();
        biblioteca.imprumutaPublicatie(3, LocalDate.of(2017, 12, 20));
        biblioteca.returneazaPublicatie(3, LocalDate.of(2018, 1, 3));

        System.out.println();
        //CAZUL 2
        biblioteca.imprumutaPublicatie(3, LocalDate.of(2017, 12, 20));
        biblioteca.publicatiiImprumutate();
        biblioteca.returneazaPublicatie(4, LocalDate.of(2018, 1, 3));


        biblioteca.returneazaPublicatie(3, LocalDate.of(2018, 1, 3));
        System.out.println();

        //CAZUL 3
        LocalDate data = LocalDate.of(2017, 11, 1);
        biblioteca.imprumutaPublicatie(1, data);
        biblioteca.imprumutaPublicatie(2, data);
        biblioteca.imprumutaPublicatie(3, data);
        biblioteca.imprumutaPublicatie(4, data);
        biblioteca.imprumutaPublicatie(5, data);
        biblioteca.publicatiiDisponibile();

    }
}
