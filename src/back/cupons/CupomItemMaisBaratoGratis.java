package back.cupons;

import back.entities.Pedido;
import back.enums.Produto;

public class CupomItemMaisBaratoGratis implements CupomIF{
    @Override
    public Double setDesconto(Pedido obj) {
        double menorValor = 0.0;
        for (Produto p : obj.getProdutosPedidos()) {
            if (menorValor > p.getPreco()){
                menorValor = p.getPreco();
            }
        }
        obj.setValorTotalPedido(obj.getValorTotalPedido() - menorValor);
        return obj.getValorTotalPedido();
    }
}
