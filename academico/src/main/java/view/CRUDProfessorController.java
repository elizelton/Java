/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static config.Config.ALTERAR;
import static config.Config.EXCLUIR;
import static config.Config.INCLUIR;
import static config.DAO.professorRepository;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Professor;
import model.Disciplina;
import org.springframework.data.domain.Sort;

/**
 * FXML Controller class
 *
 * @author idomar
 */
public class CRUDProfessorController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private ProfessorController controllerPai;

    @FXML
    private TextField txtFldCpf;

    @FXML
    private TextField txtFldNome;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button btnConfirma;

    @FXML
    private ComboBox cmbProfessor;

    @FXML
    private void btnCancelaClick() {
        anchorPane.getScene().getWindow().hide();
        controllerPai.tblView.requestFocus();
    }

    @FXML
    private void btnConfirmaClick() {
        controllerPai.professor.setCpf(txtFldCpf.getText());
        controllerPai.professor.setNome(txtFldNome.getText());
//        controllerPai.disciplina.setProfessor((Professor) cmbProfessor.getSelectionModel().getSelectedItem());
        try {
            switch (controllerPai.acao) {
                case INCLUIR:
                    professorRepository.insert(controllerPai.professor);
                    break;
                case ALTERAR:
                    professorRepository.save(controllerPai.professor);
                    break;
                case EXCLUIR:
                    professorRepository.delete(controllerPai.professor);
                    break;
            }
            controllerPai.tblView.setItems(
                    FXCollections.observableList(professorRepository.findAll(
                            new Sort(new Sort.Order("nome")))));
            controllerPai.tblView.refresh();
            controllerPai.tblView.getSelectionModel().clearSelection();
            controllerPai.tblView.getSelectionModel().select(controllerPai.professor);
            anchorPane.getScene().getWindow().hide();

        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Cadastro de Professor");
            if (e.getMessage().contains("duplicate key")) {
                alert.setContentText("Código já cadastrado");
            } else {
                alert.setContentText(e.getMessage());
            }
            alert.showAndWait();

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//
//        btnConfirma.disableProperty().bind(txtFldCodigo.textProperty().isEmpty().
//                or(txtFldNome.textProperty().isEmpty()));

    }

    public void setCadastroController(ProfessorController controllerPai) {
        this.controllerPai = controllerPai;
        txtFldCpf.setText(controllerPai.professor.getCpf());
        txtFldNome.setText(controllerPai.professor.getNome());

//        cmbProfessor.setItems(FXCollections.observableList(
//                professorRepository.findAll(new Sort(new Sort.Order("nome")))));
//
//        if (controllerPai.acao != INCLUIR) {
//            cmbProfessor.getSelectionModel().select(controllerPai.disciplina.getProfessor());
//        }
         txtFldCpf.setDisable(controllerPai.acao == EXCLUIR);
        txtFldNome.setDisable(controllerPai.acao == EXCLUIR);

    }

}
