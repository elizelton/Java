package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static config.Config.ALTERAR;
import static config.Config.EXCLUIR;
import static config.Config.INCLUIR;
import static config.DAO.professorRepository;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Professor;
import org.springframework.data.domain.Sort;
import utility.Json;
import utility.XPopOver;

/**
 * FXML Controller class
 *
 * @author Elizelton
 */
public class ProfessorController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public TableView<Professor> tblView;
    public char acao;
    public Professor professor;

    @FXML
    private MaterialDesignIconView btnIncluir;
    @FXML
    private MaterialDesignIconView btnAlterar;
    @FXML
    private MaterialDesignIconView btnExcluir;
    @FXML
    private MaterialDesignIconView btnDisciplinas;
    @FXML
    private TextField txtFldPesquisar;
    @FXML
    private MaterialDesignIconView btnPesquisar;
    @FXML
    private MenuItem mnIncluir;
    @FXML
    private MenuItem mnAlterar;
    @FXML
    private MenuItem mnExcluir;
    @FXML
    private MenuItem mnDisciplinas;

    @FXML
    private void btnImportarClick() {
        final Stage stage = null;
        String nomeArq;
//        List<Professor> tempProf = new ArrayList<Professor>();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Importação Lista de Professor .JSON");
//        Diretorio inicial Linux
//        fileChooser.setInitialDirectory(new File("/home/elizelton/Dados"));
//        Diretorio inicial Windows
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "Arquivo JSON", "*.json"
        );
        fileChooser.getExtensionFilters().add(extFilter);
        nomeArq = String.valueOf(fileChooser.showOpenDialog(stage));

        if (nomeArq.isEmpty()) {
            System.out.println(nomeArq);
            try {
                Json jsonProfessor = new Json(nomeArq);
                professorRepository.save(jsonProfessor.ImportarJsonProfessor());
                tblView.setItems(FXCollections.observableList(professorRepository.findAll(new Sort(new Sort.Order("nome")))));
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Importação de Professor");
                if (e.getMessage().contains("duplicate key")) {
                    alert.setContentText("Professor(es) já Cadastrado(s)!");
                } else {
                    alert.setContentText(e.getMessage());
                }
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void btnExportarClick() {
        final Stage stage = null;
        List<Professor> tempProf = new ArrayList<Professor>();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName("Professor");
        fileChooser.setTitle("Exportar Lista de Professor .JSON");

//        Diretorio inicial Linux
//        fileChooser.setInitialDirectory(new File("/home/elizelton/Dados"));
//        Diretorio inicial Windows
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "Arquivo JSON", "*.json"
        );
        fileChooser.getExtensionFilters().add(extFilter);

        Json jsonProfessor = new Json(String.valueOf(fileChooser.showSaveDialog(stage)));

        tempProf = professorRepository.findAll();

        jsonProfessor.ExportarJsonProfessor(tempProf);

    }

    @FXML
    private void acIncluir() {
        acao = INCLUIR;
        professor = new Professor();

        showCRUD();

    }

    @FXML
    private void acAlterar() {
        acao = ALTERAR;

        professor = tblView.getSelectionModel().getSelectedItem();
        showCRUD();

    }

    @FXML
    private void acExcluir() {
        acao = EXCLUIR;

        professor = tblView.getSelectionModel().getSelectedItem();
        showCRUD();

    }

    @FXML
    private void acPesquisar() {

        tblView.setItems(FXCollections.observableList(
                professorRepository.findByNomeLikeIgnoreCase(txtFldPesquisar.getText())));
    }

    @FXML
    private void acLimpar() {
        txtFldPesquisar.setText("");
        tblView.setItems(
                FXCollections.observableList(professorRepository.findAll(new Sort(new Sort.Order("nome")))));
    }

    @FXML
    private void acDisciplinas() {
        professor = tblView.getSelectionModel().getSelectedItem();

        String cena = "/fxml/CRUDProfessorDisciplina.fxml";
        XPopOver popOver;
        popOver = new XPopOver(cena, "Lista de disciplinas", btnDisciplinas);
        CRUDProfessorDisciplinaController controllerFilho = popOver.getLoader().getController();
        controllerFilho.setCadastroController(this);
    }

    private void showCRUD() {
        String cena = "/fxml/CRUDProfessor.fxml";
        XPopOver popOver = null;

        switch (acao) {
            case INCLUIR:
                popOver = new XPopOver(cena, "Inclusão de Professor", btnIncluir);
                break;
            case ALTERAR:
                popOver = new XPopOver(cena, "Alteração de Professor", btnAlterar);
                break;
            case EXCLUIR:
                popOver = new XPopOver(cena, "Exclusão de Professor", btnExcluir);
                break;
        }
        CRUDProfessorController controllerFilho = popOver.getLoader().getController();
        controllerFilho.setCadastroController(this);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblView.setItems(
                FXCollections.observableList(professorRepository.findAll(new Sort(new Sort.Order("nome")))));
        btnAlterar.visibleProperty().bind(
                Bindings.isEmpty((tblView.getSelectionModel().getSelectedItems())).not());
        btnExcluir.visibleProperty().bind(btnAlterar.visibleProperty());
        btnDisciplinas.visibleProperty().bind(btnAlterar.visibleProperty());
        mnAlterar.visibleProperty().bind(btnAlterar.visibleProperty());
        mnExcluir.visibleProperty().bind(btnAlterar.visibleProperty());
        mnDisciplinas.visibleProperty().bind(btnAlterar.visibleProperty());
        btnPesquisar.disableProperty().bind(txtFldPesquisar.textProperty().isEmpty());
    }

}
