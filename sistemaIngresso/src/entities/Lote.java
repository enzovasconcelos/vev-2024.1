package entities;

public class Lote {

    private int numeroIngressos;
    private float descontoAplicavel;
    private float porcentagemVip;

    public Lote(int numeroIngressos, float descontoAplicavel, float porcentagemVip) {
        this.numeroIngressos = numeroIngressos;
        this.descontoAplicavel = descontoAplicavel;
        this.porcentagemVip = porcentagemVip;
    }

    public double calcularValorArrecadado() {
        return 0;
    }

}
