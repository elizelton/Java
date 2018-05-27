package view;

import java.net.URL;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
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
import model.Medida;

public class PrincipalController implements Initializable {

    private List<Medida> medidas = new ArrayList<>();
    private boolean ehDe = true;
    private double fator = 1;
    private final char separadorDecimal = new DecimalFormatSymbols(Locale.getDefault(Locale.Category.FORMAT)).getDecimalSeparator();
    private final NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());

    @FXML
    private ComboBox cmbMedidas;

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

    @FXML
    private void btnTesteClick(Event event) {
        Medida medSelecionada = null;
        medSelecionada = (Medida) cmbMedidas.getSelectionModel().getSelectedItem();

        lblUnDe.setText(medSelecionada.getSiglaDe());
        lblUnPara.setText(medSelecionada.getSiglaPara());
        fator = medSelecionada.getFator();
        ehDe = false;
        atualizaTxtFld();
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
                if (!newValue.matches("\\d*(\\" + separadorDecimal
                        + "\\d*)?") && !newValue.isEmpty()) {
                    txtValorDe.setText(oldValue);
                } else {
                    atualizaTxtFld();
                }
            };

    private final ChangeListener<? super String> ListenerPara
            = (observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*(\\" + separadorDecimal
                        + "\\d*)?") && !newValue.isEmpty()) {
                    txtValorPara.setText(oldValue);
                } else {
                    atualizaTxtFld();
                }
            };

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        medidas.add(new Medida("Quilometro", "Km", "Milha", "Mil", 0.62));
        medidas.add(new Medida("Quilometro", "Km", "Metro", "M", 1000));
        medidas.add(new Medida("Metro", "M", "Polegada", "Pol", 0.0254));

        cmbMedidas.setItems(FXCollections.observableArrayList(medidas));
        cmbMedidas.valueProperty().addListener(
                new ChangeListener<Medida>() {
            @Override
            public void changed(ObservableValue<? extends Medida> observable, Medida oldValue, Medida newValue) {

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
