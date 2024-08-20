package repositories;

import entities.Lote;

public interface LoteRepository {

    public Lote criarLote(Lote lote);

    public Lote getLote(String idLote);

}
