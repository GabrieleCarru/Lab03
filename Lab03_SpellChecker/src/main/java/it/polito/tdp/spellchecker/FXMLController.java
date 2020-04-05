/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Dictionary dizionario;
	private List<String> inputTextList;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxLingua"
    private ComboBox<?> boxLingua; // Value injected by FXMLLoader

    @FXML // fx:id="txtDaCorreggere"
    private TextArea txtDaCorreggere; // Value injected by FXMLLoader

    @FXML // fx:id="SpellCheckBtn"
    private Button SpellCheckBtn; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorretto"
    private TextArea txtCorretto; // Value injected by FXMLLoader

    @FXML // fx:id="lblErrori"
    private Label lblErrori; // Value injected by FXMLLoader

    @FXML // fx:id="clearTxtBtn"
    private Button clearTxtBtn; // Value injected by FXMLLoader

    @FXML // fx:id="lblStato"
    private Label lblStato; // Value injected by FXMLLoader

    @FXML
    void doActivation(ActionEvent event) {
    	
    	if(boxLingua.getValue() != null) {
    		txtDaCorreggere.setDisable(false);
    		txtCorretto.setDisable(false);
    		SpellCheckBtn.setDisable(false);
    		clearTxtBtn.setDisable(false);
    		txtDaCorreggere.clear();
    		txtCorretto.clear();
    	} else {
    		txtDaCorreggere.setDisable(true);
    		txtCorretto.setDisable(true);
    		SpellCheckBtn.setDisable(true);
    		clearTxtBtn.setDisable(true);
    		txtDaCorreggere.setText("Select language!");
    	}

    }

    @FXML
    void doClearText(ActionEvent event) {
    	txtDaCorreggere.clear();
		txtCorretto.clear();
		lblErrori.setText("Number of Errors:");
		lblStato.setText("Spell Check Status:");

    }

    @FXML
    void doSpellScheck(ActionEvent event) {
    	txtCorretto.clear();
    	inputTextList = new LinkedList<String>();
    	
    	if(boxLingua.getValue() == null) {
			txtDaCorreggere.setText("Seleziona una lingua!");
			return;
		}
    	
    	if(!dizionario.loadDictionary(boxLingua.getValue())) {
    		// implementare
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxLingua != null : "fx:id=\"boxLingua\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtDaCorreggere != null : "fx:id=\"txtDaCorreggere\" was not injected: check your FXML file 'Scene.fxml'.";
        assert SpellCheckBtn != null : "fx:id=\"SpellCheckBtn\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretto != null : "fx:id=\"txtCorretto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblErrori != null : "fx:id=\"lblErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert clearTxtBtn != null : "fx:id=\"clearTxtBtn\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblStato != null : "fx:id=\"lblStato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setDictionary(Dictionary model) {
    	
    	txtDaCorreggere.setDisable(true);
    	txtDaCorreggere.setText("Select language.");
    	
    	txtCorretto.setDisable(true);
    	boxLingua.getItems().addAll("English", "Italian");
    	
    	SpellCheckBtn.setDisable(true);
    	clearTxtBtn.setDisable(true);
    	
    }
}