package edu.lmu.cs.xlg.manatee.entities;

import java.util.List;

import edu.lmu.cs.xlg.util.Log;

public class ObjectType extends Type {

    // Class within ObjectType for its properties
    public static class Property extends Entity {

        public String name;

        private Type type;

        public Property(String name, String type) {
            this.name = name;
            this.type = new Type(type);
        }

        public Type getType() {
            return type;
        }

        @Override
        public void analyze(Log log, SymbolTable table, Subroutine owner, boolean inLoop) {
            // Commented out code because these seem like they should exist here, but would not work
            // due to needing Expressions rather than a String
            //name.analyze(log, table, owner, inLoop);
            //name.assertString("property", log);
            type.analyze(log, table, owner, inLoop);
        }
    }

    private List<Property> properties;

    public String name;

    /**
     * Constructs an object with a given name.
     */
    public ObjectType(String name, List<Property> properties) {
        super(name);
        this.name = name;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }
    public List<Property> getProperties() {
        return properties;
    }
}
