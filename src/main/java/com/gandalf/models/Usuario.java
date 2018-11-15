package com.gandalf.models;

import java.util.HashSet;
import java.util.Set;

public class Usuario implements java.io.Serializable {

    private int idUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    private String nomeUsuario;
    private Character tipoPerfil;
    private Boolean usuarioAtivo;
    private Set produtos = new HashSet(0);

    public Usuario() {
    }

    public Usuario(int idUsuario, String loginUsuario) {
        this.idUsuario = idUsuario;
        this.loginUsuario = loginUsuario;
    }

    public Usuario(int idUsuario, String loginUsuario, String senhaUsuario, String nomeUsuario, Character tipoPerfil, Boolean usuarioAtivo, Set produtos) {
        this.idUsuario = idUsuario;
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
        this.nomeUsuario = nomeUsuario;
        this.tipoPerfil = tipoPerfil;
        this.usuarioAtivo = usuarioAtivo;
        this.produtos = produtos;
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLoginUsuario() {
        return this.loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getSenhaUsuario() {
        return this.senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Character getTipoPerfil() {
        return this.tipoPerfil;
    }

    public void setTipoPerfil(Character tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public Boolean getUsuarioAtivo() {
        return this.usuarioAtivo;
    }

    public void setUsuarioAtivo(Boolean usuarioAtivo) {
        this.usuarioAtivo = usuarioAtivo;
    }

    public Set getProdutos() {
        return this.produtos;
    }

    public void setProdutos(Set produtos) {
        this.produtos = produtos;
    }

}
