package model;

import java.util.ArrayList;

public class PrisListe {
    private String navn;

    public PrisListe(String navn) {
        this.navn = navn;

    }

    @Override
    public String toString() {
        return "PrisListe{" +
                "navn='" + navn + '\'' +
                '}';
    }
}
