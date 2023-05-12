package Labworks.poo.lab3;

public class Elicopter extends TransportAerian {
    private int numarDeElice;

    public Elicopter() {
    }

    public Elicopter(String nume, double viteza, double inaltimeaDeZbor, int numarDeElice) {
        super(nume, viteza, inaltimeaDeZbor);
        this.numarDeElice = numarDeElice;
    }

    public Elicopter(int numarDeElice) {
        this.numarDeElice = numarDeElice;
    }

    // CopyConstructor
    public Elicopter(Elicopter e) {
        this.numarDeElice = e.getNumarDeElice();
        setInaltimeaDeZbor(e.getInaltimeaDeZbor());
        setViteza(e.getViteza());
        setNume(e.getNume());
    }

    public Elicopter(TransportAerian transportAerian, int numarDeElice) {
        super(transportAerian);
        this.numarDeElice = numarDeElice;
    }

    public int getNumarDeElice() {
        return numarDeElice;
    }

    public void setNumarDeElice(int numarDeElice) {
        this.numarDeElice = numarDeElice;
    }

    @Override
    public String toString() {
        return "Elicopter{" +
                "numarDeElice=" + numarDeElice +
                '}'
                + "\n"
                + super.toString();
    }
}
