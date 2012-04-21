package edu.lmu.cs.xlg.manatee.entities;

import java.util.List;
import java.util.ArrayList;

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
            // name should also be checked, but not sure how to do that or if necessary
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

    @Override
    public void analyze(Log log, SymbolTable table, Subroutine owner, boolean inLoop) {
        // Check for duplicate properties, worked with the Tyler/Rich/Eric/Sam team on this
        List<String> uniqueProperties = new ArrayList<String>();
        for (Property p: properties) {
            if (uniqueProperties.contains(p.name)) {
                log.error("This property already exists in this ObjectType");
            } else {
                uniqueProperties.add(p.name);
            }
        }
    }
 
}
