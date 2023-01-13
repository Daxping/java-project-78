package hexlet.code.schemas;

//import java.util.HashMap;
import java.util.Map;

public final class MapSchema extends BaseSchema {

    public MapSchema required() {
        addCheck("required", value -> value instanceof Map<?, ?>);
        return this;
    }
    public MapSchema sizeOf(int size) {
        addCheck("sizeOf", value -> ((Map<?, ?>) value).size() == size);
        return this;
    }
    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addCheck(
                "shape",
                value -> {
                    return schemas.entrySet().stream().allMatch(e -> {
                        Object v = ((Map) value).get(e.getKey());
                        return e.getValue().isValid(v);
                    });
                }
        );
        return this;
    }
}
