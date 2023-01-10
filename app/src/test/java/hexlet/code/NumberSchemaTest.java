package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public final class NumberSchemaTest {
    private Validator v;
    private NumberSchema schema;
    private final int a = 5;
    private final int b = 10;

    @BeforeEach
    public void beforeEach() {
        this.v = new Validator();
        this.schema = v.number();
    }

    @Test
    public void numberSchemaTest1() {
        boolean actual = schema
                .isValid(null);
        assertTrue(actual);
    }
    @Test
    public void numberSchemaTest2() {
        boolean actual = schema
                .positive()
                .isValid(null);
        assertTrue(actual);
    }
    @Test
    public void numberSchemaTest3() {
        boolean actual = schema
                .required()
                .positive()
                .isValid(null);
        assertFalse(actual);
    }
    @Test
    public void numberSchemaTest4() {
        boolean actual = schema
                .required()
                .positive()
                .isValid(b);
        assertTrue(actual);
    }
    @Test
    public void numberSchemaTest5() {
        boolean actual = schema
                .required()
                .positive()
                .isValid("5");
        assertFalse(actual);
    }
    @Test
    public void numberSchemaTest6() {
        boolean actual = schema
                .required()
                .positive()
                .isValid(-b);
        assertFalse(actual);
    }
    @Test
    public void numberSchemaTest7() {
        boolean actual = schema
                .required()
                .positive()
                .isValid(0);
        assertFalse(actual);
    }
    @Test
    public void numberSchemaTest8() {
        boolean actual = schema
                .required()
                .positive()
                .range(a, b)
                .isValid(a);
        assertTrue(actual);
    }
    @Test
    public void numberSchemaTest9() {
        boolean actual = schema
                .required()
                .positive()
                .range(a, b)
                .isValid(b);
        assertTrue(actual);
    }
    @Test
    public void numberSchemaTest10() {
        boolean actual = schema
                .required()
                .positive()
                .range(a, b)
                .isValid(a - 1);
        assertFalse(actual);
    }
    @Test
    public void numberSchemaTest11() {
        boolean actual = schema
                .required()
                .positive()
                .range(a, b)
                .isValid(b + 1);
        assertFalse(actual);
    }
}
