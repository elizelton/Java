package view;

import com.sun.javafx.scene.control.skin.ContextMenuContent;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;
import javafx.scene.layout.StackPane;
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
    private StackPane pnJogos;

    @FXML
    private MenuItem mnJogos;

    @FXML
    private Label lblTimeSelecionado;

    @FXML
    private TableView tbVwTimes;

    @FXML
    private MenuItem mnCtxJogos;

    @FXML
    private TableView tbVwJogos;

    @FXML
    private void tbVwTimesClick(Event event) {

        MouseEvent me = null;
        if (event.getEventType() == MOUSE_CLICKED) {
            me = (MouseEvent) event;
            if (me.getClickCount() == 2) {
                getJogosTimeSelecionado();

            }
        }
    }

    @FXML
    private void mnCtxMostrarJogoTimeSelecionado(ActionEvent event) {
        getJogosTimeSelecionado();
    }

    @FXML
    private void mnExibirTimeSelecionado(ActionEvent event) {
        getJogosTimeSelecionado();
    }

    @FXML
    private void btnFecharTimeSelecionado(ActionEvent event) {
        pnJogos.setVisible(false);
    }

    private void getJogosTimeSelecionado() {
        Time timesel = (Time) tbVwTimes.getSelectionModel().getSelectedItem();
        if (timesel != null) {
            pnJogos.setVisible(true);
            lblTimeSelecionado.setText(String.format("Time: %s", timesel.getNome()));
            tbVwJogos.setItems(FXCollections.observableList(timesel.getJogos()));
            System.out.println(timesel);
            System.out.println(timesel.getJogos());
        }
    }

    @FXML
    private void mnFecharClick(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void btnAbrirClick(ActionEvent event) {
        final Stage stage = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Escolha o seu arquivo Txt");

//        Diretorio inicial Linux
//        fileChooser.setInitialDirectory(new File("/home/elizelton/Dados"));
//        Diretorio inicial Windows
        fileChooser.setInitialDirectory(new File("/home/elizelton/Dados"));

        dados = new Dados(String.valueOf(fileChooser.showOpenDialog(stage)));
        // Cria o objeto Dados na memória passando por parâmetro o nome.

        lstPrinc = dados.ler();
        mnJogos.setDisable(false);
        mnCtxJogos.setDisable(false);
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
        pnJogos.setVisible(false);

    }
}
