package ar.fiuba.tdd.tp0;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RPNCalculatorTest {

    private static final double DELTA = 0.00001;
    private final RPNCalculator calculator = new RPNCalculator();

    @Test
    public void sum() {
        assertEquals(5 + 2, calculator.eval("5 2 +"), DELTA);
    }

    @Test
    public void subtract() {
        assertEquals(3 - 2, calculator.eval("3 2 -"), DELTA);
    }

    @Test
    public void multiplication() {
        assertEquals(3 * 6, calculator.eval("3 6 *"), DELTA);
    }

    @Test
    public void mod() {
        assertEquals(26 % 2, calculator.eval("26 2 MOD"), DELTA);
    }

    @Test
    public void division() {
        assertEquals(36 / 3, calculator.eval("36 3 /"), DELTA);
    }

    @Test
    public void subtractNegativeNumbers() {
        assertEquals(3 + 2, calculator.eval("3 -2 -"), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyExpression() {
        calculator.eval("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullExpression() {
        calculator.eval(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void incompleteExpression() {
        calculator.eval("5 +");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidOperator() {
        calculator.eval("5 3 ?");
    }

    @Test
    public void combineTwoOperators() {
        assertEquals((5 + 2) * 8, calculator.eval("5 2 + 8 *"), DELTA);
    }

    @Test
    public void combineOperatorsWithMemory() {
        assertEquals((1 + 2) * (3 + 4) * (5 + 6), calculator.eval("1 2 + 3 4 + 5 6 + * *"), DELTA);
    }

    @Test
    public void multiSum() {
        assertEquals(5 + 2 + 4 + 5, calculator.eval("5 2 4 5 ++"), DELTA);
    }

    @Test
    public void multiSumWithOneArgument() {
        assertEquals(5, calculator.eval("5 ++"), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiSumWithNoArgument() {
        calculator.eval("++");
    }

    @Test
    public void multiSubtract() {
        assertEquals(5 - 2 - 4 - 5, calculator.eval("5 2 4 5 --"), DELTA);
    }

    @Test
    public void multiMultiply() {
        assertEquals(5 * 2 * 4 * 5, calculator.eval("5 2 4 5 **"), DELTA);
    }

    @Test
    public void multiDivision() {
        assertEquals(5.0 / 2.0 / 4.0 / 5.0, calculator.eval("5 2 4 5 //"), DELTA);
    }

    @Test
    public void multiOperatorCombinedWithSingles() {
        assertEquals(5 * 3 + 2 + 4 + 5 + 3, calculator.eval("5 3 * 2 4 5 ++ 3 +"), DELTA);
    }

    @Test
    public void customBinaryOperator() {
        calculator.registerBinaryOperator("MAX", Math::max);
        assertEquals(Math.max(3 + 2, 2 * 2), calculator.eval("3 2 + 2 2 * MAX"), DELTA);
    }
}
