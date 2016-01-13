/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static javaapplication1.Constantes.tamanhoMaxMemoria;

/**
 *
 * @author Equipe SO1
 */


/**
 * Responsavel pela gerenciar a memoria
 */
public abstract class TabelaMemoria {

            
    //Utilizado para desfragmentaao e para facilitar a limpeza da memoria quando remover processo
    public static List<MemoriaProcesso> memoriaProcessos = new ArrayList<MemoriaProcesso>();
    
    //A memoria em si
    private static int[] memoria = new int[tamanhoMaxMemoria];
    
    //Recupera a posicao inicial da memoria para um novo processo
    public static int RecuperaPosicaoInicialMemoria(int qtdMemoriaSeparada){
        int posInicial = 0;
        int posFinal = posInicial + qtdMemoriaSeparada;
        
        for (MemoriaProcesso auxMemoriaProcesso : memoriaProcessos) {
            
            int posFinalmemoriaProcesso = auxMemoriaProcesso.posInicialMemoria +  auxMemoriaProcesso.qtdMemoriaSeparada;
            
            if((posInicial >= auxMemoriaProcesso.posInicialMemoria && posInicial <= posFinalmemoriaProcesso)
                    || (posFinal >= auxMemoriaProcesso.posInicialMemoria && posFinal <= posFinalmemoriaProcesso)){
                posInicial = posFinalmemoriaProcesso + 1;
                posFinal = posInicial + qtdMemoriaSeparada;
            }
        }
        
        if(posInicial >= Constantes.tamanhoMaxMemoria){
            posInicial = -1;
        }
            
        
        return posInicial;
    }
    
    //Insere dados em uma posicao, escalonador deve garantir que pode usar essa memoria
    public static void InsereDadosMemoria(int dados[], int qtdDados, int pos){
        
        int posMemoria = pos;
        
        //Insere na memoria os registradores
        for(int i = 0; i < qtdDados; i ++){
            memoria[posMemoria] = dados[i];
            posMemoria++;
        }
    }
    
    //Recupera dados em uma posicao, escalonador deve garantir que pode usar essa memoria
    public static int RecuperaDadosMemoria(int pos){
        return memoria[pos];
    }
    
    //Recupera a entidade que contem os limites de memoria de um processo pelo seu id
    public static MemoriaProcesso RecuperaMemoriaProcesso(int id){
        for (MemoriaProcesso auxMemoriaProcesso : memoriaProcessos) {
            if(auxMemoriaProcesso.idProcesso == id){
                return auxMemoriaProcesso;
            }
        }
        
        return null;
    }
}
