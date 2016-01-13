/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Equipe SO1
 */

//Entidade processo
public class Processo {
    public int id;
    public String nome;
    public int contadorPrograma;
    public int estadoProcesso;
    public int prioridade;
    public int[] registradores;
    
    public Processo(){
        
    }
    
    public Processo(int id, String prioridade, String nome){
        this.id = id;
        this.nome = nome;
        this.contadorPrograma = 0;
        this.estadoProcesso = 0;
        this.prioridade = 0;
        this.registradores = new int[Constantes.qtdRegistradores];
    }
}
