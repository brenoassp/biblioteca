/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

/**
 *
 * @author breno
 */
public class EmprestimoConsulta implements TipoEmprestimo{

    @Override
    public float calculaMulta(int numeroDias) {
        return (float) (numeroDias * 10);
    }
    
}
