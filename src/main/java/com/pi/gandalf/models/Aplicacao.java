package com.pi.gandalf.models;
// Generated 07/10/2017 20:49:51 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Aplicacao generated by hbm2java
 */
public class Aplicacao  implements java.io.Serializable {


     private byte idAplicacao;
     private String descAplicacao;
     private char tipoAplicacao;
     private Set pedidos = new HashSet(0);

    public Aplicacao() {
    }

	
    public Aplicacao(byte idAplicacao, String descAplicacao, char tipoAplicacao) {
        this.idAplicacao = idAplicacao;
        this.descAplicacao = descAplicacao;
        this.tipoAplicacao = tipoAplicacao;
    }
    public Aplicacao(byte idAplicacao, String descAplicacao, char tipoAplicacao, Set pedidos) {
       this.idAplicacao = idAplicacao;
       this.descAplicacao = descAplicacao;
       this.tipoAplicacao = tipoAplicacao;
       this.pedidos = pedidos;
    }
   
    public byte getIdAplicacao() {
        return this.idAplicacao;
    }
    
    public void setIdAplicacao(byte idAplicacao) {
        this.idAplicacao = idAplicacao;
    }
    public String getDescAplicacao() {
        return this.descAplicacao;
    }
    
    public void setDescAplicacao(String descAplicacao) {
        this.descAplicacao = descAplicacao;
    }
    public char getTipoAplicacao() {
        return this.tipoAplicacao;
    }
    
    public void setTipoAplicacao(char tipoAplicacao) {
        this.tipoAplicacao = tipoAplicacao;
    }
    public Set getPedidos() {
        return this.pedidos;
    }
    
    public void setPedidos(Set pedidos) {
        this.pedidos = pedidos;
    }




}


