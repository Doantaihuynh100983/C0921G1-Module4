package vn.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CalcutatorImpl implements  ICalculator{
    double result;
    @Override
    public double calculaTion(double number1, double number2, String calculation) {

        switch(calculation) {
            case "Addition":
                result = number1 + number2;
                break;
            case "Subtraction":
                result = number1 - number2;
                break;
            case "Multipcation":
                result = number1 * number2;
                break;
            case "Division":
                result = number1 / number2;
                break;
        }
        return result;
    }
}
