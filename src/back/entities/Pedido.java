package back.entities;

import back.cupons.CupomIF;
import back.enums.Produto;
import back.enums.Status;
import java.util.*;

public class Pedido {

    private String id;
    private Cliente cliente;
    private Double valorTotalPedido;
    private Status status;
    private Date momentoPedido;
    private CupomIF cupom;
    private List<Produto> produtosPedidos = new ArrayList<>();

    public Pedido(){}

    public Pedido(String id, Cliente cliente, Date momentoPedido, CupomIF cupom) {
        this.id = id;
        this.cliente = cliente;
        this.valorTotalPedido = 0.0;
        this.status = Status.AGUARDANDO_PREPARO;
        this.cupom = cupom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(Double valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getMomentoPedido() {
        return momentoPedido;
    }

    public void setMomentoPedido(Date momentoPedido) {
        this.momentoPedido = momentoPedido;
    }

    public CupomIF getCupom() {
        return cupom;
    }

    public void setCupom(CupomIF cupom) {
        this.cupom = cupom;
    }

    public List<Produto> getProdutosPedidos() {
        return produtosPedidos;
    }

    public void addProdutoPedido(Produto obj){
        produtosPedidos.add(obj);
    }

    public void removeProdutoPedido(Produto obj){
        produtosPedidos.remove(obj);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido pedido)) return false;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ID " + id +
                "\nCliente: " + cliente.getNome() +
                "\nProdutos: " + produtosPedidos +
                "\nValor total: " + getValorTotalPedido();
    }
}
