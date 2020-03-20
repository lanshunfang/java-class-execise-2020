package org.neu.java.course.exercise5_javafx_calculator.calculator.modules.components.calculator;

import javafx.fxml.FXML;

import javafx.event.Event;
import javafx.scene.control.*;

public class CalculatorController {

  public enum OperatorEnum {
    Add("+"),
    Subtract("-"),
    Multiply("*"),
    Divide("/");

    public final String enumLabel;

    OperatorEnum(String enumLabel) {
      this.enumLabel = enumLabel;
    }

    @Override
    public String toString() {
      return this.enumLabel;
    }

    public static OperatorEnum getEnumItemByValue(String value) {
      for ( OperatorEnum enumValue: OperatorEnum.values() ) {
        if (enumValue.enumLabel.equals(value)) {
          return enumValue;
        }
      }
      return null;
    }
  }

  @FXML
  public TextField operand1TextField;
  @FXML
  public TextField operand2TextField;
  @FXML
  public Label operatorLabel;
  @FXML
  public Label resultLabel;

  public void setOperator(String operator) {
    this.operatorLabel.setText(operator);
  }

  public CalculatorController() {
    this.onInit();
  }

  @FXML
  public void onOperatorAction(Event event) {
    String operator = ((Button) event.getSource()).getText();
    this.setOperator(operator);
    this.calculate();

  }

  private void calculate() {
    OperatorEnum operator = OperatorEnum.getEnumItemByValue(this.operatorLabel.getText());
    int operand1 = Integer.valueOf(this.operand1TextField.getText());
    int operand2 = Integer.valueOf(this.operand2TextField.getText());

    switch (operator) {
      case Add: {
        this.resultLabel.setText(String.valueOf(operand1 + operand2));
      }
      break;
      case Subtract: {
        this.resultLabel.setText(String.valueOf(operand1 - operand2));
      }
      break;
      case Multiply: {
        this.resultLabel.setText(String.valueOf(operand1 * operand2));
      }
      break;
      case Divide: {
        this.resultLabel.setText(String.valueOf(operand1 / operand2));
      }
      break;
    }
  }

  private void onInit() {
  }
}
