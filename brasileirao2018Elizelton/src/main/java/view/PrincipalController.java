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

public class PrincipalController implements Initializable {

    private List<Time> lstPrinc = new ArrayList< Time>();

    @FXML
    private TableView tbVwTimes;

    private Time time1;
    private Time time2;

    @FXML
    private void btnAbrirClick(ActionEvent event) {
        final Stage stage = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Escolha seu arquivo Txt");
        fileChooser.setInitialDirectory(new File("C:\\Dados"));
        fileChooser.setInitialFileName("C:\\Dados\\resultado.txt");
        FileChooser.ExtensionFilter txtExtensionFilter = new FileChooser.ExtensionFilter("Arquivo de Texto", "*.txt");
        fileChooser.setSelectedExtensionFilter(txtExtensionFilter);
        fileChooser.getExtensionFilters().add(txtExtensionFilter);
//        System.out.println(
//                String.valueOf(fileChooser.showOpenDialog(stage))
//        );
        time1 = new Time("Internacional", 12, 10, 5, 10, 0);
        time1.setClas((byte) 1);
        lstPrinc.add(time1);
        time2 = new Time("Gremio", 5, 10, 2, 1, 3);
        time2.setClas((byte) 2);
        lstPrinc.add(time2);
        tbVwTimes.setItems(FXCollections.observableList(lstPrinc));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
