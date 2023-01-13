package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class StringSchemaTest {
    private Validator v;
    private StringSchema schema;
    @BeforeEach
    public void beforeEach() {
        this.v = new Validator();
        this.schema = v.string();
    }

    @Test
    public void stringSchemaTest1() {
        boolean actual = schema
                .required()
                .isValid(null);
        assertFalse(actual);
    }

    @Test
    public void stringSchemaTest2() {
        boolean actual = v.string()
                .isValid(null);
        assertTrue(actual);
    }

    @Test
    public void stringSchemaTest3() {
        boolean actual = v.string()
                .isValid("");
        assertTrue(actual);
    }

    @Test
    public void stringSchemaTest4() {
        boolean actual = v.string()
                .required()
                .isValid("");
        assertFalse(actual);
    }

    @Test
    public void stringSchemaTest5() {
        final int min = 27;
        boolean actual = v.string()
                .required()
                .contains("London")
                .contains("is the")
                .minLength(min)
                .isValid("London is the capital of...");
        assertTrue(actual);
    }

    @Test
    public void stringSchemaTest6() {
        final int min = 28;
        boolean actual = v.string()
                .required()
                .contains("Paris")
                .contains("is the")
                .minLength(min)
                .isValid("London is the capital of...");
        assertFalse(actual);
    }

    @Test
    public void stringSchemaTest7() {
        final int min = 28;
        boolean actual = v.string()
                .required()
                .minLength(min)
                .isValid("London is the capital of...");
        assertFalse(actual);
    }
}
