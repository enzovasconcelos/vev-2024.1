package entities;

import java.util.Date;

public class Show { 

    private Date data;
    private String artista;
    private double cache;
    private double despesasInfra;
    private boolean ehDataEspecial;

    public Show(CreateShowRequest request) {
        this.data = request.data;
        this.artista = request.artista;
        this.cache = request.cache;
        this.despesasInfra = request.despesasInfra;
        this.ehDataEspecial = request.ehDataEspecial;
    }

    public Show(Date data, String artista, double cache, double despesasInfra, boolean ehDataEspecial) {
        this.data = data;
        this.artista = artista;
        this.cache = cache;
        this.despesasInfra = despesasInfra;
        this.ehDataEspecial = ehDataEspecial;
    }

    public String gerarRelatorio() {
        return "";
    }

}
