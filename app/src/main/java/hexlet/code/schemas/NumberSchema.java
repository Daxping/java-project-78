package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    private boolean reqStatus = false;
    public NumberSchema required() {
        this.reqStatus = true;
        addCheck("required", value -> value instanceof Integer);
        return this;
    }

    public NumberSchema range(Integer minimum, Integer maximum) {
        if (reqStatus) {
            addCheck("range", value -> ((int) value >= minimum && (int) value <= maximum));
        } else {
            addCheck("range", value -> value instanceof Integer &&  ((int) value >= minimum && (int) value <= maximum));
        }
        return this;
    }

    public NumberSchema positive() {
        if (!reqStatus) {
            addCheck("positive", value -> value == null || ((int) value) > 0);
        } else {
            addCheck("positive", value -> ((int) value) > 0);
        }
        return this;
    }

}
