package services;

import enums.TipoIngresso;

public class IngressoServiceImpl implements IngressoService {

    private LoteService loteService;
    private ShowService showService;

    public IngressoServiceImpl(LoteService loteService, ShowService showService) {
        this.loteService = loteService;
        this.showService = showService;
    }

    public String venderIngresso(String idShow, String idLote, TipoIngresso tipo) {
        throw new RuntimeException("Not implemented yet!");
    }

}
