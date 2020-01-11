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

    //metoda a fost comentata in clasa Articol
    @Override
    public void imprumuta(LocalDate dataImprumut)  {
        try{
            if(this.isDisponibil()==true){
                this.disponibil = false;
                this.dataImprumut = dataImprumut;
                System.out.println("Publicatia "+this.getId() +" a fost imprumutata");
            }else{
                verificareTermen(dataImprumut);
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println("Publicatia "+this.getId() +"  este indisponibila!");
        }

    }

    //metoda a fost comentata in clasa Articol
    @Override
    public void returneaza(LocalDate dataRetur) {
        try{
            if(this.isDisponibil()==false){
                this.disponibil = true;
                LocalDate perioada = this.dataImprumut.plusWeeks(TERMEN_IMPRUMUT);
                if(verificareTermen(dataRetur)){
                    System.out.println("Publicatia "+this.getId() +" a fost returnata");
                }
            } else{
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println("Publicatia "+this.getId() +"  nu poate fi returnata (nu a fost imprumutata)!");
        }
    }

    //metoda a fost comentata in clasa Articol
    public boolean verificareTermen(LocalDate data){
        boolean flag = true;
        LocalDate perioada = this.dataImprumut.plusWeeks(TERMEN_IMPRUMUT);
        if(data.isAfter(perioada)){
            double suma = Duration.between(perioada.atStartOfDay(), data.atStartOfDay()).toDays() * PENALIZARE;
            System.out.println("Termen depasit pentru publicatia "+this.getId());
            System.out.println("Penalizare: "+ suma +" lei -zile: "+Duration.between(perioada.atStartOfDay(), data.atStartOfDay()).toDays());
            flag = false;
        }
        return flag;
    }

    @Override
    public double calculPenalizare(LocalDate dataRetur) {
        return PENALIZARE;
    }

    @Override
    public String toString() {
        return this.autor + "   " +this.titlu + "   "+ this.anPublicatie +   "   "+ this.categorie.toLowerCase();
    }

}
