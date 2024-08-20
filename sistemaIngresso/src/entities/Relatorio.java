package entities;

import enums.StatusRelatorio;

public class Relatorio {

    private StatusRelatorio status;
    private double receitaLiquida;
    private int numeroIngressosNormal;
    private int numeroIngressosVip;
    private int numeroIngressosMeia;

    public Relatorio(StatusRelatorio status, double receitaLiquida, int numeroIngressosNormal, int numeroIngressosVip, 
                     int numeroIngressosMeia) {
        this.status = status;
        this.receitaLiquida = receitaLiquida;
        this.numeroIngressosNormal = numeroIngressosNormal;
        this.numeroIngressosVip = numeroIngressosVip;
        this.numeroIngressosMeia = numeroIngressosMeia;
    }

    public String toString() {
        return "";
    }

}
