package hw.d18092021.json;

public abstract class JsonObjects {
    private volatile static int count;
    protected boolean isAccepted;
    protected abstract void validateJsonRules(JsonValidateRules rules);
}
