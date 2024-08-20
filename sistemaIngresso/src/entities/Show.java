package entities;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import entities.Lote;

public class Show { 

    private Date data;
    private String artista;
    private double cache;
    private double despesasInfra;
    private boolean ehDataEspecial;
    private List<Lote> lotes;

    public Show(Date data, String artista, double cache, double despesasInfra, boolean ehDataEspecial) {
        this.data = data;
        this.artista = artista;
        this.cache = cache;
        this.despesasInfra = despesasInfra;
        this.ehDataEspecial = ehDataEspecial;
        this.lotes = new ArrayList<Lote>();
    }

    public Show(CreateShowRequest request) {
        this.data = request.data;
        this.artista = request.artista;
        this.cache = request.cache;
        this.despesasInfra = request.despesasInfra;
        this.ehDataEspecial = request.ehDataEspecial;
        this.lotes = new ArrayList<Lote>();
    }

    public void addLote(Lote lote) {
        this.lotes.add(lote);
    }

    public String gerarRelatorio() {
        throw new RuntimeException("Not implemented yet!");
    }

}
