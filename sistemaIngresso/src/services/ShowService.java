package services;

import entities.Show;
import entities.CreateShowRequest;

public interface ShowService {

    public boolean criarShow(CreateShowRequest request);

    public String gerarRelatorio(String idShow);

    public Show getShow(String idShow);

}
