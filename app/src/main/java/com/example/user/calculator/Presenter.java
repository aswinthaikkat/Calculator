package com.example.user.calculator;


/**
 * Created by Ryan on 14/11/2016.
 */

public class Presenter implements Contract.ForwardInputInteractionToPresenter,
        Contract.ForwardDisplayInteractionToPresenter, Calculator.CalculationResult {

    private Contract.PublishToView publishResult;
    private Calculator calc;

    //An object of DisplayFragment
    public Presenter (Contract.PublishToView publishResult){
        this.publishResult = publishResult;
        calc = new Calculator();
        calc.setCalculationResultListener(this);
    }

    @Override
    public void onDeleteShortClick() {
        calc.deleteCharacter();
    }

    @Override
    public void onDeleteLongClick() {
        calc.deleteExpression();
    }

    @Override
    public void onNumberClick(int number) {
        calc.appendNumber(Integer.toString(number));
    }

    @Override
    public void onDecimalClick() {
        calc.appendDecimal();
    }

    @Override
    public void onEvaluateClick() {
        calc.performEvaluation();
    }

    @Override
    public void onOperatorClick(String operator) {
        calc.appendOperator(operator);
    }

    @Override
    public void onExpressionChanged(String result, boolean successful) {
        if (successful) {
            publishResult.showResult(result);
        } else {
            publishResult.showToastMessage(result);
        }
    }
}