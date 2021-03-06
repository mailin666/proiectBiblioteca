package clase;

public class Film extends  Media{
    protected String titlu;
    protected int an;
    protected String gen;
    protected  String regizor;

    public Film(String suport, String titlu, int an, String gen, String regizor) {
        this.titlu = titlu;
        this.an = an;
        this.gen = gen;
        this.regizor = regizor;
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
        return this.suport + "   " +this.titlu + "   "+ this.an + "   "+ this.gen.toLowerCase() + "   "+this.regizor;
    }
}
