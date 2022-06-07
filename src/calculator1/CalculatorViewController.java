package calculator1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class CalculatorViewController implements Initializable {
    
    
    @FXML
    private TextField display;
    @FXML
    private Button memoryClearButton;
    @FXML
    private Button memoryRecallButton;
    @FXML
    private Button memoryStoreButton;
    @FXML
    private Button memoryAddButton;
    @FXML
    private Button memorySubractButton;
    @FXML
    private Button backspaceButton;
    @FXML
    private Button clearEntryButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button plusMinusBotton;
    @FXML
    private Button rootButton;
    @FXML
    private Button sevenButton;
    @FXML
    private Button eightButton;
    @FXML
    private Button nineButton;
    @FXML
    private Button divideButton;
    @FXML
    private Button percentageButton;
    @FXML
    private Button fourButton;
    @FXML
    private Button fiveButton;
    @FXML
    private Button sixButton;
    @FXML
    private Button multiplyButton;
    @FXML
    private Button inverseButton;
    @FXML
    private Button oneButton;
    @FXML
    private Button twoButton;
    @FXML
    private Button threeButton;
    @FXML
    private Button subtractButton;
    @FXML
    private Button equalButton;
    @FXML
    private Button zeroButton;
    @FXML
    private Button pointButton;
    @FXML
    private Button addButton;
    
    //Global Variables
    Float data = 0f;
    int operation = -1;
    int memoryOperation = -1;
    Float tempMemory = 0f;
    
    @FXML
    private void handleBottonAction(ActionEvent event) {
        if (event.getSource() == oneButton) {
            display.setText(display.getText() + "1");
        } else if (event.getSource() == twoButton) {
            display.setText(display.getText() + "2");
        } else if (event.getSource() == threeButton) {
            display.setText(display.getText() + "3");
        } else if (event.getSource() == fourButton) {
            display.setText(display.getText() + "4");
        } else if (event.getSource() == fiveButton) {
            display.setText(display.getText() + "5");
        } else if (event.getSource() == sixButton) {
            display.setText(display.getText() + "6");
        } else if (event.getSource() == sevenButton) {
            display.setText(display.getText() + "7");
        } else if (event.getSource() == eightButton) {
            display.setText(display.getText() + "8");
        } else if (event.getSource() == nineButton) {
            display.setText(display.getText() + "9");
        } else if (event.getSource() == zeroButton) {
            display.setText(display.getText() + "0");
        } else if (event.getSource() == pointButton) {
            display.setText(display.getText() + ".");
        } else if (event.getSource() == clearButton) {
            display.setText("0");   //Clear All Input
        } else if (event.getSource() == clearEntryButton) {
            display.setText("");    //Clear only last input number
        } else if (event.getSource() == backspaceButton) {
            display.setText(display.getText(0, display.getText().length()-1));  //Clear only last input digit
        } else if (event.getSource() == plusMinusBotton) {
            try{
                data = Float.parseFloat(display.getText());
                if(data>=0){
                    display.setText("-" + data);    //Make Positive to Negative Number 
                }else{
                    data = data * (-1);
                    display.setText("+" + data);    //Make Positive to Negative Number
                }
            } catch(Exception e){display.setText(e.getMessage());}
            
        } else if (event.getSource() == addButton) {
            data = Float.parseFloat(display.getText());
            operation = 1;      //Addition
            display.setText("");
        } else if (event.getSource() == subtractButton) {
            data = Float.parseFloat(display.getText());
            operation = 2;      //Substraction
            display.setText("");
        } else if (event.getSource() == multiplyButton) {
            data = Float.parseFloat(display.getText());
            operation = 3;      //Multiplication
            display.setText("");
        } else if (event.getSource() == divideButton) {
            data = Float.parseFloat(display.getText());
            operation = 4;      //Division
            display.setText("");
        } else if (event.getSource() == inverseButton) {
            data = Float.parseFloat(display.getText());
            operation = 5;      //Inverse
            display.setText("");
        } else if (event.getSource() == rootButton) {
            data = Float.parseFloat(display.getText());
            operation = 6;      //Square Root
            display.setText("");
        } else if (event.getSource() == percentageButton) {
            data = Float.parseFloat(display.getText());
            operation = 7;      //Percentage
            display.setText("");
        } else if (event.getSource() == equalButton) {
            Float secondOperand = Float.parseFloat(display.getText());
            //Float ans = 0f;
            
            switch (operation) {
                case 1:     //Addition
                    Float ans = data + secondOperand;
                    display.setText(String.valueOf(ans));break;
                case 2:     //Subtraction
                    ans = data - secondOperand;
                    display.setText(String.valueOf(ans));break;
                case 3:     //Multiplication
                    ans = data * secondOperand;
                    display.setText(String.valueOf(ans));break;
                case 4:     //Division
                    ans = 0f;
                    try {
                        ans = data / secondOperand;
                    }catch(Exception e){display.setText(e.getMessage());}
                    display.setText(String.valueOf(ans));break;
                case 5:     //Inverse                    
                    ans = 0f;
                    try {
                        ans = 1 / secondOperand;
                    }catch(Exception e){display.setText(e.getMessage());}
                    display.setText(String.valueOf(ans));break;
                case 6:     //Square root                    
                    ans = 0f;
                    try {
                        double number = secondOperand;
                        ans = (float) Math.sqrt(number);
                    }catch(Exception e){display.setText(e.getMessage());}
                    display.setText(String.valueOf(ans));break;
                case 7:     //Percentage                    
                    ans = 0f;
                    try {
                        float percentage  = secondOperand /100;
                        ans = (data * percentage);
                    }catch(Exception e){display.setText(e.getMessage());}
                    display.setText(String.valueOf(ans));break;
            }
//            try{
//                Serialize.serialize(Serialize.filePath, ans);
//            } catch(Exception e){
//                System.out.println(e.getMessage());
//            } 
        } else if (event.getSource() == memoryStoreButton) {
            data = Float.parseFloat(display.getText());
            tempMemory = data;      //Data store into memory
            display.setText(display.getText());
        } else if (event.getSource() == memoryAddButton) {
            data = Float.parseFloat(display.getText());
            tempMemory += data;     //Memory Stored Data Add with same data
            display.setText(display.getText());
        } else if (event.getSource() == memorySubractButton) {
            data = Float.parseFloat(display.getText());
            tempMemory -= data;     //Memory Stored Data Subtract with same data
            display.setText(display.getText());
        } else if (event.getSource() == memoryRecallButton) {
            display.setText(String.valueOf(tempMemory)); //Display data from memory
        } else if (event.getSource() == memoryClearButton) {
            tempMemory = 0f;        //Clear Memory
            display.setText(display.getText());
        }
    }
    
    @FXML
//    public void initialize(){
//        try{
//            System.out.println(Serialize.deserialize(Serialize.filePath));
//        } catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        
//    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }        
}
    

