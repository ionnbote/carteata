package Labworks.poo.lab1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running...");
        Time t = new Time();
        t.setOre(17);
        t.setMinute(18);
        t.setSecunde(4);
        System.out.println(t.afisareSablon1());
        System.out.println(t.afisareSablon2());
    }
}
