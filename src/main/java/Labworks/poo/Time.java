package Labworks.poo;

public class Time {
    private int ore;
    private int minute;
    private int secunde;

    public void setOre(int ore) {
        this.ore = ore;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecunde(int secunde) {
        this.secunde = secunde;
    }

    public int getOre() {
        return ore;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecunde() {
        return secunde;
    }

    public String afisareSablon1() {
        return "ora " + ore + " si " + minute + " minute" + " si " + secunde + " secunde";
    }

    public String afisareSablon2() {
        return "ora " + ore + " pm" + " si " + minute + " minute" + " si " + secunde + " secunde";
    }

}
