package entities;

public class Lote {

    private String id;
    private int numeroIngressos;
    private float descontoAplicavel;
    private float porcentagemVip;

    public Lote(int numeroIngressos, float descontoAplicavel, float porcentagemVip) {
        this.numeroIngressos = numeroIngressos;
        this.descontoAplicavel = descontoAplicavel;
        this.porcentagemVip = porcentagemVip;
    }

    public Lote(String id, int numeroIngressos, float descontoAplicavel, float porcentagemVip) {
        this.id = id;
        this.numeroIngressos = numeroIngressos;
        this.descontoAplicavel = descontoAplicavel;
        this.porcentagemVip = porcentagemVip;
    }

    public double calcularValorArrecadado() {
        throw new RuntimeException("Not implemented yet!");
    }

}
