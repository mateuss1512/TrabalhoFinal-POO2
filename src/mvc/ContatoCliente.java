package mvc;

public class ContatoCliente extends Contato {
    private float valorHoraContrato;

    public ContatoCliente(String nome, String sobrenome) {
        super(nome, sobrenome);
        this.valorHoraContrato = Main.retornaSingleton();
    }
    
    public ContatoCliente() {
        this(null, null);
    }

    public float getValorHoraContrato() {
        return valorHoraContrato;
    }

    public void setValorHoraContrato(float valorHoraContrato) {
        this.valorHoraContrato = valorHoraContrato;
    }
    
}
