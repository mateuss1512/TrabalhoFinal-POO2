/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc;

/**
 *
 * @author money
 */
public class LeadClienteAdapter extends ContatoCliente {
    private Contato contato;

    public LeadClienteAdapter(Contato contato) {
        this.contato = contato;
        Singleton singleton = Singleton.getInstance(0);
        super.setValorHoraContrato(singleton.value);
        super.setCidade(contato.getCidade());
        super.setCod(contato.getCod());
        super.setData(contato.getData());
        super.setNome(contato.getNome());
        super.setSobrenome(contato.getSobrenome());
    }
}
