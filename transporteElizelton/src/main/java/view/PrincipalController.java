package view;

import java.net.URL;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.Cilindro;
import model.Cone;
import model.FiguraGeo3d;
import model.Material;
import model.Paralelepipedo;

public class PrincipalController implements Initializable {

    private List<Material> lstMateriais = new ArrayList<>();
    private List<FiguraGeo3d> lstObj = new ArrayList<>();

    private final char separadorDecimal = new DecimalFormatSymbols(Locale.getDefault(Locale.Category.FORMAT)).getDecimalSeparator();

    private final NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());

    @FXML
    private Label lblSegundo;

    @FXML
    private VBox vbTerceiro;

    @FXML
    private TextField txtFldPrimeiro;

    @FXML
    private TextField txtFldSegundo;

    @FXML
    private TextField txtFldTerceiro;

    @FXML
    private TextField txtFldTotObj;

    @FXML
    private TextField txtFldTotPeso;

    @FXML
    private TextField txtFldTotVolume;

    @FXML
    private TextField txtFldTipoFigMaisPesado;

    @FXML
    private TextField txtFldTipoMatMaisPesado;

    @FXML
    private TextField txtFldPesoMaisPesado;

    @FXML
    private ComboBox cmbMateriais;

    @FXML
    private RadioButton rdBtnParalelepipedo;

    @FXML
    private RadioButton rdBtnCilindro;

    @FXML
    private RadioButton rdBtnCone;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnLimpar;

    @FXML
    private Label lblFeedBack;

    @FXML
    private CheckBox chkBoxObjfragil;

    @FXML
    private void rdBtnParalelepipedoSelect() {
        lblFeedBack.setText(" ");
        lblSegundo.setText("Largura");
        vbTerceiro.setVisible(true);
        btnAdicionar.disableProperty().bind(txtFldPrimeiro.textProperty().isEmpty()
                .or(txtFldSegundo.textProperty().isEmpty())
                .or(txtFldTerceiro.textProperty().isEmpty())
                .or(cmbMateriais.getSelectionModel().selectedItemProperty().isNull()));
        btnLimpar.disableProperty().bind(txtFldPrimeiro.textProperty().isEmpty()
                .and(txtFldSegundo.textProperty().isEmpty())
                .and(txtFldTerceiro.textProperty().isEmpty())
                .and(cmbMateriais.getSelectionModel().selectedItemProperty().isNull()));
    }

    @FXML
    private void rdBtnCilindroSelect() {
        lblFeedBack.setText(" ");
        lblSegundo.setText("Diâmetro");
        vbTerceiro.setVisible(false);
        btnAdicionar.disableProperty().bind(txtFldPrimeiro.textProperty().isEmpty()
                .or(txtFldSegundo.textProperty().isEmpty())
                .or(cmbMateriais.getSelectionModel().selectedItemProperty().isNull()));
    }

    @FXML
    private void rdBtnConeSelect() {
        lblFeedBack.setText(" ");
        lblSegundo.setText("Diâmetro");
        vbTerceiro.setVisible(false);
        btnAdicionar.disableProperty().bind(txtFldPrimeiro.textProperty().isEmpty()
                .or(txtFldSegundo.textProperty().isEmpty())
                .or(cmbMateriais.getSelectionModel().selectedItemProperty().isNull()));
    }

    @FXML
    private void btnLimparClick(Event event) {
        lblFeedBack.setText(" ");
        LimparCampos();
    }

    @FXML
    private void btnAdicionarClick(Event event) throws ParseException {

        double altura = nf.parse(txtFldPrimeiro.getText()).doubleValue();
        boolean fragil = chkBoxObjfragil.isSelected();
        Material mat = (Material) cmbMateriais.getSelectionModel().getSelectedItem();
        if (rdBtnParalelepipedo.isSelected()) {
            double largura = nf.parse(txtFldSegundo.getText()).doubleValue();
            double profundidade = nf.parse(txtFldTerceiro.getText()).doubleValue();
            Paralelepipedo p = new Paralelepipedo(altura, largura, profundidade, mat, fragil);
            lstObj.add(p);
        } else if (rdBtnCilindro.isSelected()) {
            double raio = nf.parse(txtFldSegundo.getText()).doubleValue();
            Cilindro c = new Cilindro(altura, raio, mat, fragil);
            lstObj.add(c);
        } else if (rdBtnCone.isSelected()) {
            double raio = nf.parse(txtFldSegundo.getText()).doubleValue();
            Cone co = new Cone(altura, raio, mat, fragil);
            lstObj.add(co);
        }
        lblFeedBack.setText("Objeto Adicionado com Sucesso!");

        LimparCampos();
        atualizaDadosNaTela();

        //Funcao da Prova
//        Cone c;
//        c = (Cone) getConeMaisLeve();
//        if (c != null) {
//            System.out.println(String.format("Cone = %s", c.getMaterial()));
//            System.out.println(String.format("Cone mais leve = %.2f", c.getPeso()));
//        } else {
//            System.out.println("Não há nenhum cone na lista.");
//        }
    }

    public void atualizaDadosNaTela() {
        FiguraGeo3d obj = lstObj.get(lstObj.size() - 1);

        System.out.println(obj);
        System.out.println(String.format("Material = %s", obj.getMaterial()));
        System.out.println(String.format("Volume = %f", obj.getVolume()));
        System.out.println(String.format("Area da base =  %f", obj.getAreaDaBase()));

        if (obj.isFragil()) {
            System.out.println("Este objeto é fragil.");
        } else {
            System.out.println("Este objeto não é fragil.");
        }

        if (obj.isBaseCircular()) {
            System.out.println("Este objeto possui base circular.");
        } else {
            System.out.println("Este objeto não possui base circular.");
        }

        System.out.println("======================================");

        txtFldTotObj.setText(String.format("%d", lstObj.size()));
        txtFldTotPeso.setText(nf.format(getPesoTotalObj()));
        txtFldTotVolume.setText(nf.format(getVolumeTotalObj()));
        txtFldTipoFigMaisPesado.setText(getObjtoMaisPesado().toString());
        txtFldTipoMatMaisPesado.setText(String.format("%s", getObjtoMaisPesado().getMaterial()));
        txtFldPesoMaisPesado.setText(nf.format(getObjtoMaisPesado().getPeso()));

    }

    public void LimparCampos() {
        txtFldPrimeiro.clear();
        txtFldSegundo.clear();
        txtFldTerceiro.clear();
        cmbMateriais.setValue(null);
    }

    public FiguraGeo3d getObjtoMaisPesado() {
        FiguraGeo3d maisPesado = null;
        for (FiguraGeo3d obj : lstObj) {
            if (maisPesado == null) {
                maisPesado = obj;
            } else if (maisPesado.getPeso() < obj.getPeso()) {
                maisPesado = obj;
            }
        }
        return maisPesado;
    }

    public double getPesoTotalObj() {
        double peso = 0;
        for (FiguraGeo3d obj : lstObj) {
            if (obj != null) {
                peso = peso + obj.getPeso();
            }
        }
        return peso;
    }

    public double getVolumeTotalObj() {
        double volume = 0;
        for (FiguraGeo3d obj : lstObj) {
            if (obj != null) {
                volume = volume + obj.getVolume();
            }
        }
        return volume;
    }

    public FiguraGeo3d getConeMaisLeve() {
        FiguraGeo3d objRetorno = null;
        for (FiguraGeo3d obj : lstObj) {
            if (obj instanceof Cone) {
                if (objRetorno == null) {
                    objRetorno = (Cone) obj;
                } else if (obj.getPeso() < objRetorno.getPeso()) {
                    objRetorno = (Cone) obj;
                }
            }
        }
        return objRetorno;
    }

    public FiguraGeo3d getObjMaisPesado() {
        FiguraGeo3d objRetorno = null;
        for (FiguraGeo3d obj : lstObj) {
            if (objRetorno == null) {
                objRetorno = obj;
            } else if (obj.getPeso() > objRetorno.getPeso()) {
                objRetorno = obj;
            }
        }
        return objRetorno;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        lstMateriais.add(new Material("Aço", 7.85));
        lstMateriais.add(new Material("Chumbo", 11.3));
        lstMateriais.add(new Material("Titânio", 4.55));
        lstMateriais.add(new Material("Cobre", 8.93));
        lstMateriais.add(new Material("Vidro", 2.5));
        lstMateriais.add(new Material("Vidro", 2.5));
        lstMateriais.add(new Material("Madeira", 1.55));
        lstMateriais.add(new Material("Alumínio", 2.7));
        cmbMateriais.setItems(FXCollections.observableList(lstMateriais));

        cmbMateriais.focusedProperty().addListener(
                (ObservableValue<? extends Boolean> Observable, Boolean oldValue, Boolean newValue) -> {
                    if (newValue) {
                        lblFeedBack.setText(" ");
                    }
                }
        );
        txtFldPrimeiro.focusedProperty().addListener(
                (ObservableValue<? extends Boolean> Observable, Boolean oldValue, Boolean newValue) -> {
                    if (newValue) {
                        txtFldPrimeiro.textProperty().addListener(ListenertxtFldPrimeiro);
                    } else {
                        txtFldPrimeiro.textProperty().removeListener(ListenertxtFldPrimeiro);
                    }
                }
        );
        txtFldSegundo.focusedProperty().addListener(
                (ObservableValue<? extends Boolean> Observable, Boolean oldValue, Boolean newValue) -> {
                    if (newValue) {
                        txtFldSegundo.textProperty().addListener(ListenertxtFldSegundo);
                    } else {
                        txtFldSegundo.textProperty().removeListener(ListenertxtFldSegundo);
                    }
                }
        );
        txtFldTerceiro.focusedProperty().addListener(
                (ObservableValue<? extends Boolean> Observable, Boolean oldValue, Boolean newValue) -> {
                    if (newValue) {
                        txtFldTerceiro.textProperty().addListener(ListenertxtFldTerceiro);
                    } else {
                        txtFldTerceiro.textProperty().removeListener(ListenertxtFldTerceiro);
                    }
                }
        );

        rdBtnParalelepipedoSelect();

    }
    private final ChangeListener<? super String> ListenertxtFldPrimeiro
            = (observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*(\\"
                        + separadorDecimal + "\\d*)?") && !newValue.isEmpty()) {
                    txtFldPrimeiro.setText(oldValue);
                } else {

                }
            };

    private final ChangeListener<? super String> ListenertxtFldSegundo
            = (observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*(\\"
                        + separadorDecimal + "\\d*)?") && !newValue.isEmpty()) {
                    txtFldSegundo.setText(oldValue);
                } else {

                }
            };

    private final ChangeListener<? super String> ListenertxtFldTerceiro
            = (observable, oldValue, newValue) -> {
                if (!newValue.matches("\\d*(\\"
                        + separadorDecimal + "\\d*)?") && !newValue.isEmpty()) {
                    txtFldTerceiro.setText(oldValue);
                } else {

                }
            };
}
