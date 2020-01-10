package clase;

import java.time.Duration;
import java.time.LocalDate;

public class Articol extends Publicatie{
    public static int TERMEN_IMPRUMUT =2;
    public static double PENALIZARE = 0.1;
    protected String publicatie;
    protected LocalDate dataPublicatie;

    public Articol (String autor, String titlu, String categorie, String publicatie, LocalDate dataPublicatiei){
        super();
        this.autor = autor;
        this.titlu = titlu;
        this.categorie = categorie;
        this.publicatie = publicatie;
        this.dataPublicatie = dataPublicatiei;
    }

    @Override
    public void imprumuta(LocalDate dataImprumut) throws Exception {
        this.disponibil = false;
        this.dataImprumut = dataImprumut;
    }

    @Override
    public void returneaza(LocalDate dataRetur) throws Exception {
        this.disponibil = true;
        LocalDate perioada = this.dataImprumut.plusWeeks(TERMEN_IMPRUMUT);
        if(dataRetur.isAfter(perioada)){
            double suma = Duration.between(perioada.atStartOfDay(), dataRetur.atStartOfDay()).toDays() * PENALIZARE;
            System.out.println("Termen depasit pentru publicatia "+this.getId());
            System.out.println("Penalizare "+Math.round(suma) +" lei - zile: " +Duration.between(perioada.atStartOfDay(), dataRetur.atStartOfDay()).toDays());
        }
    }

    @Override
    public double calculPenalizare(LocalDate dataRetur) {
        return 0;
    }

    @Override
    public String toString() {
        return this.autor + "   " +this.titlu + "   "+ this.publicatie + "   "+ this.dataPublicatie;
    }

}
