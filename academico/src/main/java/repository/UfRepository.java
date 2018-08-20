/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;
import java.util.List;
import model.Uf;
import org.springframework.data.mongodb.repository.MongoRepository;
/**
 *
 * @author Muriel
 */
public interface UfRepository extends MongoRepository<Uf, String>{
        public Uf findBySiglaLikeIgnoreCase(String sigla);
}
