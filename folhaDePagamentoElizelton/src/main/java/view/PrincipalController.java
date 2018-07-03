package view;

import java.net.URL;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.Administrativo;
import model.Funcionario;
import model.Gerente;
import model.Vendedor;

public class PrincipalController implements Initializable {

    @FXML
    private Button btnCadastrarFunc;

    @FXML
    private RadioButton rdBtnGerente;

    @FXML
    private RadioButton rdBtnAdm;

    @FXML
    private RadioButton rdBtnMasc;

    @FXML
    private TextField txtFldNomeFunc;

    @FXML
    private TextField txtFldSalFunc;

    @FXML
    private TextField txtFldExtra;

    @FXML
    private Label lblExtra;

    @FXML
    private VBox vBoxExtra;

    @FXML
    private TableView tbVwFuncs;

    private List<Funcionario> lstFuncionarios = new ArrayList<Funcionario>();

    private final char separadorDecimal = new DecimalFormatSymbols(Locale.getDefault(Locale.Category.FORMAT)).getDecimalSeparator();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        limparCampos();
        txtFldNomeFunc.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (!newValue.matches("\\D*") || newValue.matches("\\p{Punct}")) {
                    txtFldNomeFunc.setText(oldValue);
                } else {
                    txtFldNomeFunc.setText(newValue.toUpperCase());
                }
            }
        });
        txtFldSalFunc.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (!newValue.matches("\\d*(\\" + separadorDecimal + "\\d*)?") && !newValue.isEmpty()) {
                        txtFldSalFunc.setText(oldValue);
                    } else {
                        txtFldSalFunc.setText(newValue);
                    }
                }
        );

        txtFldExtra.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (!newValue.matches("\\d*(\\" + separadorDecimal + "\\d*)?") && !newValue.isEmpty()) {
                        txtFldExtra.setText(oldValue);
                    } else {
                        txtFldExtra.setText(newValue);
                    }
                }
        );
//        Mudar cor das linhas - não funcionando
//        tbVwFuncs.setRowFactory(TableView
//                -> {
//            TableRow< Funcionario> row = new TableRow<>();
//            row.itemProperty().addListener(
//                    (observable, oldValue, newValue) -> {
////                        if (newValue != null && (newValue.getClass().equals(Administrativo.class))) {
////                            row.getStyleClass().add("administrativo");
////                        } else {
////                            row.getStyleClass().remove("administrativo");
////                        }
//                        if (newValue != null){
//                            if(newValue.getClass().equals(Administrativo.class)){
//                                 row.getStyleClass().add("administrativo");
//                            }
//                            else if(newValue.getClass().equals(Gerente.class)){
//                                 row.getStyleClass().add("gerente");
//                            }
//                            else{
//                                row.getStyleClass().add("vendedor");
//                            }
//                        }
//                    });
//            return row;
//
//        }
//        );
    }

    private void limparCampos() {
        txtFldNomeFunc.requestFocus();
        rdBtnAdmSelect();
        btnCadastrarFunc.disableProperty().bind(txtFldNomeFunc.textProperty().isEmpty().or(txtFldSalFunc.textProperty().isEmpty()));
        txtFldNomeFunc.requestFocus();
        txtFldNomeFunc.clear();
        txtFldExtra.clear();
        txtFldSalFunc.clear();
        rdBtnAdm.setSelected(true);
        rdBtnMasc.setSelected(true);
    }

    @FXML
    private void btnCadastrarFuncClick(ActionEvent event) {
        String sexo;

        if (rdBtnMasc.isSelected()) {
            sexo = "M";
        } else {
            sexo = "F";
        }

        if (rdBtnAdm.isSelected()) {
            lstFuncionarios.add(0, new Administrativo(txtFldNomeFunc.getText(), Float.valueOf(txtFldSalFunc.getText()), sexo));

        } else if (rdBtnGerente.isSelected()) {
            lstFuncionarios.add(0, new Gerente(txtFldNomeFunc.getText(), Float.valueOf(txtFldSalFunc.getText()), sexo, Float.valueOf(txtFldExtra.getText())));

        } else {
            lstFuncionarios.add(0, new Vendedor(txtFldNomeFunc.getText(), Float.valueOf(txtFldSalFunc.getText()), sexo, Float.valueOf(txtFldExtra.getText())));

        }
        tbVwFuncs.setItems(FXCollections.observableArrayList(lstFuncionarios));

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Folha de pagamento");
        alert.setHeaderText(null);
        alert.setContentText(String.format("%s cadastrado com sucesso!", lstFuncionarios.get(0).getTipo().toUpperCase()));
        alert.showAndWait();

        limparCampos();
    }

    @FXML
    private void rdBtnGerenteSelect() {
        vBoxExtra.setVisible(true);
        lblExtra.setText("Total Bonificações");
        btnCadastrarFunc.disableProperty().bind(txtFldNomeFunc.textProperty().isEmpty().or(txtFldSalFunc.textProperty().isEmpty()).or(txtFldExtra.textProperty().isEmpty()));

    }

    @FXML
    private void rdBtnAdmSelect() {
        txtFldExtra.clear();
        vBoxExtra.setVisible(false);
        btnCadastrarFunc.disableProperty().bind(txtFldNomeFunc.textProperty().isEmpty().or(txtFldSalFunc.textProperty().isEmpty()));

    }

    @FXML
    private void rdBtnVendSelect() {
        vBoxExtra.setVisible(true);
        lblExtra.setText("Total Vendas");
        btnCadastrarFunc.disableProperty().bind(txtFldNomeFunc.textProperty().isEmpty().or(txtFldSalFunc.textProperty().isEmpty()).or(txtFldExtra.textProperty().isEmpty()));
    }

}
