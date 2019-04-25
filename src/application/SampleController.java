package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;

public class SampleController {

    @FXML private DatePicker initialDate;
    @FXML private DatePicker endDate;

    @FXML private RadioButton rbForex;
    @FXML private RadioButton rbStock;

    @FXML private Button butLoad;
    @FXML private Button butCleanCanvas;
    
    @FXML private Canvas graphic;
    
    @FXML private GraphicsContext g;
    
    @FXML private ChoiceBox<String> choiceElement;

    ArrayList<String> colors=new ArrayList<>();
    
    public SampleController() {
    	colors.add("YELLOW");
    	colors.add("BROWN");
    	colors.add("GOLD");
    	colors.add("GREEN");
    	colors.add("BLUE");
    	colors.add("GRAY");
    	colors.add("BLACK");
    	colors.add("RED");
    }
    
    public void initialize() {
    	g=graphic.getGraphicsContext2D();
    	
    	rbForex.setOnAction(e-> checkers(1));
    	rbStock.setOnAction(e-> checkers(-1));
    	butCleanCanvas.setOnAction(e-> clean());
    	butLoad.setOnAction(e-> sendInfo());
    }
    
    public void clean() {
    	g.setFill(Color.WHITE);
    	g.fillRect(0, 0, graphic.getWidth(), graphic.getHeight());
    }
    
    public void sendInfo() {
    	String selected=choiceElement.getValue();
    	Main.getBVC().loadData(selected, initialDate.getValue(), endDate.getValue());
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
    
}

