/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static config.Config.INCLUIR;
import static config.Config.ALTERAR;
import static config.Config.EXCLUIR;
import static config.DAO.disciplinaRepository;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import model.Disciplina;
import org.springframework.data.domain.Sort;
import utility.XPopOver;

/**
 * FXML Controller class
 *
 * @author Muriel
 */
public class DisciplinaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public TableView tblView;
    public char acao;
    public Disciplina disciplina;
    @FXML 
    private MaterialDesignIconView btnIncluir;
    @FXML 
    private MaterialDesignIconView btnAlterar;
    @FXML 
    private MaterialDesignIconView btnExcluir;
    @FXML 
    private void acIncluir(){
        acao = INCLUIR;
        disciplina = new Disciplina();

    showCRUD();

    }
    @FXML 
    private void acAlterar(){
        acao = ALTERAR;
        disciplina = (Disciplina) tblView.getSelectionModel().getSelectedItem();

    showCRUD();

    }
    @FXML 
    private void acExcluir(){
        acao = EXCLUIR;
        disciplina = (Disciplina) tblView.getSelectionModel().getSelectedItem();

    showCRUD();

    }
    private void showCRUD(){
        String cena =   "/fxml/CRUDDisciplina.fxml";
        XPopOver popOver    =   null;
        
        switch(acao){
            case INCLUIR    :
                popOver = new XPopOver(cena,"Inclusão de Disciplina", btnIncluir);    
                break;
            case ALTERAR    :   
                popOver = new XPopOver(cena,"Inclusão de Disciplina", btnAlterar);    
                break;
                case EXCLUIR   :   
                popOver = new XPopOver(cena,"Inclusão de Disciplina", btnExcluir);    
                break;
        }
        CRUDDisciplinaController controllerFilho    =   popOver.getLoader().getController();
        controllerFilho.setCadastroController(this);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblView.setItems(
        FXCollections.observableList(disciplinaRepository.findAll(new Sort(new Sort.Order("nome")))));
    }    
    
}
