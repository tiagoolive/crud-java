package br.com.crud;

public interface AnotacaoInterface {
    public void criarAnotacao();
    public void lerAnotacao();
    public void apagarAnotacao(int numeroLinha);
    public void editarAnotacao(String novaAnotacao, int linhaDaAnotacao);
}
