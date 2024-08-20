package services;

import entities.Lote;
import exceptions.ShowNotFoundException;

public interface LoteService {

    public Lote criarLote(String idShow, int numeroIngresos, float descontoAplicavel, 
                          float porcentagemVip) throws ShowNotFoundException;

    public Lote getLote(String idLote);

}
