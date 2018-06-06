package view;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Time;
import utility.Dados;

public class PrincipalController implements Initializable {

    private List<Time> lstPrinc = new ArrayList<Time>();

    Time time1;
    Time time2;

    private Dados dados;
    
    @FXML
    private TableView tbVwTimes;

    @FXML
    private void btnAbrirClick(ActionEvent event) {
        final Stage stage = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Escolha o seu arquivo Txt");
        
//        Diretorio inicial Linux
        fileChooser.setInitialDirectory(new File("/home/elizelton/Dados"));
        
//        Diretorio inicial Windows
//        fileChooser.setInitialDirectory(new File("C:\\Dados));

        dados = new Dados(String.valueOf(fileChooser.showOpenDialog(stage)));
        // Cria o objeto Dados na memória passando por parâmetro o nome.
        
        lstPrinc = dados.ler();
        // Ler e interpretar o arquivo e devolver uma lista.
        
//        time1 = new Time("Inter", 2, 1, 1, 10, 5);
//        time1.setClas((byte) 1);
//        lstPrinc.add(time1);
//
//        time2 = new Time("Gremio", 3, 1, 2, 13, 7);
//        time2.setClas((byte) 2);
//        lstPrinc.add(time2);

        // Mostra os times no TableView.
        tbVwTimes.setItems(FXCollections.observableList(lstPrinc));
        
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "Text Files", "*.txt"
        );
        fileChooser.getExtensionFilters().add(extFilter);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}