package calculadora;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FXMLCalculadoraController {
    
    @FXML
    private TextField telaTextField;
    
    public void insertNumber(String number) {
        telaTextField.setText(telaTextField.getText() + number);
    }
    
    public void insertOperator(String operator) {
        telaTextField.setText(telaTextField.getText() + " " + operator + " ");
    }
    
    public void clearExpression() {
        telaTextField.setText("");
    }
    
    public void onMouseClick(MouseEvent mouseEvent) {
        Button button = (Button) mouseEvent.getSource();
        String btnTxt = button.getText();
        
        switch(btnTxt){
            case "1":
            case "2":
            case "3":
            case "4":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
                insertNumber(btnTxt);
                break;
            case "V":
                insertNumber("5");
                break;
            case "+":
            case "-":
                insertOperator(btnTxt);
                break;
            case "M":
                insertOperator("*");
                break;
            case "D":
                insertOperator("/");
                break;
            case "C":
                clearExpression();
                break;
            case "=":
                String txt = telaTextField.getText();
                int result = EvaluateString.evaluate(txt);
                telaTextField.setText(Integer.toString(result));
        }
    }
    
}
