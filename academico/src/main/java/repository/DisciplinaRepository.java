package repository;

import model.Disciplina;
//import model.Professor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DisciplinaRepository extends MongoRepository<Disciplina, String> {

//    public Integer countByProfessor(Professor professor);
}
