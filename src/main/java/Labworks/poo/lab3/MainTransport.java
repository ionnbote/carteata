package Labworks.poo.lab3;

public class MainTransport {
    public static void main(String[] args) {
        Elicopter elicopter = new Elicopter(
                "pantera",
                500,
                10000,
                2
        );

        System.out.println(elicopter);

        Elicopter e2 = new Elicopter();
        e2.setNume("vultur");
        e2.setViteza(750);
        e2.setInaltimeaDeZbor(9000);
        e2.setNumarDeElice(3);

        System.out.println(" = = = = =  = = = = = ");
        Elicopter e3 = new Elicopter(e2);
        e2.setInaltimeaDeZbor(11_000);
        System.out.println(" = = e2 = = = =");
        System.out.println(e2);
        System.out.println(" = = e3 = = = =");
        System.out.println(e3);
    }

}
