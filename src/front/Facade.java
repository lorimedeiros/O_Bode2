package front;

import back.cupons.CupomItemMaisBaratoGratis;
import back.cupons.CupomPague3ELeve4Bode;
import back.cupons.CupomSemDesconto;
import back.entities.Cliente;
import back.entities.Loja;
import back.entities.Pedido;
import back.enums.Produto;
import back.enums.Status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class Facade {

    private Loja l = new Loja();
    private Pedido p;

    private List<Pedido> filaDePreparo = new ArrayList<>();

    public void iniciaPedido(String nomeCliente) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Pedido p = new Pedido(String.valueOf(l.geraId()), new Cliente(nomeCliente), new Date(), null);
        this.p = p;
        l.addAguardandoPreparo(p);
    }

    public void adicionarItemAoPedido(Produto produto) {
        p.addProdutoPedido(produto);
    }

    public void removeItemDoPedido(Produto item) {
        p.removeProdutoPedido(item);
    }

    public void finalizaMontagemPedido() {
        Double soma = 0.0;
        for (Produto produto : p.getProdutosPedidos()) {
            soma += produto.getPreco();
        }
        p.setValorTotalPedido(soma);

        if(p.getProdutosPedidos().size() == 4){
            p.setCupom(new CupomPague3ELeve4Bode());
            p.getCupom().setDesconto(p);
        } else if (p.getProdutosPedidos().size() > 4) {
            p.setCupom(new CupomItemMaisBaratoGratis());
            p.getCupom().setDesconto(p);
        } else {
            p.setCupom(new CupomSemDesconto());
        }

        p.setStatus(Status.EM_PREPARO);
        l.removeAguardandoPreparo(p);
        l.addEmPreparo(p);
        filaDePreparo.add(p);
    }

    public void cancelaPedido(){
        filaDePreparo.remove(p);
        l.cancelaPedido(p);
    }

    public void entregaPedido(int numFila){
        Pedido prod = filaDePreparo.get(numFila);
        prod.setStatus(Status.ENTREGUE);
        l.removeEmPreparo(prod);
        l.addFinalizado(prod);
        filaDePreparo.remove(prod);
    }



    public String verFilaDePreparo(){
        String str = "";
        int ord = 0;
        for (Pedido p : filaDePreparo) {
            str += String.valueOf(ord + 1) + filaDePreparo.get(0);
            ord += 1;
        }
        return str;
    }

    public Pedido verPedidoConcluido(){
        return p;
    }

    public String getCardapio(){
        return Produto.getCardapio();
    }

    public Produto getProduto(int codigo){
        return Produto.getProduto(codigo);
    }

}