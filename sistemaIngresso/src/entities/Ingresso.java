package entities;

import enums.TipoIngresso;

public class Ingresso {

    private String id;
    private TipoIngresso tipo;
    private boolean foiVendido;

    public Ingresso(String id, TipoIngresso tipo, boolean foiVendido) {
        this.id = id;
        this.tipo = tipo;
        this.foiVendido = foiVendido;
    }

}
