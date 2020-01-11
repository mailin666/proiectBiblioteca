package clase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Publicatie> publicatii= new ArrayList<>();      // daca nu initializezi listele (= new ArrayList<>();) atunci iti va da eroare la RunTime: java.lang.NullPointerException
    public List<Media> media = new ArrayList<>();
    private int i = 1;      //utilizam aceasta variabila pt a seta id-ul obiectelor. Am facut-o private pt a nu putea fi accesata din exteriorul clasei.

//   Verificam daca obiectul este null inainte de al adauga in lista noastra
    public void adaugaPublicatie(Publicatie publicatie){
        if(publicatie!=null){
            publicatie.setId(i++);      //utilizam aceasta metoda pt a seta id-ul. Deoarece in clasa Item, acest camp este facut PRIVATE, noi avem acces doar prin metode speciale: getteri si setteri
            publicatii.add(publicatie);
        }
        else {
            System.out.println("adaugaPublicatie: Obj null!");
        }
    }

    public void adaugaMedia(Media mediaObj){
        if(mediaObj!=null){
            mediaObj.setId(i++);
            media.add(mediaObj);
        }
        else {
            System.out.println("adaugaMedia: Obj null!");
        }
    }

//    Verificam daca lista contine publicatii. Daca dimensiunea listei este diferita de 0 => o parcurgem si afisam fiecare element al listei.
//    Daca nu aveam creata metoda .toString() atunci ar fi afisat un hashcode
    public void catalogPublicatii(){
        System.out.println("Catalog publicatii:");
        if(publicatii.size()!=0){
            for(Publicatie p : publicatii)
                System.out.println( p.getId() + ". " + p.toString());
        }

    }

    public void catalogMedia(){
        System.out.println("Catalog media:");
        if(media.size()!=0){
            for(Media m : media)
                System.out.println( m.getId() + ". " + m.toString());
        }

    }

//    Parcurgem lista si daca disponibilitate este: true => atunci inseamna ca publicatia este disponibila si putem sa o afisam
    public void publicatiiDisponibile(){
        System.out.println("Publicatii Disponibile:");
        for(Publicatie p: publicatii){
            if(p.isDisponibil() == true){
                System.out.println(p.getId() + ". " + p.toString());
            }
        }
    }

    public void consultarePublicatieDupaCategorie(String categorie){
        if(categorie!=null){
            System.out.println("Publicatii din categoria '" +categorie.toLowerCase() +"': ");
            for(Publicatie p: publicatii){
                if(p.getCategorie().equals(categorie)){
                    System.out.println(p.getId() + ". "+ p.toString());
                }
            }
        }
    }

    public void consultarePublicatieDupaAutor(String autor){
        if(autor !=null){
            System.out.println("Publicatii scrise de: '" +autor +"': ");
            for(Publicatie p: publicatii){
                if(p.getAutor().equals(autor)){
                    System.out.println(p.getId() + ". "+ p.toString());
                }
            }
        }
    }

    //Utilizam variabila flag pentru a vedea daca id este unul valid. Daca nu se gaseste nici o publicatie cu id-ul respectiv, atunci flag-ul nu isi schimba valoarea si va aruncata eroarea.
    public void imprumutaPublicatie(int id, LocalDate dataImprumut){
        boolean flag = false;
        try{
            for(Publicatie p : publicatii){
                if(p.getId() == id){
                    p.imprumuta(dataImprumut);
                    flag = true;
                }
            }
            if(flag == false)
                throw new Exception();
        }catch (Exception e){
            System.out.println("Publicatia "+id+" nu a fost gasita!");
        }
    }

    public void returneazaPublicatie(int id, LocalDate dataRetur){
        try{
            boolean flag = false;
            for(Publicatie p : publicatii){
                if(p.getId() == id){
                    p.returneaza(dataRetur);
                    flag = true;
                }
            }
            if(flag == false)
                throw new Exception();
        }catch (Exception e){
            System.out.println("Publicatia "+id+" nu a fost gasita!");
        }
    }

    public void publicatiiImprumutate() {
        System.out.println("Publicatii imprumutate:");
        for(Publicatie p: publicatii){
            if(p.isDisponibil() == false){
                System.out.println(p.getId() + ". " + p.toString());
            }
        }
    }

    //Verificam daca obiectul este in lista noastra.
    //Daca exista modificam disponibilitatea, fara a ține cont de disponibilitatea sau indisponibilitatea acestuia - dupa cum spune cerinta
    public void consultaMedia(int id) {
        boolean flag = false;
        for(Media m: media){
            if(m.getId()==id){
                m.disponibil = false;
                System.out.println("Media "+id+" este in consultare.");
                flag = true;
            }
        }

        if(flag == false){
            System.out.println("Media "+id+" nu a fost gasita!");
        }
    }

    //aplicam acelasi principiu ca mai sus
    public void elibereazaMedia(int id) {
        boolean flag = false;
        for(Media m: media){
            if(m.getId()==id){
                m.disponibil = true;
                System.out.println("Media "+id+" este libera.");
                flag = true;
            }
        }
        if(flag == false){
            System.out.println("Media "+id+" nu a fost gasita!");
        }
    }
}
