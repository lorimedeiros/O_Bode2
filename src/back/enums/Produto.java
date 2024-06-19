package back.enums;

import java.util.Arrays;
import java.util.List;

public enum Produto {

    BATATA_FRITA(8.0),
    PASTEL(10.0),
    CHOCOLATE_AO_LEITE(8.0),
    AGUA(3.0),
    REFRIGERANTE(4.0),
    PAO_BOLA(7.0),
    PORCAO_DE_QUEIJO(12.0),
    CARNE_HAMBURGUER(12.0),
    BATATA_COM_QUEIJO(20.75),
    HAMBURGUER(23.25),
    PASTEL_COM_REFRIGERANTE(10.50),
    CHOCOLATE_COM_AGUA(8.25);

    private Double preco;

    private Produto(Double preco){
        this.preco = preco;
    }

    public Double getPreco() {
        return preco;
    }

    public static Produto getProduto(int ordinal) {
        Produto[] produtos = Produto.values();
        if (ordinal >= 0 && ordinal < produtos.length) {
            return produtos[ordinal];
        } else {
            throw new IllegalArgumentException("Código inválido: " + ordinal);
        }
    }

    public static String getCardapio(){
        String str = "";

        List<Produto> lista;
        lista = Arrays.stream(Produto.values()).toList();
        for (Produto p: lista) {

            str += (p.ordinal() + 1) + ". " + p.name() + " - R$" + p.getPreco() + "\n";

        }
        return str;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
