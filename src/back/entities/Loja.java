package back.entities;

import back.enums.Produto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Loja {
    private List<Pedido> aguardandoPreparo = new ArrayList<>();
    private List<Pedido> emPreparo = new ArrayList<>();
    private List<Pedido> finalizados = new ArrayList<>();
    private int contadorIds = 0;

    public Loja(){}

    public void addAguardandoPreparo(Pedido obj){
        aguardandoPreparo.add(obj);
    }

    public void addEmPreparo(Pedido obj){
        emPreparo.add(obj);
    }

    public void addFinalizado(Pedido obj){
        finalizados.add(obj);
    }

    public void cancelaPedido(Pedido obj){
        if(aguardandoPreparo.contains(obj)){
            aguardandoPreparo.remove(obj);
        }
    }

    public void removeAguardandoPreparo(Pedido p){
        aguardandoPreparo.remove(p);
    }

    public void removeEmPreparo(Pedido p){
        emPreparo.remove(p);
    }

    public List<Pedido> getEmPreparo(){
        return emPreparo;
    }

    public String relatorioSimples(){
        String str = "";



        return str;
    }

    public int geraId(){
        contadorIds += 1;
        return contadorIds;
    }
}
