package view;

import static config.DAO.alunoRepository;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Aluno;
import model.Matricula;

public class CRUDBoletimController implements Initializable {

    private Aluno aluno;
    private BoletimController controllerPai;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField txtFld1Sem;
    @FXML
    private TextField txtFld2Sem;
    @FXML
    private TextField txtFldExam;
    @FXML
    private TextField txtFldFalt;
    @FXML
    private Label lblNomeDisciplina;
    @FXML
    private Button btnConfirma;

    public void setCadastroController(BoletimController controllerPai) {
        this.controllerPai = controllerPai;
        aluno = controllerPai.aluno;
        lblNomeDisciplina.setText(controllerPai.matricula.getDisciplina().getNome());
        txtFld1Sem.setText(String.valueOf(controllerPai.matricula.getNota1Sem()));
        txtFld2Sem.setText(String.valueOf(controllerPai.matricula.getNota2Sem()));
        txtFldExam.setText(String.valueOf(controllerPai.matricula.getNotaExam()));
        txtFldFalt.setText(String.valueOf(controllerPai.matricula.getFaltas()));
        txtFldExam.disableProperty().bind(ficouExame());

    }

    private BooleanProperty ficouExame() {
        try {
            if ((((Float.parseFloat(txtFld1Sem.getText())) + (Float.parseFloat(txtFld2Sem.getText()))) / 2 > 70)) {
                return new SimpleBooleanProperty(true);
            }
        } catch (NumberFormatException e) {
        }
        return new SimpleBooleanProperty(false);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnConfirma.disableProperty().bind(txtFld1Sem.textProperty().isEmpty().or(txtFld2Sem.textProperty().isEmpty()).or(txtFldExam.textProperty().isEmpty()).or(txtFldFalt.textProperty().isEmpty()));
//        txtFldExam.disabledProperty().bind();
    }

    @FXML
    private void btnCancelaClick() {
        controllerPai.tblViewBoletim.requestFocus();
        anchorPane.getScene().getWindow().hide();
    }

    @FXML
    private void btnConfirmaClick() {
        int nota1, nota2, notaE;
        nota1 = Integer.parseInt(txtFld1Sem.getText());
        nota2 = Integer.parseInt(txtFld2Sem.getText());
        notaE = Integer.parseInt(txtFldExam.getText());
        controllerPai.matricula.setNota1Sem(nota1);
        controllerPai.matricula.setNota2Sem(nota2);
        controllerPai.matricula.setNotaExam(notaE);
        controllerPai.matricula.setFaltas(Integer.parseInt(txtFldFalt.getText()));
//        List<Matricula> lstTemp = new ArrayList<>();
//        lstTemp.addAll(controllerPai.aluno.getMatriculas());
//        lstTemp.add(controllerPai.matricula);
        controllerPai.aluno.setMatricula(controllerPai.matricula);
//        controllerPai.aluno.setMatriculas(lstTemp);
        if (validaNota(nota1) && validaNota(notaE) && validaNota(nota2)) {
            try {
                alunoRepository.save(controllerPai.aluno);
                controllerPai.tblViewBoletim.setItems(FXCollections.observableList(controllerPai.aluno.getMatriculas()));
                controllerPai.tblViewBoletim.refresh();
                controllerPai.tblViewBoletim.getSelectionModel().clearSelection();
                controllerPai.tblViewBoletim.requestFocus();
                System.out.println(controllerPai.aluno.getMatriculas());
                anchorPane.getScene().getWindow().hide();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Cadastro de Disciplina");
                if (e.getMessage().contains("duplicate key")) {
                    alert.setContentText("Código já cadastrado");
                } else {
                    alert.setContentText(e.getMessage());
                }
                alert.showAndWait();
            }
        }
    }

    private boolean validaNota(int nota) {
        if (nota > 100 || nota < 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Edição de Nota!");
            alert.setContentText("Nota(s)não pode ser menor que 0 ou maior que 100");
            alert.showAndWait();
            return false;
        } else {
            return true;
        }
    }
}
