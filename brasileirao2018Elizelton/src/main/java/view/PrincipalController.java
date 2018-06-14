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
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Jogo;
import model.Time;
import utility.Dados;

public class PrincipalController implements Initializable {

    private List<Time> lstPrinc = new ArrayList<Time>();
    private List<Jogo> lstTemp = new ArrayList<Jogo>();

    Time time1;
    Time time2;
    Time timesel;

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
    private MenuItem mnItemVitCasa;

    @FXML
    private MenuItem mnItemDerCasa;

    @FXML
    private MenuItem mnItemVitVisitante;

    @FXML
    private MenuItem mnItemDerVisitante;

    @FXML
    private TableView tbVwJogos;

    @FXML
    private MenuBar mnBarPrincipal;

    @FXML
    private void tbVwTimesClick(Event event) {

        MouseEvent me = null;
        if (event.getEventType() == MOUSE_CLICKED) {
            me = (MouseEvent) event;
            if (me.getClickCount() == 2) {
                timesel = (Time) tbVwTimes.getSelectionModel().getSelectedItem();
                getJogosTimeSelecionado();
            }
        }
    }

    @FXML
    private void mnCtxMostrarJogoTimeSelecionado(ActionEvent event) {
        timesel = (Time) tbVwTimes.getSelectionModel().getSelectedItem();
        getJogosTimeSelecionado();
    }

    @FXML
    private void mnExibirTimeSelecionado(ActionEvent event) {
        timesel = (Time) tbVwTimes.getSelectionModel().getSelectedItem();
        if (timesel != null) {
            getJogosTimeSelecionado();
        }
    }

    @FXML
    private void btnFecharTimeSelecionado(ActionEvent event) {
        pnJogos.setVisible(false);
        mnBarPrincipal.setDisable(false);
    }

    private void getJogosTimeSelecionado() {
        if (timesel != null) {
            pnJogos.setVisible(true);
            lblTimeSelecionado.setText(String.format("Time: %s", timesel.getNome()));
            tbVwJogos.setItems(FXCollections.observableList(timesel.getJogos()));
        }
        mnBarPrincipal.setDisable(true);
    }

    @FXML
    private void mnGetDerrotasVisitanteClick(ActionEvent event) {
        lstTemp.addAll(timesel.getDerrotasVisitante());
        exibirListaFiltrada();
        mnItemDerVisitante.setDisable(true);
    }

    @FXML
    private void mnGetVitoriasVisitanteClick(ActionEvent event) {
        lstTemp.addAll(timesel.getVitoriasVisitante());
        exibirListaFiltrada();
        mnItemVitVisitante.setDisable(true);
    }

    @FXML
    private void mnGetDerrotasCasaClick(ActionEvent event) {
        lstTemp.addAll(timesel.getDerrotasCasa());
        exibirListaFiltrada();
        mnItemDerCasa.setDisable(true);
    }

    @FXML
    private void mnGetVitoriasCasaClick(ActionEvent event) {
        lstTemp.addAll(timesel.getVitoriasCasa());
        exibirListaFiltrada();
        mnItemVitCasa.setDisable(true);
    }

    @FXML
    private void mnAbrirClick(ActionEvent event) {
        btnAbrirClick(event);
    }

    @FXML
    private void mnFecharClick(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void btnRemoverFiltroClick(ActionEvent event) {
        tbVwJogos.setItems(FXCollections.observableList(timesel.getJogos()));
        lstTemp.clear();
        mnItemDerVisitante.setDisable(false);
        mnItemVitVisitante.setDisable(false);
        mnItemVitCasa.setDisable(false);
        mnItemDerCasa.setDisable(false);

    }

    @FXML
    private void btnAbrirClick(ActionEvent event) {
        final Stage stage = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Escolha o seu arquivo Txt");

//        Diretorio inicial Linux
        fileChooser.setInitialDirectory(new File("/home/elizelton/Dados"));
//        Diretorio inicial Windows
//        fileChooser.setInitialDirectory(new File("c:\\Dados\\"));

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

    private void exibirListaFiltrada() {
        tbVwJogos.setItems(FXCollections.observableList(lstTemp));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pnJogos.setVisible(false);
        mnJogos.setDisable(true);
        tbVwTimes.setRowFactory(TableView
                -> {
            TableRow< Time> row = new TableRow<>();
            row.itemProperty().addListener(
                    (observable, oldValue, newValue) -> {
                        if (newValue != null && (newValue.getClas().equals(1))) {
                            row.getStyleClass().add("itemDestaque");
                        } else {
                            row.getStyleClass().remove("itemDestaque");
                        }
                    });
            return row;

        }
        );
    }
}
