package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {

    private Map<String, Predicate> checks = new LinkedHashMap<>();
    protected final void addCheck(String name, Predicate validate) {
        checks.put(name, validate);
    }

    public final boolean isValid(Object value) {
        for (Predicate validate : checks.values()) {
            if (!validate.test(value)) {
                return false;
            }
        }
        return true;
    }


}
