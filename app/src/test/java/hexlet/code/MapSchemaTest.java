package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public final class MapSchemaTest {
    private Validator v;
    private MapSchema schema;

    @BeforeEach
    public void beforeEach() {
        this.v = new Validator();
        this.schema = v.map();
    }

    @Test
    public void mapSchemaTest1() {
        boolean actual = schema
                .isValid(null);
        assertTrue(actual);
    }

    @Test
    public void mapSchemaTest2() {
        boolean actual = schema
                .required()
                .isValid(null);
        assertFalse(actual);
    }

    @Test
    public void mapSchemaTest3() {
        boolean actual = schema
                .required()
                .isValid(new HashMap());
        assertTrue(actual);
    }

    @Test
    public void mapSchemaTest4() {
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        boolean actual = schema
                .required()
                .isValid(data);
        assertTrue(actual);
    }

    @Test
    public void mapSchemaTest5() {
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        boolean actual = schema
                .required()
                .sizeof(2)
                .isValid(data);
        assertFalse(actual);
    }

    @Test
    public void mapSchemaTest6() {
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        boolean actual = schema
                .required()
                .sizeof(2)
                .isValid(data);
        assertTrue(actual);
    }

}
