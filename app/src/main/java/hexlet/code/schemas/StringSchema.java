package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;

public final class StringSchema extends BaseSchema {
    private boolean status = true;
    private int minLength = 0;
    private List<String> listOfContains = new ArrayList<>();

    @Override
    public boolean isValid(Object string) {
        boolean result;
        if (string == null || ((String) string).length() < 1) {
            result = this.status;
        } else if (!(string instanceof String)) {
            result = false;
        } else if (((String) string).length() < this.minLength) {
            result = false;
        } else {
            result = listOfContains.size() == 0 || isContains(((String) string));
        }
        return result;
    }

    public boolean isContains(String str) {
        for (String content : this.listOfContains) {
            if (!str.contains(content)) {
                return false;
            }
        }
        return true;
    }

    public StringSchema required() {
        this.status = false;
        return this;
    }

    public StringSchema contains(String str) {
        this.listOfContains.add(str);
        return this;
    }

    public StringSchema minLength(Integer number) {
        this.minLength = number;
        return this;
    }
}
