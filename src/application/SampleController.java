package application;

import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import model.FinancialThing;

public class SampleController {

    @FXML private DatePicker initialDate;
    @FXML private DatePicker endDate;
    
    @FXML private RadioButton rbForex;
    @FXML private RadioButton rbStock;

    @FXML private RadioButton rbForex2;
    @FXML private RadioButton rbStock2;
    
    @FXML private Button butLoad;
    
    @FXML private Button butHighP;
    @FXML private Button butLowP;
    @FXML private Button butStarValue;
    @FXML private Button butHighestGrowth;
    @FXML private Button butThreeHighest;    
    
    @FXML private AreaChart<String, Number> chartArea;
    
    @FXML private TextField txtStarValue;
    
    @FXML private TextField txtType;
    @FXML private TextField txtDate;
    @FXML private TextField txtValue;
    
    
    @FXML private ChoiceBox<String> choiceElement;
    @FXML private ChoiceBox<String> choiceElement2;
    
    public SampleController() {

    }
    
    public void initialize() {    	
    	rbForex.setOnAction(e-> checkers(1));
    	rbStock.setOnAction(e-> checkers(-1));
    	
    	rbForex2.setOnAction(e-> checkers2(1));
    	rbStock2.setOnAction(e-> checkers2(-1));
    	
    	butLoad.setOnAction(e-> sendInfo());
    	
    	butHighP.setOnAction(e-> sendInfo(1));
        butLowP.setOnAction(e-> sendInfo(-1));
    }
    
    public void sendInfo() {
    	String selected=choiceElement.getValue();
    	Main.getBVC().loadData(selected, initialDate.getValue(), endDate.getValue());
    }
    
    public void sendInfo(int x) {
    	String selected=choiceElement.getValue();
    	FinancialThing result=Main.getBVC().find(x, selected, initialDate.getValue(), endDate.getValue());
    	int n=result.getType();
    	if(n==1) {
    		txtType.setText("Divisa");
    	}else if(n==2) {
    		txtType.setText("Accion");
    	}else {
    		txtType.setText("Bitcoin (Divisa)");
    	}
    	txtValue.setText("$ "+result.getValue());
    	DateTimeFormatter format=DateTimeFormatter.ofPattern("d/M/yyyy");
    	String date=result.getDate().format(format);
    	txtDate.setText(date);
    }
    
    public void checkers(int x) {
    	if(x>0) {
    		if(rbStock.isSelected()) {
    			rbStock.setSelected(false);
    			choiceElement.setItems(FXCollections.observableArrayList("BTCUSD", "XAUUSD", "USDJPY", "GBPCAD", "EURUSD"));
    		}
    	}else {
    		if(rbForex.isSelected()) {
    			rbForex.setSelected(false);
    			choiceElement.setItems(FXCollections.observableArrayList("US30", "WTI", "USSPX500"));
    		}
    	}
    }
    
    public void checkers2(int x) {
    	if(x>0) {
    		if(rbStock2.isSelected()) {
    			rbStock2.setSelected(false);
    			choiceElement2.setItems(FXCollections.observableArrayList("BTCUSD", "XAUUSD", "USDJPY", "GBPCAD", "EURUSD"));
    		}
    	}else {
    		if(rbForex2.isSelected()) {
    			rbForex2.setSelected(false);
    			choiceElement2.setItems(FXCollections.observableArrayList("US30", "WTI", "USSPX500"));
    		}
    	}
    }
    
}

