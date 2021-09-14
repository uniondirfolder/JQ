package hw.d18092021.json;

public final class Rules implements Rule {
    @Override
    public boolean isCorrectIncome(String jsonObject) {
        return false;
    }

    @Override
    public boolean isCorrectOutcome(String jsonObject) {
        return false;
    }

    @Override
    public boolean itsAcceptable(String jsonObject) {
        return false;
    }


    @Override
    public boolean isAccept(Object object) {
        if (object instanceof JsonLittleItem) {
            JsonLittleItem jli = (JsonLittleItem) object;
            if (!isFieldAccept(jli.getItem().getFieldName())) return false;

        } else if (object instanceof JsonBigItem) {
            JsonBigItem jbi = (JsonBigItem) object;
            if (!isFieldAccept(jbi.getItem().getFieldName())) return false;
        } else if (object instanceof JsonLittleItem) {
            JsonLittleItem jbi = (JsonLittleItem) object;
            if (!isFieldAccept(jbi.getItem().getFieldName())) return false;
        }
        return false;
    }

    private boolean isFieldAccept(String str) {
        for (int i = 1; i < str.length(); i++) {
            if (!Character.isAlphabetic(str.charAt(i))) return false;
        }
        return true;
    }
}
