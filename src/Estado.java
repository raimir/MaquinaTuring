/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 141052976
 */
public class Estado {
    private int estado;
    private String alfabeto;
    private String comando;
    
    public Estado() {}
    
    public Estado(int estado, String alfabeto, String comando) {
        this.estado = estado;
        this.alfabeto = alfabeto;
        this.comando = comando;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(String alfabeto) {
        this.alfabeto = alfabeto;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }
}
