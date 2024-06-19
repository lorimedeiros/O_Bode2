package back.cupons;

import back.entities.Pedido;

public class CupomSemDesconto implements CupomIF{
    @Override
    public Double setDesconto(Pedido obj) {
        return obj.getValorTotalPedido();
    }
}
