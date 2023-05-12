package Labworks.poo.lab3;

import java.util.ArrayList;
import java.util.List;

public class MainElemente {
    public static void main(String[] args) {
        ElementChimic e1 = new ElementChimic();
        e1.setNume("azot");
        e1.setMasaAtomica(122);
        e1.setSimbol("N");
        e1.setCantitate(100);
        ElementChimic e2 = new ElementChimic();
        e2.setNume("Carbon");
        e2.setMasaAtomica(12);
        e2.setSimbol("C");
        e2.setCantitate(90);

        List<ElementChimic> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);

        Medicament medicament_ebuprofen = new Medicament("ebuprofen", list);


        ElementChimic e3 = new ElementChimic();
        e3.setNume("Fier");
        e3.setMasaAtomica(12);
        e3.setSimbol("Fr");
        e3.setCantitate(19);
        ElementChimic e4 = new ElementChimic();
        e4.setNume("Calciu");
        e4.setMasaAtomica(134);
        e4.setSimbol("Ca");
        e4.setCantitate(150);

        List<ElementChimic> list2 = new ArrayList<>();
        list2.add(e3);
        list2.add(e4);
        list2.add(e1);

        //   alt medicament
        Medicament medicament_paracetamol = new Medicament("paracetamol", list2);

        Medicamente medicamente = new Medicamente();
        List<Medicament> medicamentList = new ArrayList<>();
        medicamentList.add(medicament_ebuprofen);
        medicamentList.add(medicament_paracetamol);

        medicamente.setMedicamentList(medicamentList);

        System.out.println(medicamente);
    }
}
