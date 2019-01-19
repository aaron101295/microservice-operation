import Application.Operation;

import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Column;
import javax.persistence.Table;

public class OperationTest {

    @Test
    public void table() {
        // setup
        Table t
                = ReflectTool.getClassAnnotation(Operation.class, Table.class);
        // assert
        Assert.assertEquals("operations", t.name());
    }


    @Test
    public void type() {
        // setup
        Column c
                = ReflectTool.getMethodAnnotation(
                Operation.class, "getType", Column.class);
        // assert
        Assert.assertEquals("type", c.name());
    }

    @Test
    public void ibanSource() {
        // setup
        Column c
                = ReflectTool.getMethodAnnotation(
                Operation.class, "getIbansource", Column.class);
        // assert
        Assert.assertEquals("ibansource", c.name());
    }

    @Test
    public void ibanDest() {
        // setup
        Column c
                = ReflectTool.getMethodAnnotation(
                Operation.class, "getIbandest", Column.class);
        // assert
        Assert.assertEquals("ibandest", c.name());
    }


    @Test
    public void montant() {
        // setup
        Column c
                = ReflectTool.getMethodAnnotation(
                Operation.class, "getMontant", Column.class);
        // assert
        Assert.assertEquals("montant", c.name());
    }

    @Test
    public void date() {
        // setup
        Column c
                = ReflectTool.getMethodAnnotation(
                Operation.class, "getDate", Column.class);
        // assert
        Assert.assertEquals("date", c.name());
    }
}