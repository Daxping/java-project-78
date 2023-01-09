package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {
    private Validator v;
    private StringSchema schema;
    @BeforeEach
    public void beforeEach() {
        v = new Validator();
        schema = v.string();
    }

    @Test
    public void stringSchemaTest1() {
        boolean actual = v.string()
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
        boolean actual = v.string()
                .required()
                .contains("London")
                .contains("is the")
                .minLength(27)
                .isValid("London is the capital of...");
        assertTrue(actual);
    }

    @Test
    public void stringSchemaTest6() {
        boolean actual = v.string()
                .required()
                .contains("Paris")
                .contains("is the")
                .minLength(27)
                .isValid("London is the capital of...");
        assertFalse(actual);
    }

    @Test
    public void stringSchemaTest7() {
        boolean actual = v.string()
                .required()
                .minLength(28)
                .isValid("London is the capital of...");
        assertFalse(actual);
    }
}
