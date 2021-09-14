package hw.d18092021.json;

public final class JsonLittleItem extends JsonObjects {
    private Item item;

    public JsonLittleItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    @Override
    protected void validateJsonRules(JsonValidateRules rules) {

    }
}
