package br.edu.ifsuldeminas.mch.sd.rmi.server;

import br.edu.ifsuldeminas.mch.sd.rmi.remote.Operations;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Calculator implements Operations {

    private List<String> lastOperations = new ArrayList<String>();

    public Number sum(Number x, Number y) {
        Number result = x.doubleValue() + y.doubleValue();
        log(x, "+", y, result);
        return result;
    }

    public Number sub(Number x, Number y) {
        Number result = x.doubleValue() - y.doubleValue();
        log(x, "-", y, result);
        return result;
    }

    public Number mul(Number x, Number y) {
        Number result = x.doubleValue() * y.doubleValue();
        log(x, "*", y, result);
        return result;
    }

    public Number div(Number x, Number y) {
        Number result = Double.NaN;
        if (y.doubleValue() != 0) {
            result = x.doubleValue() / y.doubleValue();
        }
        log(x, "/", y, result);
        return result;
    }

    public Number sqrt(Number x) {
        Number result = Math.sqrt(x.doubleValue());
        log("sqrt", x, result);
        return result;
    }

    public Number cbrt(Number x) {
        Number result = Math.cbrt(x.doubleValue());
        log("cbrt", x, result);
        return result;
    }

    public Number pow2(Number x) {
        Number result = Math.pow(x.doubleValue(), 2);
        log(x, "^2", null, result);
        return result;
    }

    public Number pow3(Number x) {
        Number result = Math.pow(x.doubleValue(), 3);
        log(x, "^3", null, result);
        return result;
    }

    public Number pow4(Number x) {
        Number result = Math.pow(x.doubleValue(), 4);
        log(x, "^4", null, result);
        return result;
    }

    public Number percentage(Number x, Number y) {
        Number result = (x.doubleValue() * y.doubleValue()) / 100;
        log(x, "%", y, result);
        return result;
    }

    public Number mod(Number x, Number y) {
        Number result = x.doubleValue() % y.doubleValue();
        log(x, "mod", y, result);
        return result;
    }

    public Number factorial(Number x) {
        int num = x.intValue();
        if (num < 0) throw new IllegalArgumentException("Fatorial não pode ser numero negativo.");
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        log("factorial", x, result);
        return result;
    }
      public Number root4(Number x) {
        Number result = Math.pow(x.doubleValue(), 1.0 / 4.0);
        log("root4", x, result);
        return result;
    }

    public List<String> lastOperations(int howMany) {
        if (lastOperations.size() < howMany) {
            return lastOperations();
        }
        return new ArrayList<String>(lastOperations.subList(
                lastOperations.size() - howMany, lastOperations.size()));
    }

    public List<String> lastOperations() {
        return lastOperations;
    }

    private void log(Number operatorOne, String operation, Number operatorTwo,
            Number result) {

        String formattedOperation;
        if (operatorTwo != null) {
            formattedOperation = String.format("%-10s %s %-10s = %-10s",
                    operatorOne.toString(), operation, operatorTwo.toString(),
                    result.toString());
        } else {
            formattedOperation = String.format("%s%s = %s",
                    operatorOne.toString(), operation, result.toString());
        }
        lastOperations.add(formattedOperation);
        System.out.printf("%s at %s\n", formattedOperation, new Date());
    }

    private void log(String operation, Number operand, Number result) {
        String formattedOperation = String.format("%-10s(%s) = %-10s",
                operation, operand.toString(), result.toString());
        lastOperations.add(formattedOperation);
        System.out.printf("%s at %s\n", formattedOperation, new Date());
    }
}
