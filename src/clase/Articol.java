package clase;

import java.time.Duration;
import java.time.LocalDate;

public class Articol extends Publicatie{
    public static int TERMEN_IMPRUMUT =2;   //static - aceste valori nu apartin de o instanta anume(obj) ci sunt impartite de catre toate obiectele clasei.
    public static double PENALIZARE = 0.1;  //De ex: daca un obiect schimba valoarea cu 10, toate obiectele vor vedea schimbarea
    protected String publicatie;            //atribute care pot fi mostenite
    protected LocalDate dataPublicatie;

    public Articol (String autor, String titlu, String categorie, String publicatie, LocalDate dataPublicatiei){
        super();
        this.autor = autor;
        this.titlu = titlu;
        this.categorie = categorie;
        this.publicatie = publicatie;
        this.dataPublicatie = dataPublicatiei;
    }

//    Utilizam un bloc try{}catch(){} pt a prinde exceptia fara a intrerupe executia programului
//    Verificam daca este disponibila cartea, daca nu este: verificam daca s-a depasit termenul si aruncam exceptia. Daca este : actualizam
//    starea disponibilitatii si a datei + afisam msj-ul corespunzator
    @Override
    public void imprumuta(LocalDate dataImprumut) {
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
            System.out.println("Publicatia "+this.getId() +"  a fost imprumutata.");
        }

    }
//    Utilizam un bloc try{}catch(){} pt a prinde exceptia fara a intrerupe executia programului
//    Verificam daca este imprumutata cartea, daca nu este:  aruncam exceptia. Daca este : actualizam
//    starea disponibilitatii, verificam daca cartea a fost adusa la timp si afisam msj-ul corespunzator
    @Override
    public void returneaza(LocalDate dataRetur){
        try{
            if(this.isDisponibil()==false){
                this.disponibil = true;
                if(verificareTermen(dataRetur)){
                    System.out.println("Publicatia "+this.getId() +" a fost returnata");
                }
            } else{
                throw new Exception();
            }
        }
        catch (Exception e){
            System.out.println("Publicatia "+this.getId() +"  nu poate fi returnata (nu a fost imprumutata)!");

        }

    }


    public boolean verificareTermen(LocalDate data){
        boolean flag = true;
        LocalDate perioada = this.dataImprumut.plusWeeks(TERMEN_IMPRUMUT);      // LA DATA CURENTA ADAUGAM 2 SAPTAMANI (termenul de predare)
        if(data.isAfter(perioada)){                                             // daca data este mai mare decat perioada in care trebuia sa returneze cartea atunci se aplica penalitati;
            double suma = Duration.between(perioada.atStartOfDay(), data.atStartOfDay()).toDays() * PENALIZARE;         //calculam nr de zile dintre ultima zi a termenului limita si data in care s-a hotarat sa o returneze * penalitati
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
        return this.autor + "   " +this.titlu + "   "+ this.publicatie + "   "+ this.dataPublicatie;
    }

}
