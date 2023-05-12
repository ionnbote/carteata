package Labworks.poo.lab4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InstitutieDeInvatamint invatamintPrescolara = new InstitutieDeInvatamintPrescolara();
        InstitutieDeInvatamint invatamintMedie = new InstitutieDeInvatamintMedie();
        InstitutieDeInvatamint invatamintSuperior = new InstitutieDeInvatamintSuperior();
        //System.out.println(invatamintPrescolara.descriere());

        List<InstitutieDeInvatamint> l = new ArrayList<>();
        l.add(invatamintPrescolara);
        l.add(invatamintMedie);
        l.add(invatamintSuperior);

        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i).descriere());
        }
    }
}
