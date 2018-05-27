package view;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import model.Produto;

public class PrincipalController implements Initializable {

    Produto prodSelectd;
    @FXML
    private ComboBox cmbBoxProdutos;
    @FXML
    private TextField txtFldNome;
    @FXML
    private TextField txtFldPreco;
    @FXML
    private TextField txtFldCor;
    @FXML
    private TextField txtFldUnidade;
    @FXML
    private TextField txtFldQtdd;
    @FXML
    private TextField txtFldTotal;
    //private final DecimalFormat nf = new DecimalFormat("R$#,##0.00");
    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    private final char separadorMoeda = new DecimalFormatSymbols(Locale.getDefault(Locale.Category.FORMAT)).getDecimalSeparator();

    @FXML
    private void btnFecharClick(Event event) {
        System.exit(0);
    }

    @FXML
    private void btnLimparClick(Event event) {
        cmbBoxProdutos.setValue(null);

    }

    private final List<Produto> produtos = new ArrayList<Produto>();

    public void atualizaTxtFldTotal() {
        try {
            txtFldTotal.setText(calculaTotal(Integer.parseInt(txtFldQtdd.getText()), prodSelectd.getPreco()));
        } catch (Exception e) {
        }
    }

    public String calculaTotal(int qtdd, double valor) {
        return nf.format((float) valor * qtdd);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        produtos.add(new Produto("ABA DO TANQUE TITAN 150 2014 MELC", 112.26, "VERMELHA", "UN"));
        produtos.add(new Produto("AMORTECEDOR XRE 300 (PRO LINK) TMAC  ", 339.10, "PRATA", "UN"));
        produtos.add(new Produto("MANETE FREIO DIANTEIRO LEAD 110 COMETA", 16.5, "CROMADO", "2 UN"));
        produtos.add(new Produto("TAMPA LATERAL CB 300 09/11 INJETADA", 85.05, "PRETA", "UN"));
        produtos.add(new Produto("PARALAMA TRASEIRO FAZER 250 05/2010 ORIGINAL", 138.38, "AZUL", "UN"));
        produtos.add(new Produto("PNEU DIANTEIRO 110/70-17 SPORT DEMON CB 300", 343.35, "PRETO", "UN"));
        produtos.add(new Produto("RABETA COMPLETA CBX 250 2001/05 MELC", 111.41, "BRANCA", "UN"));
        produtos.add(new Produto("RELACAO COMPLETA (COM RETENTOR) XT 660 (520X110)", 255, "PRETA", "UN"));
        cmbBoxProdutos.setItems(FXCollections.observableArrayList(produtos));
        cmbBoxProdutos.valueProperty().addListener(
                new ChangeListener<Produto>() {
            @Override
            public void changed(ObservableValue<? extends Produto> observable, Produto oldValue, Produto newValue) {
                try {
                    prodSelectd = newValue;
                    txtFldNome.setText(newValue.toString());
                    txtFldPreco.setText(nf.format(prodSelectd.getPreco()));
                    txtFldCor.setText(newValue.getCor());
                    txtFldUnidade.setText(newValue.getUnidade());
                    txtFldQtdd.setPromptText("INFORME A QUANTIDADE");
                    txtFldQtdd.setEditable(true);
                   // txtFldQtdd.setBackground(Background.EMPTY);
                    

                } catch (Exception e) {
                    prodSelectd = null;
                    txtFldNome.clear();
                    txtFldPreco.clear();
                    txtFldCor.clear();
                    txtFldUnidade.clear();
                    txtFldQtdd.setPromptText("SELECIONE UM PRODUTO");
                    txtFldQtdd.setEditable(false);
                    txtFldQtdd.clear();
                    txtFldTotal.clear();
                }
            }
        });
        txtFldQtdd.focusedProperty().addListener(
                (ObservableValue<? extends Boolean> Observable, Boolean oldValue, Boolean newValue) -> {
                    if (newValue) {
                        txtFldQtdd.textProperty().addListener(ListenerQtdd);
                    } else {
                        txtFldQtdd.textProperty().removeListener(ListenerQtdd);
                    }
                }
        );

    }
    private final ChangeListener<? super String> ListenerQtdd
            = (observable, oldValue, newValue) -> {
                atualizaTxtFldTotal();
                if (!newValue.matches("\\d*(\\" + separadorMoeda + "\\d*)?") && !newValue.isEmpty()) {
                    txtFldQtdd.setText(oldValue);
                } else {
                }
            };
}
