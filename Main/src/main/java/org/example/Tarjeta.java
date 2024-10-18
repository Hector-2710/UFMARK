package org.example;

public class Tarjeta {
    private String id;
    private double saldo;

    public Tarjeta(String id, double saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "id='" + id + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
