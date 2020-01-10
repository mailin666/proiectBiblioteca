package clase;

import interfete.Imprumutabil;

import java.time.LocalDate;

public abstract class Publicatie extends Item implements Imprumutabil {
    protected String autor;
    protected String titlu;
    protected String categorie;
    protected LocalDate dataImprumut;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategorie() {
        return categorie;
    }
}
