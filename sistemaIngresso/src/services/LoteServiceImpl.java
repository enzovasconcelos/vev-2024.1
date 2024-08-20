package services;

import entities.Lote;
import entities.Show;
import services.ShowService;
import exceptions.ShowNotFoundException;
import repositories.LoteRepository;

public class LoteServiceImpl implements LoteService {

    private LoteRepository loteRepository;
    private ShowService showService;

    public LoteServiceImpl(LoteRepository loteRepository, ShowService showService) {
        this.loteRepository = loteRepository;
        this.showService = showService;
    }

    public Lote criarLote(String idShow, int numeroIngressos, float descontoAplicavel, 
                          float porcentagemVip) throws ShowNotFoundException {
        if (numeroIngressos < 10) {
            throw new IllegalArgumentException("numeros de ingressos menor que permitido (10)");
        }
        if (descontoAplicavel > 0.25f) {
            throw new IllegalArgumentException("desconto maior que 25%");
        }
        if (porcentagemVip < 0.2f || porcentagemVip > 0.3f) {
            throw new IllegalArgumentException("porcentagemVip fora do intervalo permitido [20%..30%]");
        }

        Show show = showService.getShow(idShow);
        Lote lote = new Lote(numeroIngressos, descontoAplicavel, porcentagemVip);
        lote = loteRepository.criarLote(lote);
        show.addLote(lote);
        showService.save(show);
        return lote;
    }

    public Lote getLote(String idLote) {
        throw new RuntimeException("Not implemented yet!");
    }

}
