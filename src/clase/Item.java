package clase;

public abstract class Item {
    private int id;
    protected boolean disponibil;
    private static int i = 1;

    public Item() {
        this.id = i++;
        this.disponibil = true;
    }

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
