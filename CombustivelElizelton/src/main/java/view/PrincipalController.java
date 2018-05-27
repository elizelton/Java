package view;

import java.net.URL;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Button btnCalcular;

    @FXML
    private Button btnLimpar;

    @FXML
    private Label lblMelhorCombustivel;

    @FXML
    private void bntCalcularClick(Event event) {
        comparaCombustivel();
    }

    private final char separadorDecimal = new DecimalFormatSymbols(Locale.getDefault(Locale.Category.FORMAT)).getDecimalSeparator();
    private final NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());

    @FXML
    private void btnLimparCamposClick(Event event) {
        txtFldGasolinaValor.clear();
        txtFldGasolinaKmL.clear();
        txtFldAlcoolValor.clear();
        txtFldAlcoolKmL.clear();
        lblMelhorCombustivel.setText(" ");
    }

    @FXML
    private void btnFecharClick(Event event) {
        System.exit(0);
    }

    private Double calculaFatorCombustivel(double valComb, double ValPorKm) {
        return (valComb / ValPorKm);
    }

    private void comparaCombustivel() {
        double gasolina, alcool;

        try {
            if ((nf.parse(txtFldGasolinaKmL.getText()).doubleValue()) > (nf.parse(txtFldAlcoolKmL.getText()).doubleValue())) {

                gasolina = calculaFatorCombustivel(nf.parse(txtFldGasolinaValor.getText()).doubleValue(), nf.parse(txtFldGasolinaKmL.getText()).doubleValue());
                alcool = calculaFatorCombustivel(nf.parse(txtFldAlcoolValor.getText()).doubleValue(), nf.parse(txtFldAlcoolKmL.getText()).doubleValue());

                if (alcool == gasolina) {
                    lblMelhorCombustivel.setStyle("-fx-text-fill: blue;");
                    lblMelhorCombustivel.setText("Tanto o Álcool quanto da Gasolina tem o mesmo rendimento.");
                } else if (alcool > gasolina) {
                    lblMelhorCombustivel.setStyle("-fx-text-fill: green;");
                    lblMelhorCombustivel.setText("A melhor opção é a Gasolina.");
                } else {
                    lblMelhorCombustivel.setStyle("-fx-text-fill: green;");
                    lblMelhorCombustivel.setText("A melhor opção é o Álcool.");
                }
            } else {
                lblMelhorCombustivel.setStyle("-fx-text-fill: red;");
                lblMelhorCombustivel.setText("O rendimento do Álcool não pode ser superior ao da Gasolina.");
            }
        } catch (ParseException ex) {
            System.out.println("Erro botao calcular click");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btnCalcular.disableProperty().bind(
                txtFldGasolinaValor.textProperty().isEmpty().or(
                        txtFldGasolinaKmL.textProperty().isEmpty()).or(
                        txtFldAlcoolValor.textProperty().isEmpty()).or(
                        txtFldAlcoolKmL.textProperty().isEmpty())
        );

        btnLimpar.disableProperty().bind(
                txtFldGasolinaValor.textProperty().isEmpty().and(
                        txtFldGasolinaKmL.textProperty().isEmpty()).and(
                        txtFldAlcoolValor.textProperty().isEmpty()).and(
                        txtFldAlcoolKmL.textProperty().isEmpty())
        );
        txtFldGasolinaValor.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (!newValue.matches("\\d*(\\" + separadorDecimal + "\\d*)?")
                    && !newValue.isEmpty()) {
                        txtFldGasolinaValor.setText(oldValue);
                    } else {
                        txtFldGasolinaValor.setText(newValue);
                    }
               });
        txtFldGasolinaKmL.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (!newValue.matches("\\d*(\\" + "\\d*)?")
                    && !newValue.isEmpty()) {
                        txtFldGasolinaKmL.setText(oldValue);
                    } else {
                        txtFldGasolinaKmL.setText(newValue);
                    }
               });
        txtFldAlcoolValor.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (!newValue.matches("\\d*(\\" + separadorDecimal + "\\d*)?")
                    && !newValue.isEmpty()) {
                        txtFldAlcoolValor.setText(oldValue);
                    } else {
                        txtFldAlcoolValor.setText(newValue);
                    }
             });
        txtFldAlcoolKmL.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (!newValue.matches("\\d*(\\" + "\\d*)?")
                    && !newValue.isEmpty()) {
                        txtFldAlcoolKmL.setText(oldValue);
                    } else {
                        txtFldAlcoolKmL.setText(newValue);
                    }
                });
    }
}
