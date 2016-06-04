/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import model.AlunoGraduacao;
import model.AlunoPosGraduacao;

/**
 *
 * @author breno
 */
public class AlunoDAO implements DAO<Aluno>{

    private static final AlunoDAO instancia = new AlunoDAO();
    
    public static AlunoDAO getInstance(){
        return instancia;
    }
    
    @Override
    public List<Aluno> getAll() {
        List<Aluno> list = new ArrayList<>();
        for(AlunoGraduacao aluno : AlunoGraduacaoDAO.getInstance().getAll()){
            list.add(aluno);
        }
        for(AlunoPosGraduacao aluno : AlunoPosGraduacaoDAO.getInstance().getAll()){
            list.add(aluno);
        }
        return list;
    }

    @Override
    public void update(Aluno t) {
        if(t instanceof AlunoGraduacao){
            AlunoGraduacaoDAO.getInstance().update((AlunoGraduacao)t);
        }else if(t instanceof AlunoPosGraduacao){
            AlunoPosGraduacaoDAO.getInstance().update((AlunoPosGraduacao)t);
        }
    }

    @Override
    public void delete(Aluno t) {
        //PessoaDAO.getInstance().delete(t);
    }

    @Override
    public Aluno get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aluno get(String matricula) {
        for(Aluno aluno : getAll()){
            if(aluno.getMatricula().equals(matricula)){
                return aluno;
            }
        }
        return null;
    }

    @Override
    public void insert(Aluno t) {
        if(t instanceof AlunoGraduacao){
            AlunoGraduacaoDAO.getInstance().insert((AlunoGraduacao)t);
        }else if(t instanceof AlunoPosGraduacao){
            AlunoPosGraduacaoDAO.getInstance().insert((AlunoPosGraduacao)t);
        }
    }
    
}