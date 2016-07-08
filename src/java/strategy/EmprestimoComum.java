package strategy;

/**
 *
 * @author breno
 */
public class EmprestimoComum implements TipoEmprestimo {

    @Override
    public float calculaMulta(int numeroDias) {
        return (float) (numeroDias * 0.5);
    }
    
}
