package Labworks.poo.lab3;

public class ElementChimic {
    private String nume;
    private String simbol;
    private int numarAtomic;
    private double masaAtomica;
    private int cantitate;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getSimbol() {
        return simbol;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }

    public int getNumarAtomic() {
        return numarAtomic;
    }

    public void setNumarAtomic(int numarAtomic) {
        this.numarAtomic = numarAtomic;
    }

    public double getMasaAtomica() {
        return masaAtomica;
    }

    public void setMasaAtomica(double masaAtomica) {
        this.masaAtomica = masaAtomica;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    @Override
    public String toString() {
        return "ElementChimic{" +
                "nume='" + nume + '\'' +
                ", simbol='" + simbol + '\'' +
                ", numarAtomic=" + numarAtomic +
                ", masaAtomica=" + masaAtomica +
                '}';
    }
}
