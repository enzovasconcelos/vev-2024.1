package services;

public interface LoteService {

    public String criarLote(int numeroIngresos, double descontoAplicavel, double porcentagemVip);

    public Lote getLote(String idLote);

}
