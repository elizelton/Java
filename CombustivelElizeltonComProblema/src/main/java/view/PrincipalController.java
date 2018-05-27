package view;

import java.net.URL;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrincipalController implements Initializable {

    @FXML
    private TextField txtFldGasolinaValor;

    @FXML
    private TextField txtFldGasolinaKmL;

    @FXML
    private TextField txtFldAlcoolValor;

    @FXML
    private TextField txtFldAlcoolKmL;

    @FXML
    private Button bntCalcularClick;

    private final char separadorMoeda = new DecimalFormatSymbols(Locale.getDefault(Locale.Category.FORMAT)).getDecimalSeparator();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
//    private final ChangeListener<? super String> GasolinaValor
//            = (observable, oldValue, newValue) -> {
//                if (!newValue.matches("\\d*(\\" + separadorMoeda + "\\d*)?") && !newValue.isEmpty()) {
//                    txtFldGasolinaValor.setText(oldValue);
//                } else {
//                }
//            };
//    private final ChangeListener<? super String> GasolinaKmL
//            = (observable, oldValue, newValue) -> {
//                if (!newValue.matches("\\d*(\\" + separadorMoeda + "\\d*)?") && !newValue.isEmpty()) {
//                    txtFldGasolinaKmL.setText(oldValue);
//                } else {
//                }
//            };
//    private final ChangeListener<? super String> AlcoolValor
//            = (observable, oldValue, newValue) -> {
//                if (!newValue.matches("\\d*(\\" + separadorMoeda + "\\d*)?") && !newValue.isEmpty()) {
//                    txtFldAlcoolValor.setText(oldValue);
//                } else {
//                }
//            };
//    private final ChangeListener<? super String> AlcoolKmL
//            = (observable, oldValue, newValue) -> {
//                if (!newValue.matches("\\d*(\\" + separadorMoeda + "\\d*)?") && !newValue.isEmpty()) {
//                    txtFldAlcoolKmL.setText(oldValue);
//                } else {
//                }
//            };
}
