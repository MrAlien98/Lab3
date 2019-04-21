package application;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;

public class SampleController {

    @FXML private DatePicker initialDate;
    @FXML private DatePicker endDate;

    @FXML private CheckBox checkForex;
    @FXML private CheckBox checkStock;

    @FXML private Button butLoad;
    @FXML private Button cleanCanvas;
    
    @FXML private Canvas canvas;
    
    @FXML private GraphicsContext g;
    
    @FXML private ChoiceBox<String> choiceElement;

    public SampleController() {
    	
    }
    
    public void initialize() {
    	g=canvas.getGraphicsContext2D();
    	checkForex.setOnAction(e->{
    		System.out.println("Divisas");
    		checkers(1);
    	});
    	checkStock.setOnAction(e->{
    		checkers(-1);
    	});
    }
    
    public void checkers(int x) {
    	if(x>0) {
    		if(checkStock.isSelected()) {
    			checkStock.setSelected(false);
    			System.out.println(checkStock.isSelected());
    		}
    	}else {
    		if(checkForex.isSelected()) {
    			checkForex.setSelected(false);
    			System.out.println(checkForex.isSelected());
    		}
    	}
    }
    
}

