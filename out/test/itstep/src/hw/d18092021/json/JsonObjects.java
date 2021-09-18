package hw.d18092021.json;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

public class JsonObjects<T> implements JsonObject<T>, JsonParse {
    public static String objectToJson(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Field[] fls = obj.getClass().getDeclaredFields();
        for (int i = 0, j = fls.length - 1; i < fls.length; i++) {
            Field fl = fls[i];
            try {
                appendField(sb, fl, obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (i < j) {
                sb.append(",");
            }

        }
        sb.append("}");
        return sb.toString();
    }
    private static void appendField(final StringBuilder sb, Field field, Object obj) throws IllegalAccessException {
        field.setAccessible(true);

        sb.append("\"" + field.getName() + "\":");
        if (field.getType().isPrimitive()) {
            sb.append(field.get(obj));
        } else if (field.getType().getTypeName().equals(String.class.getTypeName())) {
            sb.append("\"" + field.get(obj) + "\"");
        } else if (field.getType().isArray()) {
            sb.append("[");
            Object[] arr = (Object[]) field.get(obj);
            boolean isPrim = arr[0].getClass().isPrimitive();
            boolean isStr = arr[0].getClass().getTypeName().equals(String.class.getName());
            for (int i = 0, j = arr.length - 1; i < arr.length; i++) {
                if (isPrim) {
                    sb.append((String) arr[i]);
                } else if (isStr) {
                    sb.append("\"" + arr[i] + "\"");
                }
                else {
                     JsonObjects.objectToJson(arr[i]);
                }
                if (i < j) {
                    sb.append(",");
                }
            }
            sb.append("]");
        }
        else{
            sb.append(JsonObjects.objectToJson(field.get(obj)));
        }
    }
    public static String printJson(Object obj){
        StringBuilder sb = new StringBuilder();
        String str = objectToJson(obj);
        char ch = ' ';
        boolean isOpenValue=false;

        for (int i = 0, j = 0; i < str.length(); i++) {
             ch = str.charAt(i);
             if(ch==':'){sb.append(ch); sb.append(' '); continue;}
             else if(ch=='{'){sb.append(ch); sb.append('\n');j+=2; sb.append(" ".repeat(j)); continue;}
             else if(ch=='}'){sb.append('\n');j-=2; sb.append(" ".repeat(j));sb.append(ch); continue;}
             else if(ch=='['){sb.append(ch); sb.append('\n');j+=2; sb.append(" ".repeat(j)); continue;}
             else if(ch==']'){sb.append('\n');j-=2; sb.append(" ".repeat(j));sb.append(ch);  continue;}
             else if(ch==',' && !isOpenValue){sb.append(ch); sb.append('\n'); sb.append(" ".repeat(j)); continue;}
             else if(ch=='"'){isOpenValue=!isOpenValue; sb.append(ch);continue;}
             else {sb.append(ch);}
        }
        return sb.toString();
    }

    @Override
    public String toJson(T obj) {
        try {
            String str = (String) obj.getClass().getMethod("toJson").invoke(obj);
            return str;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T fromJson(final String jsonObject, Class<T> clazz) {

        Class cl = clazz.getClass();
//        if (cl.getAnnotationsByType(JsonConstructor.class) == null) {
//            return null;
//        }

        JsonCursor csr = new JsonCursor(jsonObject);
        try {
            if (validate(jsonObject)) {
                JsonItem jsonItem;
                csr.getList().add(new JsonItem(cl.getTypeName(), "object"));
                while (csr.getCursor()) {
                    if (csr.goToPosition(':')) {
                        jsonItem = new JsonItem(csr);
                        csr.getList().add(jsonItem);
                    }
                }
                if (!csr.isError()) {

                    Constructor constructor = clazz.getDeclaredConstructor(JsonCursor.class);
                    constructor.setAccessible(true);
                    csr.setIndex(0);
                    JsonItem ji = csr.getWithUnclouded();
                    if (ji != null && ji.getValue().equals("object")) {
                        return (T) constructor.newInstance(csr);

                    }
                }
            }

        } catch (ItemException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            return null;
        }
        return null;
    }

    @Override
    public boolean validate(String jsonObject) {
        int i1 = 0;
        int i2 = 0;
        char ch1 = ' ';
        char ch2 = ' ';
        char ch3 = ' ';
        for (int i = 0; i < jsonObject.length(); ) {
            try {
                ch1 = jsonObject.charAt(i);
                if (ch1 == '{') {
                    i1++;
                    ch2 = jsonObject.charAt(i + 1);
                    if (ch2 != '"')
                        throw new ItemException("error");
                } else if (ch1 == '}') {
                    i1--;
                    ch2 = jsonObject.charAt(i - 1);
                    if (ch2 != '"' && !Character.isAlphabetic(ch2) && !Character.isDigit(ch2) && ch2 != '}' && ch2 != ']')
                        throw new ItemException("error");
                } else if (ch1 == ',') {
                    ch2 = jsonObject.charAt(i - 1);
                    if (ch2 != '"' && ch2 != '}' && !Character.isAlphabetic(ch2) && !Character.isDigit(ch2))
                        throw new ItemException("error");
                } else if (ch1 == '[') {
                    i2++;
                    ch2 = jsonObject.charAt(i + 1);
                    if (ch2 != ']' && ch2 != '{' && ch2 != '"' && !Character.isAlphabetic(ch2) && !Character.isDigit(ch2))
                        throw new ItemException("error");
                } else if (ch1 == ']') {
                    i2--;
                    ch2 = jsonObject.charAt(i - 1);
                    if (ch2 != '[' && ch2 != '}' && ch2 != '"')
                        throw new ItemException("error");
                } else if (ch1 == ':') {
                    i2--;
                    ch2 = jsonObject.charAt(i - 1);
                    ch3 = jsonObject.charAt(i + 1);
                    if (ch2 != '"' && !Character.isAlphabetic(ch3) && !Character.isDigit(ch3) && ch3 != '[' && ch3 != '{')
                        throw new ItemException("error");
                }

                i++;
            } catch (Exception e) {
                return false;
            }
        }
        if (i1 != 0 && i2 != 0) return false;
        return true;
    }

}
