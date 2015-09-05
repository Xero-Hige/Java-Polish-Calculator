/**
 * Copyright 2015
 * Gaston Martinez gaston.martinez.90@gmail.com
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses
 */

package ar.fiuba.tdd.tp0;

import java.util.Hashtable;
import java.util.Stack;

public class RPNCalculator {

    private Hashtable<String, PolishOperation> operations;

    public RPNCalculator() {
        operations = new Hashtable<>();

        registerDefaultBinaryOperations();
        registerDefaultNaryOperations();
    }

    private void registerDefaultNaryOperations() {
        registerNaryOperator("++", (float a, float b) -> a + b);
        registerNaryOperator("--", (float a, float b) -> a - b);
        registerNaryOperator("//", (float a, float b) -> a / b);
        registerNaryOperator("**", (float a, float b) -> a * b);
    }

    private void registerDefaultBinaryOperations() {
        registerBinaryOperator("+", (float a, float b) -> a + b);
        registerBinaryOperator("-", (float a, float b) -> a - b);
        registerBinaryOperator("/", (float a, float b) -> a / b);
        registerBinaryOperator("*", (float a, float b) -> a * b);
        registerBinaryOperator("MOD", (float a, float b) -> a % b);
    }

    private boolean isInt(String value) {//FIXME
        return value.matches("-?\\d+(\\.\\d+)?");
    }

    public void registerBinaryOperator(String id, IBinaryOperation operation) {
        operations.put(id, new BinaryOperation(operation));
    }

    public void registerNaryOperator(String id, IBinaryOperation operation) {
        operations.put(id, new BinaryOperation(operation));
    }

    public float eval(String expression) {
        Stack<Float> operationStack = new Stack<>();
        PolishOperation defaultOperation = new DefaultOperation();


        String[] tokens = expression.split(" ");
        int index = 0;
        while (index < tokens.length) {
            String token = tokens[index];
            while (isInt(token)) {
                operationStack.push(Float.parseFloat(token));
                token = tokens[index++];
            }

            PolishOperation operation = operations.getOrDefault(token, defaultOperation);
            operation.solve(operationStack);
            index++;
        }

        return operationStack.pop();
    }

}
