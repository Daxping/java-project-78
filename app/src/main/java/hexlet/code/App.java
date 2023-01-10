package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

import java.util.HashMap;
import java.util.Map;
//import hexlet.code.schemas.StringSchema;

public class App {
    public static void main(String[] args) {
        System.out.println("=====StringSchema=====");
        Validator v1 = new Validator();
        StringSchema schema1 = v1.string();
        final int a = 5;

        System.out.println(schema1.isValid("")); // true
        System.out.println(schema1.isValid(null)); // true
        schema1.required();
        System.out.println(schema1.isValid("what does the fox say")); // true
        System.out.println(schema1.isValid("hexlet")); // true
        System.out.println(schema1.isValid(null)); // false
        System.out.println(schema1.isValid(a)); // false
        System.out.println(schema1.isValid("")); // false
        System.out.println(schema1.contains("wh").isValid("what does the fox say")); // true
        System.out.println(schema1.contains("what").isValid("what does the fox say")); // true
        System.out.println(schema1.contains("whatthe").isValid("what does the fox say")); // false
        System.out.println(schema1.isValid("what does the fox say")); // false
        System.out.println("=======================");

        System.out.println("=====NumberSchema=====");
        Validator v2 = new Validator();
        NumberSchema schema2 = v2.number();
        final int x = 10;
        final int b = 11;
        final int c =  5;

        System.out.println(schema2.isValid(null)); // true
        System.out.println(schema2.positive().isValid(null)); // true
        schema2.required();
        System.out.println(schema2.isValid(null)); // false
        System.out.println(schema2.isValid(x)); // true
        System.out.println(schema2.isValid("5")); // false
        System.out.println(schema2.isValid(-x)); // false
        System.out.println(schema2.isValid(0)); // false
        schema2.range(c, x);
        System.out.println(schema2.isValid(c)); // true
        System.out.println(schema2.isValid(x)); // true
        System.out.println(schema2.isValid(c - 1)); // false
        System.out.println(schema2.isValid(b)); // false
        System.out.println("=======================");

        System.out.println("=====MapSchema=====");
        Validator v3 = new Validator();
        MapSchema schema3 = v3.map();

        System.out.println(schema3.isValid(null)); // true
        schema3.required();
        System.out.println(schema3.isValid(null)); // false
        System.out.println(schema3.isValid(new HashMap())); // true
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        System.out.println(schema3.isValid(data)); // true
        schema3.sizeof(2);
        System.out.println(schema3.isValid(data));  // false
        data.put("key2", "value2");
        System.out.println(schema3.isValid(data)); // true
        System.out.println("=======================");
    }
}
