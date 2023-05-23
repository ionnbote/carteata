package Labworks.poo.lab4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InstitutieDeInvatamint invatamintPrescolar = new InstitutieDeInvatamintPrescolara();
        InstitutieDeInvatamint invatamintMedie = new InstitutieDeInvatamintMedie();
        InstitutieDeInvatamint invatamintSuperior = new InstitutieDeInvatamintSuperior();

        InstitutieDeInvatamint[] educatie = new InstitutieDeInvatamint[3];
        educatie[0] = new InstitutieDeInvatamintPrescolara();
        educatie[1] = new InstitutieDeInvatamintMedie();
        educatie[2] = new InstitutieDeInvatamintSuperior();

        List<InstitutieDeInvatamint> l = new ArrayList<>();
        l.add(invatamintPrescolar);
        l.add(invatamintMedie);
        l.add(invatamintSuperior);

        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i).descriere());
        }
        System.out.println();
        for (InstitutieDeInvatamint ed : educatie) {
            System.out.println(ed.descriere());
        }
    }
}
