package expresso;

/**
 * Constant is an immutable type implementing expression representing a constant.
 * 
 * Constant supports the following methods in addition to those of Expression
 * getValue()
 */
public class Constant implements Expression {

    private final double value;

    /*
     * Abstraction Function:
     * Value represents the constant value
     * 
     * Rep Invariant: 
     * value is a nonnegative double.
     * 
     * Safety From Rep Exposure:
     * name is immutable and final, 
     * so there is no risk of rep exposure.
     */

    /**
     * Creates a constant with given value
     * 
     * @param value value of constant
     */
    public Constant(double value) {
        this.value = value;
        checkRep();
    }

    /**
     * Returns value of the constant
     * 
     * @return value of the constant
     */
    public double getValue() {
        return value;
    }

    @Override
    public Expression expand() {
        return this;
    }

    @Override
    public ExpressionType getType() {
        return ExpressionType.CONSTANT;
    }
    
    @Override
    public Expression getLeft() {
        return this;
    }

    @Override
    public Expression getRight() {
        return this;
    }
    
    /**
     * We ensure structural equality in Expression (meaning order is considered)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Constant) {
            Constant expression = (Constant) obj;
            return expression.getValue() == value;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Double.toString(value).hashCode();
    }

    private void checkRep() {
        assert value >= 0;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
