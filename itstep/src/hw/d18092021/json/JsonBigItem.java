package hw.d18092021.json;

public final class JsonBigItem extends JsonObjects{
    private Item item;
    private Object object;

    public Item getItem() {
        return item;
    }

    public Object getObject() {
        return object;
    }

    @Override
    protected void validateJsonRules(JsonValidateRules rules) {

    }
}
