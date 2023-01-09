package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;

public final class StringSchema {
    private boolean status = true;
    private int minLength = 0;
    private List<String> listOfContains = new ArrayList<>();

    public boolean isValid(Object string) {

        if (string instanceof String) {
            String str = (String) string;
        }


        if (string == null) {
            return this.status;
        } else if (!(string instanceof String)) {
            return false;
        } else if (((String) string).length() < 1) {
            return this.status;
        } else if (((String) string).length() < this.minLength) {
            return false;
        } else {
            return listOfContains.size() == 0 || isContains(((String) string));
        }
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
