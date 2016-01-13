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

/**
 * Responsavel por armazenar o id do processo e a posicao inicial e final da memoria que ocupa
 * utilizado pela TabelaMemoria
 */
public class MemoriaProcesso {
    public int idProcesso;
    public int posInicialMemoria;
    public int qtdMemoriaSeparada;

    public MemoriaProcesso(int idProcesso, int posInicialMemoria, int qtdMemoriaSeparada) {
        this.idProcesso = idProcesso;
        this.posInicialMemoria = posInicialMemoria;
        this.qtdMemoriaSeparada = qtdMemoriaSeparada;
    }
}
