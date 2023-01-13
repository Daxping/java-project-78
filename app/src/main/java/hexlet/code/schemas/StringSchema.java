package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        addCheck("required", value -> value instanceof String && ((String) value).length() > 0);
        return this;
    }

    public StringSchema contains(String str) {
        addCheck("contains", value -> ((String) value).contains(str));

        return this;
    }

    public StringSchema minLength(Integer number) {
        addCheck("contains", value -> ((String) value).length() >= number);
        return this;
    }
}
