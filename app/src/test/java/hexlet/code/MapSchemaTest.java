package hexlet.code;

import hexlet.code.schemas.BaseSchema;
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

    private final int a = 100;
    private final int b = -5;

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

    @Test
    public void mapSchemaTest7() {
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", a);
        boolean actual = schema
                .shape(schemas)
                .isValid(human1);
        assertTrue(actual);
    }

    @Test
    public void mapSchemaTest8() {
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        boolean actual = schema
                .shape(schemas)
                .isValid(human2);
        assertTrue(actual);
    }

    @Test
    public void mapSchemaTest9() {
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required().contains("ya"));
        schemas.put("age", v.number().positive());
        schema
                .shape(schemas);

        Map<String, Object> actual3 = new HashMap<>();
        actual3.put("name", "Maya");
        actual3.put("age", null);
        assertTrue(schema.isValid(actual3));

        Map<String, Object> actual4 = new HashMap<>();
        actual4.put("name", "");
        actual4.put("age", null);
        assertFalse(schema.isValid(actual4));
    }

    @Test
    public void mapSchemaTest10() {
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", b);
        boolean actual = schema
                .shape(schemas)
                .isValid(human4);
        assertFalse(actual);
    }
}
