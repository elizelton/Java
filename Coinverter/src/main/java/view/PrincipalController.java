package view;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Moeda;

public class PrincipalController implements Initializable {

    private final List<Moeda> moedas = new ArrayList<>();
    private boolean ehDe = true;
    private double fator = 1;
    private final DecimalFormat nf = new DecimalFormat("#,##0.00");
    private final char separadorMoeda = new DecimalFormatSymbols(Locale.getDefault(Locale.Category.FORMAT)).getDecimalSeparator();

    @FXML
    private ComboBox cmbMoedas;

    @FXML
    private ImageView imgSetas;

    @FXML
    private TextField txtValorDe;

    @FXML
    private TextField txtValorPara;

    @FXML
    private Label lblUnDe;

    @FXML
    private Label lblUnPara;

    @FXML
    private void btnFecharClick(Event event) {
        System.exit(0);
    }

    ;
    private String convertido(double val) {
        double v;
        if (ehDe) {
            v = val * fator;
        } else {
            v = val / fator;
        }
        return nf.format(v);
    }

    private void atualizaTxtFld() {
        if (ehDe) {
            try {
                txtValorPara.setText(convertido(nf.parse(txtValorDe.getText()).doubleValue()));
            } catch (ParseException ex) {
                txtValorPara.setText("");
            }
        } else {
            try {
                txtValorDe.setText(convertido(nf.parse(txtValorPara.getText()).doubleValue()));
            } catch (ParseException ex) {
                txtValorDe.setText("");
            }
        }
    }

    private final ChangeListener<? super String> ListenerDe
            = (observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*(\\" + separadorMoeda
                        + "\\d*)?") && !newValue.isEmpty()) {
                    txtValorDe.setText(oldValue);
                } else {
                    atualizaTxtFld();
                }
            };

    private final ChangeListener<? super String> ListenerPara
            = (observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*(\\" + separadorMoeda
                        + "\\d*)?") && !newValue.isEmpty()) {
                    txtValorPara.setText(oldValue);
                } else {
                    atualizaTxtFld();
                }
            };

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        moedas.add(new Moeda("Real", "BRL", "Dólar", "USD", 0.30193));
        moedas.add(new Moeda("Real", "BRL", "Euro", "EUR", 0.244331332));
        moedas.add(new Moeda("Euro", "EUR", "Dólar", "USD", 1.23574));

        cmbMoedas.setItems(FXCollections.observableArrayList(moedas));
        cmbMoedas.valueProperty().addListener(
                new ChangeListener<Moeda>() {
            @Override
            public void changed(ObservableValue<? extends Moeda> observable, Moeda oldValue, Moeda newValue) {

                lblUnDe.setText(newValue.getSiglaDe());
                lblUnPara.setText(newValue.getSiglaPara());
                fator = newValue.getFator();
                atualizaTxtFld();
            }
        });
        //    LISTENER PARA FOCO NO TEXTFIELD
        txtValorDe.focusedProperty().addListener(
                (ObservableValue<? extends Boolean> Observable, Boolean oldValue, Boolean newValue) -> {
                    if (newValue) {
                        ehDe = true;
                        imgSetas.setImage(new Image("/image/SetasDireita.png"));
                        txtValorDe.textProperty().addListener(ListenerDe);
                    } else {
                        txtValorDe.textProperty().removeListener(ListenerDe);
                    }
                }
        );
        txtValorPara.focusedProperty().addListener(
                (ObservableValue<? extends Boolean> Observable, Boolean oldValue, Boolean newValue) -> {
                    if (newValue) {
                        ehDe = false;
                        imgSetas.setImage(new Image("/image/SetasEsquerda.png"));
                        txtValorPara.textProperty().addListener(ListenerPara);
                    } else {
                        txtValorPara.textProperty().addListener(ListenerPara);
                    }
                }
        );
    }

}
