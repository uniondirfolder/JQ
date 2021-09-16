package hw.d18092021.json;


public final class JsonItem implements JsonParse {
    private String fieldName;
    private String value;
    private Character character;
    String[] array;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Character getCharacter() {
        return character;
    }

    public String[] getArray() {
        return array;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public int getDimension() {
        if (array != null) {
            return array.length;
        }
        return 0;
    }

    public JsonItem(String fieldName, String value) {
        this.fieldName = fieldName;
        this.value = value;
    }

    public JsonItem(final JsonCursor jsonCursor) throws ItemException {
        character = jsonCursor.getChar(jsonCursor.getIndex());
        if (character == ':') {
            int z = jsonCursor.getIndex();
            jsonCursor.decrement();
            jsonCursor.decrement();
            if (jsonCursor.backToPosition('"')) {
                jsonCursor.increment();
                char iCh1 = jsonCursor.getChar(jsonCursor.getIndex());
                StringBuilder sb1 = new StringBuilder();
                while (jsonCursor.getCursor() && iCh1 != '"') {
                    sb1.append(iCh1);
                    jsonCursor.increment();
                    iCh1 = jsonCursor.getChar(jsonCursor.getIndex());
                }
                fieldName = sb1.toString();

                StringBuilder sb2;
                jsonCursor.setIndex(z);
                jsonCursor.increment();
                char iCh2 = jsonCursor.getChar(jsonCursor.getIndex());
                if (iCh2 == '"') {
                    sb2 = new StringBuilder();
                    jsonCursor.increment();
                    iCh2 = jsonCursor.getChar(jsonCursor.getIndex());
                    while (jsonCursor.getCursor() && iCh2 != '"') {
                        sb2.append(iCh2);
                        jsonCursor.increment();
                        iCh2 = jsonCursor.getChar(jsonCursor.getIndex());

                    }
                    value = sb2.toString();

                } else if (Character.isDigit(iCh2) || Character.isAlphabetic(iCh2)) {
                    sb2 = new StringBuilder();
                    while (jsonCursor.getCursor() && iCh2 != '}' && iCh2 != ',') {
                        sb2.append(iCh2);
                        jsonCursor.increment();
                        iCh2 = jsonCursor.getChar(jsonCursor.getIndex());
                    }
                    value = sb2.toString();
                } else if (iCh2 == '{' || iCh2 == '[') {
                    int i = jsonCursor.getIndex();
                    i++;
                    if (iCh2 == '[' && jsonCursor.getChar(i)!='{') {
                        value = "array";
                        try {
                            array = jsonCursor.getArray(jsonCursor.getIndex());
                        } catch (Exception e) {
                            jsonCursor.setError(true);
                        }
                    } else {
                        value = "object";
                    }
                }
            }
        }
        jsonCursor.increment();
    }
}

