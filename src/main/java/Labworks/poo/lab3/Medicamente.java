package Labworks.poo.lab3;

import java.util.List;

public class Medicamente {
    private List<Medicament> medicamentList;

    public List<Medicament> getMedicamentList() {
        return medicamentList;
    }

    public void setMedicamentList(List<Medicament> medicamentList) {
        this.medicamentList = medicamentList;
    }

    @Override
    public String toString() {
        for (int i = 0; i < medicamentList.size(); i++) {
            System.out.println(i + 1 + ". " + medicamentList.get(i));
        }
        return "Medicamente{" +
                "medicamentList=" + medicamentList +
                '}';
    }
}
