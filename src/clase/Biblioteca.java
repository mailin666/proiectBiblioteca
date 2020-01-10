package clase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Publicatie> publicatii = new ArrayList<>();
    public List<Media> media = new ArrayList<>();

    public void adaugaPublicatie(Publicatie publicatie){
        if(publicatie!=null){
            publicatii.add(publicatie);
        }
        else {
            System.out.println("adaugaPublicatie: Obj null!");
        }
    }

    public void adaugaMedia(Media mediaObj){
        if(mediaObj!=null){
            media.add(mediaObj);
        }
        else {
            System.out.println("adaugaMedia: Obj null!");
        }
    }

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

    public void imprumutaPublicatie(int id, LocalDate dataImprumut) throws Exception {
        boolean flag = false;
            for(Publicatie p : publicatii){
                if(p.getId() == id){
                    if(p.isDisponibil()==true){
                        p.imprumuta(dataImprumut);
                        System.out.println("Publicatia "+id +" a fost imprumutata");
                    }else{
                        System.out.println("Cartea este deja imprumutata!");
                    }
                    flag = true;
                }
            }

            if(flag == false)
                System.out.println("Publicatia "+id+" nu a fost gasita!");
    }

    public void returneazaPublicatie(int id, LocalDate dataRetur) throws Exception {
        boolean flag = false;
        for(Publicatie p : publicatii){
            if(p.getId() == id){
                if(p.isDisponibil()==false){
                    p.returneaza(dataRetur);
                    System.out.println("Publicatia "+id +" a fost returnata");
                }else{
                    System.out.println("Publicatia "+id +"  nu poate fi returnata (nu a fost imprumutata)!");
                }
                flag = true;
            }
        }
        if(flag == false)
            System.out.println("Publicatia "+id+" nu a fost gasita!");
    }

    public void publicatiiImprumutate() {
        for(Publicatie p: publicatii){
            if(p.isDisponibil() == false){
                System.out.println(p.getId() + ". " + p.toString());
            }
        }
    }

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
