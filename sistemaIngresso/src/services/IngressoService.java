package services;

import enums.TipoIngresso;

public interface IngressoService {

    public String venderIngresso(String idShow, String idLote, TipoIngresso tipo);

}
