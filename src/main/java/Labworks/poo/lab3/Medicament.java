package Labworks.poo.lab3;

import java.util.List;

public class Medicament {
    private final String nume;
    private final List<ElementChimic> elementChimicList;

    public Medicament(String nume, List<ElementChimic> elementChimicList) {
        this.nume = nume;
        this.elementChimicList = elementChimicList;
    }

    public void adaugaElement(ElementChimic element, double cantitate) {
        this.elementChimicList.add(element);
        element.setMasaAtomica(cantitate);
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "nume='" + nume + '\'' +
                ", elementChimicList=" + elementChimicList +
                '}';
    }
}
