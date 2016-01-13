/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.List;
import static javaapplication1.TabelaMemoria.memoriaProcessos;

/**
 *
 * @author Equipe SO1
 */

/**
 * Responsavel pela gerencia das filas de processos e processamento
 */
public abstract class Escalonador {
    
    //Gerador de IDs para os processos
    private static int contadorId = 0;
    
    //Lista com todos os processos criados (que nao estao bloqueados!)
    public static List<Processo> processos = new ArrayList<Processo>();

    //Adiona um processo a lista de processos
    public static boolean AdicionarProcesso(int qtdMemoriaSeparada, String prioridade, String nome) {

        Processo processo = new Processo(contadorId, prioridade, nome);
        
        //Veriica se cabe
        int posInicialMemoria = TabelaMemoria.RecuperaPosicaoInicialMemoria(qtdMemoriaSeparada);
        
        if(posInicialMemoria == -1){
             //Desfragmenta
             System.err.println("FODEU");
             return false;
        }
        else{
            //Adiciona tabela de Processos e posicao memoria
            TabelaMemoria.memoriaProcessos.add(new MemoriaProcesso(contadorId, posInicialMemoria, qtdMemoriaSeparada));
            processos.add(processo);
            contadorId++;
            return true;
        }
    }
    
    //Realiza o processamento do processo em questao (IO/ memoria /etc)
    public static void Processa(Processo processo){
        //processa o processo selecionado previamente
    }
    
    //Escolhe um processo que sera selecionado. Todas as implementacoes ficam aqui
    public static Processo Escalona(){
        //retorna o processo que sera processado
        
        return null;
    }
    
    //Lista dados de todos os processos para exibir na tela
    public static String ListarDadosProcessos(){
        
        String retorno = "";
        
        for (Processo auxProcessos : processos) {
           retorno += ListarDadosProcesso(auxProcessos);    
        }
        
        return retorno;
    }
    
    //Lista dados de apenas um processo (utilizado no debug)
    public static String ListarDadosProcesso(Processo auxProcessos){
        
        String retorno = "";

        retorno += "\n Processo: " + auxProcessos.nome;
        retorno += " Id: " + auxProcessos.id;
        retorno += " Prioridade: " + auxProcessos.prioridade;
        retorno += " Estado Processo: " + auxProcessos.estadoProcesso;

        MemoriaProcesso auxMemoriaProcesso = TabelaMemoria.RecuperaMemoriaProcesso(auxProcessos.id);

        int posMemoria = auxMemoriaProcesso.posInicialMemoria;

        for(int i = 0; i < Constantes.qtdRegistradores; i ++){
            retorno += " Registrador " + i + ": " + TabelaMemoria.RecuperaDadosMemoria(posMemoria);
            posMemoria++;
        }            

        return retorno;
    }
}
