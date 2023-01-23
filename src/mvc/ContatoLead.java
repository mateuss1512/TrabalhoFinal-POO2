package mvc;

public class ContatoLead extends Contato {
    private String origem;

    public ContatoLead(String nome, String sobrenome) {
        super(nome, sobrenome);
        this.origem = "Facebook";
    }
    
    public ContatoLead() {
        this(null, null);
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String Origem) {
        this.origem = Origem;
    }
    
}
