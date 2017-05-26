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
    private char alfabeto;
    private char comando;
    
    public Estado() {}
    
    public Estado(int estado, char alfabeto, char comando) {
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

    public char getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(char alfabeto) {
        this.alfabeto = alfabeto;
    }

    public char getComando() {
        return comando;
    }

    public void setComando(char comando) {
        this.comando = comando;
    }
}
