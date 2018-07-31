package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import model.Disciplina;

public class PrincipalController implements Initializable {

    Disciplina disciplina;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        disciplina = new Disciplina("110110", "Ingles", 20, "");
    }
}
