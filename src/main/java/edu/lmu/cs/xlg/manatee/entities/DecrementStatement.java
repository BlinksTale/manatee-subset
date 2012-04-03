package edu.lmu.cs.xlg.manatee.entities;

import edu.lmu.cs.xlg.util.Log;

/**
 * An increment statement.
 */
public class DecrementStatement extends Statement {

    private Expression target;
    private Expression delta;

    public DecrementStatement(Expression target, Expression delta) {
        this.target = target;
        this.delta = delta;
    }

    public Expression getTarget() {
        return target;
    }

    public Expression getDelta() {
        return delta;
    }

    @Override
    public void analyze(Log log, SymbolTable table, Subroutine owner, boolean inLoop) {
        target.analyze(log, table, owner, inLoop);
        delta.analyze(log, table, owner, inLoop);
        if (!target.isWritableLValue()) {
            log.error("non.writable.in.decrement.statement");
        }
    }
}
