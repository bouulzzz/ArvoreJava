package Arvore;

public class Atleta implements Comparable<Atleta> {
    private String nome;
    private String apelido;
    private double altura;
    private String posicao;

    public Atleta(String nome, String apelido, double altura, String posicao) {
        this.nome = nome;
        this.apelido = apelido;
        this.altura = altura;
        this.posicao = posicao;
    }

    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public double getAltura() {
        return altura;
    }

    public String getPosicao() {
        return posicao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atleta atleta = (Atleta) o;
        return apelido.equals(atleta.apelido);
    }

    @Override
    public int compareTo(Atleta o) {
        return this.apelido.compareTo(o.apelido);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Apelido: " + apelido + ", Altura: " + altura + ", Posição: " + posicao;
    }
}