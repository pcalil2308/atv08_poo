package src;

public class Produto {
    private String tipo;
    private String descricao;
    private double peso;
    private int quantidade;
    private String unidade;

    public Produto(String tipo, String descricao, double peso, int quantidade, String unidade) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.peso = peso;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }

    // Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", peso=" + peso +
                ", quantidade=" + quantidade +
                ", unidade='" + unidade + '\'' +
                '}';
    }
}
