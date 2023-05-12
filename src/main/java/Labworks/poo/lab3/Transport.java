package Labworks.poo.lab3;

public class Transport {
    private String nume;
    private double viteza;

    public Transport() {
    }

    public Transport(String nume, double viteza) {
        this.nume = nume;
        this.viteza = viteza;
    }

    public Transport(Transport transport) {
        this.nume = transport.nume;
        this.viteza = transport.viteza;
    }

    //Functia flux de iesire
    public static void iesire(Transport transport) {
        System.out.println("Nume: " + transport.nume + ", Viteza: " + transport.viteza);
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getViteza() {
        return viteza;
    }

    public void setViteza(double viteza) {
        this.viteza = viteza;
    }

    public void afisa() {
        System.out.println("Nume: " + nume + ", Viteza: " + viteza);
    }

    // Operatorul de atribuire
    public Transport atribui(Transport transport) {
        if (this != transport) {
            this.nume = transport.nume;
            this.viteza = transport.viteza;
        }
        return this;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "nume='" + nume + '\'' +
                ", viteza=" + viteza +
                '}';
    }
}
