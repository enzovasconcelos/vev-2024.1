package services;

import entities.Show;
import entities.CreateShowRequest;

public interface ShowService {

    public Show criarShow(CreateShowRequest request);

    public String gerarRelatorio(String idShow);

    public Show getShow(String idShow);

    public void save(Show show);

}
