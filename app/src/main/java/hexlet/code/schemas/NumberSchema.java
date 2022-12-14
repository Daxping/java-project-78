package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    private boolean status = true;
    private boolean positive = true;
    private Integer min;
    private Integer max;

    @Override
    public boolean isValid(Object number) {
        boolean result = true;
        if (number == null) {
            result = this.status;
        } else if (!(number instanceof Integer)) {
            result = false;
        } else if (this.min != null && this.max != null) {
            result = min <= ((Integer) number) & max >= ((Integer) number);
        } else if (((Integer) number) <= 0) {
            result = positive;
        }
        return result;
    }

    public NumberSchema required() {
        this.status = false;
        return this;
    }

    public NumberSchema range(Integer minimum, Integer maximum) {
        this.min = minimum;
        this.max = maximum;
        return this;
    }

    public NumberSchema positive() {
        this.positive = false;
        return this;
    }

}
