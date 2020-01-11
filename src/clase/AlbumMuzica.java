package clase;

public class AlbumMuzica extends Media{
    protected String artist;
    protected String titlu;
    protected String gen;

    public AlbumMuzica(String suport, String artist, String titlu, String gen) {
        this.artist = artist;
        this.titlu = titlu;
        this.gen = gen;
        this.suport = suport;
    }

    @Override
    public void consulta() {
        if(this.disponibil == true){
            this.disponibil = false;
        }
    }

    @Override
    public void elibereaza() {
        if(this.disponibil == false){
            this.disponibil = true;
        }
    }

    @Override
    public String toString() {
        return this.suport + "   " +this.titlu + "   "+ this.artist;
    }
}
