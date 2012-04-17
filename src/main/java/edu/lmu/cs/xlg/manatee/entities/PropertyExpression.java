package edu.lmu.cs.xlg.manatee.entities;

import edu.lmu.cs.xlg.util.Log;

public class PropertyExpression extends Expression {

    private Expression object;
    private String index;

    public PropertyExpression(Expression base, String index) {
        this.object = base;
        this.index = index;
    }

    public Expression getBase() {
        return object;
    }

    public String getIndex() {
        return index;
    }

    @Override
    boolean isWritableLValue() {
        return object.type instanceof ObjectType && object.isWritableLValue();
    }

    @Override
    public void analyze(Log log, SymbolTable table, Subroutine owner, boolean inLoop) {
        object.analyze(log, table, owner, inLoop);
        //index.analyze(log, table, owner, inLoop);

        //was assertArrayOrString, FIXME later... object.assertObject("property", log);
        //index.assertString("property", log);
        //type = index.getType();
        //type = (object.type == Type.STRING) ? Type.CHARACTER
        //    : object.type instanceof ObjectType ? ObjectType.class.cast(object.type).getBaseType()
        //    : Type.ARBITRARY;

        // FIXME: everything above is broken, analyze definitely doesn't work :P Wanted it compiling for now
    }
}
