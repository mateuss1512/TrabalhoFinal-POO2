package mvc;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Contato {
    private final StringProperty nome;
    private final StringProperty sobrenome;
    private final StringProperty rua;
    private final IntegerProperty cod;
    private final StringProperty cidade;
    private final ObjectProperty<LocalDate> data;
    
    //public abstract Contato clone();
    
    public Contato(String nome, String sobrenome){
        this.nome = new SimpleStringProperty(nome);
        this.sobrenome = new SimpleStringProperty(sobrenome);
        
        //testes né se n n vai
        this.rua = new SimpleStringProperty("rua");
        this.cod = new SimpleIntegerProperty(0);
        this.cidade = new SimpleStringProperty("cidade");
        this.data = new SimpleObjectProperty<>(LocalDate.of(2003, 4, 1));
    }

    public Contato() {
        this(null, null);
    }

    public String getNome() {
        return nome.get();
    }
    
    public void setNome(String nome){
        this.nome.set(nome);
    }
    
    public StringProperty nomeProperty(){
        return nome;
    }

    public String getSobrenome() {
        return sobrenome.get();
    }
    
    public void setSobrenome(String sobrenome){
        this.sobrenome.set(sobrenome);
    }
    
    public StringProperty sobrenomeProperty(){
        return sobrenome;
    }

    public String getRua() {
        return rua.get();
    }
    
    public StringProperty ruaProperty(){
        return rua;
    }
    
    public void setRua(String rua){
        this.rua.set(rua);
    }

    public int getCod() {
        return cod.get();
    }
    
    public void setCod(int cod){
        this.cod.set(cod);
    }
    
    public IntegerProperty codProperty(){
        return cod;
    }

    public String getCidade() {
        return cidade.get();
    }
    
    public void setCidade(String cidade){
        this.cidade.set(cidade);
    }
    
    public StringProperty cidadeProperty(){
        return cidade;
    }
    
    public LocalDate getData() {
        return data.get();
    }

    public ObjectProperty<LocalDate> getDataProperty() {
        return data;
    }
    
    public void setData(LocalDate data) {
        this.data.set(data);
    }
    
}
