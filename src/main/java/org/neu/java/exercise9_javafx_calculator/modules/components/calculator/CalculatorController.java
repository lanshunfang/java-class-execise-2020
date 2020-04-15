package org.neu.java.exercise9_javafx_calculator.modules.components.calculator;

import javafx.fxml.FXML;

import javafx.event.Event;
import javafx.scene.control.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;

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
  @FXML
  public Label errMsg;

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
    float operand1 = Float.valueOf(this.operand1TextField.getText());
    float operand2 = Float.valueOf(this.operand2TextField.getText());

    this.errMsg.setText("");

    switch (operator) {
      case Add: {
        this.updateResult(operand1 + operand2);
      }
      break;
      case Subtract: {
        this.updateResult(operand1 - operand2);
      }
      break;
      case Multiply: {
        this.updateResult(operand1 * operand2);
      }
      break;
      case Divide: {
        if (!this.isIllegalDivide(operand2)) {
          this.updateResult(operand1 / operand2);
        } else {
          this.resultLabel.setText("0");
          this.errMsg.setText("Do not allow dividing by 0");
        }
      }
      break;
    }
  }

  private void updateResult(float result) {
    DecimalFormat format = new DecimalFormat("0.##"); // Choose the number of decimal places to work with in case they are different than zero and zero value will be removed
    format.setRoundingMode(RoundingMode.UP); // choose your Rounding Mode

    this.resultLabel.setText(format.format(result));
  }

  private boolean isIllegalDivide(float operand2) {
    return operand2 == 0;
  }

  private void onInit() {
  }
}
