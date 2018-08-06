package repository;

import java.util.List;
import model.Disciplina;
//import model.Professor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DisciplinaRepository extends MongoRepository<Disciplina, String> {

//        public Integer countByProfessor(Professor professor);
    public Disciplina findByCodigo(String codigo);
    public List<Disciplina> findByNome(String nome);
    public List<Disciplina> findByNomeIgnoreCase(String nome);
    public List<Disciplina> findByNomeLikeIgnoreCase(String nome);
    
    public void deleteByCodigo(String codigo);
}
