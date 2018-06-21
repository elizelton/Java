package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
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
    private RadioButton rdBtnVend;

    @FXML
    private RadioButton rdBtnMasc;

    @FXML
    private TextField txtFldNomeFunc;

    @FXML
    private TextField txtFldSalFunc;

    private List<Funcionario> lstFuncionarios = new ArrayList<Funcionario>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btnCadastrarFunc.disableProperty().bind(txtFldNomeFunc.textProperty().isEmpty().or(txtFldSalFunc.textProperty().isEmpty()));

        Gerente gerComer = new Gerente("Elizelton", 10000, "M", -1000);
        Gerente gerVendas = new Gerente("Julio", 12000, "M", -5000);
        Gerente gerAdm = new Gerente("Fernanda", 750, "F", 800);
        Gerente gerTi = new Gerente(" ", 8000, "F", 4000);
        Administrativo auxAdmComp = new Administrativo("Barbara", 3000, "F");
        Administrativo auxAdmRh = new Administrativo("João", 2000, "M");
        Administrativo auxAdmVend = new Administrativo("Jorge", 2500, "M");
        Vendedor vendInter = new Vendedor("Natalia", 3000, "f", -10000);
        Vendedor vendAgro = new Vendedor("Rafael", 3000, "MF", 50000);
        Vendedor vendVeic = new Vendedor("Maria", -3000, "MF", 100000);

        lstFuncionarios.add(gerComer);
        lstFuncionarios.add(gerVendas);
        lstFuncionarios.add(gerAdm);
        lstFuncionarios.add(gerTi);
        lstFuncionarios.add(auxAdmComp);
        lstFuncionarios.add(auxAdmRh);
        lstFuncionarios.add(auxAdmVend);
        lstFuncionarios.add(vendInter);
        lstFuncionarios.add(vendAgro);
        lstFuncionarios.add(vendVeic);

        for (Funcionario func : lstFuncionarios) {
            System.out.println(func);
        }
    }

    @FXML
    private void btnCadastrarFuncClick(ActionEvent event) {
        System.out.println("Botao cadastrar");
    }
}
