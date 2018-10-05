package app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.snmp4j.smi.OID;

public class FXMLController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TextField txtFldOid;

    @FXML
    private TextField txtFldIp;

    @FXML
    private void btnSairClick(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void btnBuscarClick(ActionEvent event) {
        SNMPManager client = new SNMPManager(String.format("udp:%s/161", txtFldIp.getText()));
        try {
            client.start();
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
         * 41 OID - .1.3.6.1.2.1.1.1.0 => SysDec 42 OID - .1.3.6.1.2.1.1.5.0 =>
         * SysName 43 => MIB explorer will be usefull here, as discussed in
         * previous article 44
         */
        String sysDescr = null;
        try {
            sysDescr = client.getAsString(new OID(txtFldOid.getText()));
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        label.setText(sysDescr);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /**
         * 35 Port 161 is used for Read and Other operations 36 Port 162 is used
         * for the trap generation 37
         */

    }
}
