package view;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
        
//         Fazer Bind   
//        btnCadastrarFunc.
        
        Gerente gerComer = new Gerente("Elizelton", 10000, "Masculino", 1000);
        Gerente gerVendas = new Gerente("Elizelton", 12000, "Masculino", 5000);
        Gerente gerAdm = new Gerente("Elizelton", 8000, "Masculino", 3000);
        Gerente gerTi = new Gerente("Elizelton", 8000, "Masculino", 4000);
        Administrativo auxAdmComp = new Administrativo("João", 3000, "Masculino");
        Administrativo auxAdmRh = new Administrativo("João", 2000, "Masculino");
        Administrativo auxAdmVend = new Administrativo("João", 2500, "Masculino");
        Vendedor vendInter = new Vendedor("Maria", 3000, "Feminino", 10000);
        Vendedor vendAgro = new Vendedor("Maria", 3000, "Feminino", 50000);
        Vendedor vendVeic = new Vendedor("Maria", 3000, "Feminino", 100000);
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
    }
}
