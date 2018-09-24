/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.List;
import model.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Elizelton
 */
public interface AlunoRepository extends MongoRepository<Aluno, String> {

    public List<Aluno> findByNomeLikeIgnoreCase(String nome);
    public List<Aluno> findByNomeLikeIgnoreCaseOrEmailLikeIgnoreCase(String nome,String email);
    public Aluno findByRa(String ra);
}
