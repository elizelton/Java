package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import model.*;

public class PrincipalController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Gerente gerComercial = new Gerente("Elizelton", 10000, "Masculino", 0);
        System.out.println(gerComercial);
        System.out.println(gerComercial.getTipo());
    }
}
