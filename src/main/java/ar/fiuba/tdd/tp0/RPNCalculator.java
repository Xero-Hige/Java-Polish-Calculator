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
    private Stack<Integer> operationStack;

    private RPNCalculator() {
        operations = new Hashtable<String, PolishOperation>();
    }

    private boolean isInt(String value) {                //FIXME
        return String.matches("-?\\d+(\\.\\d+)?");
    }

    public float eval(String expression) {
        operationStack = new Stack<Integer>();

        String[] tokens = expression.split(" ");
        int index = 0;
        while (index < tokens.length) {
            String token = tokens[index];
            while (isInt(token)) {
                operationStack.push(Integer.parseInt(token));
                index++;
            }

            PolishOperation operation = operations[token];
            operation.solve(operationStack);
            index++;
        }
    }

}
