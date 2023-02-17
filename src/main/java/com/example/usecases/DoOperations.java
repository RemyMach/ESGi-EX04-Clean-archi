package com.example.usecases;

import com.example.cli.Calculus;

import java.util.ArrayList;
import java.util.List;

public class DoOperations {

    public List<Integer> handle(List<Integer> numbers, Calculus calculus) {
        List<Integer> historic = new ArrayList<>();
        Operation operation;
        for (Integer number : numbers) {
            historic.add(number);
            if (historic.size() > 1) {
                switch (calculus) {
                    case plus:
                        operation = new AddOperation();
                        break;
                    case minus:
                        operation = new SubstractOperation();
                        break;
                    case multiply:
                        operation = new MultiplyOperation();
                        break;
                    default:
                        throw new RuntimeException("Invalid operator");
                }
                historic.add(
                    operation.execute(
                            historic.get(historic.size() - 2),
                            historic.get(historic.size() - 1)
                    )
                );
            }
        }

        return historic;
    }
}
