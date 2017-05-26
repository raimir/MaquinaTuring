/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonatan
 */
public enum Comando {
    R(82), L(76), P(80);
    
    private int pos; 
    
    Comando(int pos) {
        this.pos = pos;
    }
    
    public int getValor() {
        return this.pos;
    }
}
