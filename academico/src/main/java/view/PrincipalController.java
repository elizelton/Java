package view;

import static config.DAO.disciplinaRepository;
import static config.DAO.professorRepository;
import static config.DAO.unidadeFederacaoRepository;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import model.Cidade;
import model.Disciplina;
import model.Professor;
import model.UnidadeFederacao;

public class PrincipalController implements Initializable {

    Disciplina disciplina;
    Professor professor;
    Cidade cidade;
    UnidadeFederacao uf;
    List<Disciplina> lstDisc = new ArrayList<Disciplina>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //        disciplina = disciplinaRepository.findByCodigo("000004");
        //        lstDisc = disciplinaRepository.findByNomeLikeIgnoreCase("InGLeS");

        //        System.out.println(lstDisc);
        //        disciplinaRepository.delete(lstDisc.get(0));
        //        disciplina = new Disciplina("000011", "Ingles Tecnico", 10, "");
        //        disciplinaRepository.save(disciplina);
        //        disciplina = new Disciplina("000002", "Portugues", 20, "");
        //        disciplinaRepository.save(disciplina);
        //        disciplina = new Disciplina("000003", "Espanhol", 20, "");
        //        disciplinaRepository.save(disciplina);
        //        disciplina = new Disciplina("000004", "Frances", 20, "");
        //        disciplinaRepository.save(disciplina);
        //        disciplina = new Disciplina("000005", "Alemao", 20, "");
        //        disciplinaRepository.save(disciplina);
        //        disciplina = new Disciplina("000006", "Japones", 20, "");
        //        disciplinaRepository.save(disciplina);
        //        disciplina = new Disciplina("000007", "Chines", 20, "");
        //        disciplinaRepository.save(disciplina);
        //        disciplina = new Disciplina("000008", "Mandarim", 20, "");
        //        disciplinaRepository.save(disciplina);
        //        disciplina = new Disciplina("000009", "Italiano", 20, "");
        //        disciplinaRepository.save(disciplina);
        //        disciplina = new Disciplina("000010", "Russo", 20, "");
        //        disciplinaRepository.save(disciplina);
        //        disciplina = disciplinaRepository.findByCodigo("000004");
        //
        //        System.out.println(disciplina);
        //        System.out.println(disciplina.getAulas());
        //
        //        disciplina.setAulas(150);
        //        disciplinaRepository.save(disciplina);
        //
        //        disciplina = disciplinaRepository.findByCodigo("000004");
        //        System.out.println(disciplina);
        //        System.out.println(disciplina.getAulas());
        //        professor = new Professor("Maria", "maria@gmail.com", "105.654.805-90");
        //        professorRepository.save(professor);
        //        professor = new Professor("Julia", "julia@hotmail.com", "650.320.546-20");
        //        professorRepository.save(professor);
        //        professor = new Professor("Fernanda", "fernanda@gmail.com", "156.365.505-78");
        //        professorRepository.save(professor);
        
//        unidadeFederacaoRepository.save(new UnidadeFederacao("AC", "Acre"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("AL", "Alagoas"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("AP", "Amapá"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("AM", "Amazonas"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("BA", "Bahia"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("CE", "Ceará"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("DF", "Distrito Federal"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("ES", "Espírito Santo"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("GO", "Goiás"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("MA", "Maranhão"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("MT", "Mato Grosso"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("MS", "Mato Grosso do Sul"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("MG", "Minas Gerais"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("PA", "Pará"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("PB", "Paraíba"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("PI", "Piauí"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("PR", "Paraná"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("PE", "Pernambuco"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("RJ", "Rio de Janeiro"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("RN", "Rio Grande do Norte"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("RS", "Rio Grande do Sul"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("RO", "Rondônia"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("RR", "Roraima"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("SC", "Santa Catarina"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("SP", "São Paulo"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("SE", "Sergipe"));
//        unidadeFederacaoRepository.save(new UnidadeFederacao("TO", "Tocantins"));
    }
}
