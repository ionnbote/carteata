package Labworks.poo.lab3;

public class TransportAerian extends Transport {
    public double inaltimeaDeZbor;

    public TransportAerian(String nume, double viteza, double inaltimeaTavanului) {
        super(nume, viteza);
        this.inaltimeaDeZbor = inaltimeaTavanului;
    }

    public TransportAerian() {
        super();
    }

    public TransportAerian(TransportAerian transportAerian) {
        super(transportAerian);
        this.inaltimeaDeZbor = transportAerian.inaltimeaDeZbor;
    }

    public double getInaltimeaDeZbor() {
        return inaltimeaDeZbor;
    }

    public void setInaltimeaDeZbor(double inaltimeaDeZbor) {
        this.inaltimeaDeZbor = inaltimeaDeZbor;
    }

    @Override
    public String toString() {
        return "TransportAerian{" +
                "inaltimeaDeZbor=" + inaltimeaDeZbor +
                '}'
                + "\n"
                + super.toString();
    }
}
