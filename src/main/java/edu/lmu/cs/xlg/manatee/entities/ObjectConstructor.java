package edu.lmu.cs.xlg.manatee.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.lmu.cs.xlg.util.Log;

/**
 * An object expression, such as dress {color: red, size: 10}, or box{}.
 */
public class ObjectConstructor extends IdentifierExpression {

    private String name;
    private List<Expression> expressions;
    private List<String> tokens;

    public ObjectConstructor(String name, List<Expression> expressions, List<String> tokens) {
        super(name);
        this.name = name;
        this.expressions = expressions;
        this.tokens = tokens;
    }

    public String getName() {
        return name;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    public List<String> getTokens() {
        return tokens;
    }

    @Override
    public void analyze(Log log, SymbolTable table, Subroutine owner, boolean inLoop) {

        // Analyze expressions and tokens
        for (Expression e: expressions) {
            e.analyze(log, table, owner, inLoop);
        }
        // Should tokens be analyzed too?
    }
}
