package hw.d18092021.json;

public interface JsonObject<T> {
    String toJson(T obj);
    T fromJson(final String jsonObject, Class<T> clazz);
    boolean validate(final String jsonObject);
}
