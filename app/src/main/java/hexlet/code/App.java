package hexlet.code;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class App {
    public static void main(String[] args) {
        Validator v = new Validator();
        System.out.println("=====StringSchema=====");
        StringSchema schema1 = v.string();
        System.out.println(schema1.isValid("")); // true
        schema1.required();
        System.out.println(schema1.contains("whatthe").isValid("what does the fox say")); // false
        System.out.println("=====NumberSchema=====");
        NumberSchema schema2 = v.number();
        System.out.println(schema2.isValid(null)); // true
        schema2.required();
        System.out.println(schema2.isValid(0)); // false
        System.out.println("=====MapSchema=====");
        MapSchema schema3 = v.map();
        System.out.println(schema3.isValid(null)); // true
        schema3.required();
        System.out.println(schema3.isValid(null)); // false
    }
}
