package hexlet.code.schemas;

import java.util.HashMap;

public final class MapSchema extends BaseSchema {
    private boolean status = true;
    private Integer sizeOfMap;
    @Override
    public boolean isValid(Object map) {
        if (map == null) {
            return this.status;
        } else if (!(map instanceof HashMap<?, ?>)) {
            return false;
        } else if (sizeOfMap != null) {
            return ((HashMap<?, ?>) map).size() == sizeOfMap;
        } else {
            return true;
        }
    }
    public MapSchema required() {
        this.status = false;
        return this;
    }

    public MapSchema sizeof(int i) {
        this.sizeOfMap = i;
        return this;
    }
}
