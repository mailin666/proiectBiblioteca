package clase;
import java.time.Duration;
import java.time.LocalDate;

public class Carte extends Publicatie{
    public static int TERMEN_IMPRUMUT =4;
    public static double PENALIZARE = 0.5;
    protected int anPublicatie;

    public Carte (String autor, String titlu, int anPublicatie, String categorie){
        this.anPublicatie = anPublicatie;
        this.autor = autor;
        this.titlu = titlu;
        this.categorie = categorie;
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
                System.out.println("Penalizare: "+ suma +" lei");
            }
    }

    @Override
    public double calculPenalizare(LocalDate dataRetur) {
        return 0;
    }

    @Override
    public String toString() {
        return this.autor + "   " +this.titlu + "   "+ this.anPublicatie + "   "+ this.categorie.toLowerCase();
    }

}
