package hw.d18092021.json;

public interface JsonObject {
    String toJson(Object obj);
    Object fromJson(String jsonObject);

}
