package back.enums;

public enum Status {

    AGUARDANDO_PREPARO(1),
    EM_PREPARO(2),
    ENTREGUE(3),
    CANCELADO_PELO_CLIENTE(4);

    private int codigo;

    private Status(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return codigo;
    }

    public static Status valueOf(int codigo){
        for (Status value : Status.values()) {
            if(value.getCodigo() == codigo){
                return value;
            }
        }
        throw new IllegalArgumentException("Código de status inválido");
    }

}
