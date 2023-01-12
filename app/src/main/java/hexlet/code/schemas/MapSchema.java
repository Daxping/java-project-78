package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public final class MapSchema extends BaseSchema {
    private boolean status = true;
    private Integer sizeOfMap;
    private Map<String, BaseSchema> shapeSchema;
    @Override
    public boolean isValid(Object map) {
        boolean result = false;
        if (map == null) {
            result = this.status;
        } else if (!(map instanceof HashMap<?, ?>)) {
            result = false;
        } else if (sizeOfMap == null) {
            result = isShapeValid(map);
        } else {
            result = isShapeValid(map) && ((HashMap<?, ?>) map).size() == sizeOfMap;
        }
        return result;
    }
    public MapSchema required() {
        this.status = false;
        return this;
    }
    public MapSchema sizeof(int i) {
        this.sizeOfMap = i;
        return this;
    }
    public MapSchema shape(Map<String, BaseSchema> schemas) {
        this.shapeSchema = schemas;
        return this;
    }

    public boolean isShapeValid(Object map) {
        if (shapeSchema == null) {
            return true;
        } else {
            for (String key : shapeSchema.keySet()) {
                if (!shapeSchema
                        .get(key)
                        .isValid(((Map<?, ?>) map).get(key))) {
                    return false;
                }
            }
        }
        return true;
    }
}
