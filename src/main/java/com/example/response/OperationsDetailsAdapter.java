package com.example.response;

import com.example.cli.Calculus;

import java.util.ArrayList;
import java.util.List;

public class OperationsDetailsAdapter {

    public static String adaptToHistoryResponse(List<Integer> operationHistoric, Calculus calculusUsed) {
        List<String> historic = new ArrayList<>();
        for (int i = 0; i < operationHistoric.size(); i++) {
            if(i < 1) {
                historic.add(operationHistoric.get(i).toString());
            } else {
                String calculusDetail = "";
                calculusDetail += adaptCalculusToCalculusResponse(calculusUsed) + operationHistoric.get(i).toString();
                i+=1;
                calculusDetail += "(=" + operationHistoric.get(i).toString() + ")";
                historic.add(calculusDetail);
            }
        }

        return String.join("\n", historic);
    }

    private static String adaptCalculusToCalculusResponse(Calculus calculus) {
        switch (calculus) {
            case plus:
                return "+";
            case minus:
                return "-";
            case multiply:
                return "*";
            default:
                throw new RuntimeException("Invalid operator");
        }
    }
}
