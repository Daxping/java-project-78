package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        addCheck("required", value -> value instanceof Integer);
        return this;
    }

    public NumberSchema range(Integer minimum, Integer maximum) {
        addCheck("range", value -> ((int) value >= minimum && (int) value <= maximum));
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", value -> value == null || value instanceof Integer && ((int) value) > 0);
        return this;
    }

}
