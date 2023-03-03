package com.example.calculatorfxbymarco;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.security.Key;


public class CalculatorCode{
    @FXML
    private Label prevnum;
    @FXML
    private Label result;

    @FXML
    private Button clear;


    private double numb1=0;
    private double total=0;
    private String operator="";
    private boolean check=true;

    /*@FXML
    protected void on7Click(ActionEvent event) {
        if (check){
            result.setText("7");
            check = false;
        }else {
            prevnum.setText(prevnum.getText()+7);
        }
    }*/

    public void number(String number) {
        result.setText(result.getText()+number);
    }

    public void prevNumb(String number){
        prevnum.setText(prevnum.getText()+number);
    }

    public double create(double numb1, double numb2, String operator){
        switch (operator){
            case "+":
                return (numb1 + numb2);
            case "-":
                return (numb1 - numb2);
            case "*":
                return (numb1 * numb2);
            case  "/":
                if(numb2==0){
                    return 0.0;
                }
                return (numb1 / numb2);
            default:
                break;
        }
        return 0.0;
    }

    public void provOperator(String operator){
        prevnum.setText(prevnum.getText() + " " + operator + " ");
    }

    public void computerProcessing(ActionEvent event){
        if(check){
            result.setText("");
            prevnum.setText("");

            check = false;
        }

        Button button = (Button)event.getSource();
        String value = button.getText();
        number(value);
        prevNumb(value);

    }

    public void operatorProcess(ActionEvent event){
        Button button = (Button)event.getSource();
        String value = button.getText();
        if(!value.equals("=")){
            if(!operator.isEmpty()){
                return;
            }
            operator = value;
            provOperator(operator);
            numb1 = Double.parseDouble(result.getText());
            result.setText("");
        } else {
            if (operator.isEmpty()){
                return;
            }
            double numb2 = Double.parseDouble(result.getText());
            total = create(numb1, numb2, operator);
            result.setText(String.valueOf(total));
            operator = "";
            check = true;
        }
    }

    public void systemClear(ActionEvent event){
        if(event.getSource() == clear){
            result.setText("");
            prevnum.setText("");

        }
    }

}

