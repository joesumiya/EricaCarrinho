/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Joe Sumiya
 */
public class Carrinho {
    
    private Usuario usuario;
    private ArrayList<ItemProduto> itens;

    public ArrayList<ItemProduto> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemProduto> itens) {
        this.itens = itens;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
