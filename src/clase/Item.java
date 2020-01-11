package clase;

public abstract class Item {
    private int id;
    protected boolean disponibil = true;        // a spus ca " Inițial trebuie să fie disponibilă." fara a ne da o metoda prin care sa setam acest lucru, asa ca am ales ca initializam campul direct cu aceasta valoare default.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDisponibil() {
        return disponibil;
    }
}
