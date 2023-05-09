public class Assinante {
    private String cpf;
    private String nome;
    private String numero;
    private Chamada[] chamadas;
    //protected
    private int numChamadas;

    public Assinante(String cpf, String nome, String numero) {
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
        this.chamadas = new Chamada[100]; // tamanho inicial do vetor de chamadas
        this.numChamadas = 0;
    }

    public String getCpf() {
        return cpf;
    }
// usar toString para get 
    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }
    @Override
    public String toString() {
        return "CPF: " + cpf + ", Nome: " + nome + ", Número: " + numero;
    }
}
