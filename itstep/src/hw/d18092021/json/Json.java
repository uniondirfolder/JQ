package hw.d18092021.json;

import java.util.ArrayList;
import java.util.List;

public class Json extends JsonObjects {
    private final String name = "root";
    private String income = "";
    private List<Object> list;

    private final char leftCurlyBracket = '{';
    private final char rightCurlyBracket = '}';
    private final char colon = ':';
    private final char doubleQuotationMarks = '"';
    private final char comma = ',';
    private final char leftSquareBracket = '[';
    private final char rightSquareBracket = ']';

    private boolean isWaitLCB;
    private boolean isWaitRCB;
    private boolean isWaitColon;
    private boolean isWaitDQM;
    private boolean isWaitComma;
    private boolean isWaitLSB;
    private boolean isWaitRSB;

    StringBuilder leftSB;
    StringBuilder rightSB;

    public Json(Object object) {
        if (object instanceof String) {
            income = (String) object;
            list = new ArrayList<>();
            validateJsonRules(new Rules());
        }
    }

    @Override
    protected void validateJsonRules(JsonValidateRules rules) {
        int i = 0, j = income.length() - 1;
        if (income.charAt(i) == leftCurlyBracket && income.charAt(j) == rightCurlyBracket) {
            i++;
            j--;
            changeWaitAfter_LCB_RCB();
            for (; i < j; i++, j--) {
                if(checkWaitState(false,false,false,true,false,false,false)){

                }
            }
        }

    }
    private boolean checkWaitState(boolean LCB, boolean RCB, boolean colon, boolean DQM, boolean comma, boolean LSB, boolean RSB){
        return isWaitLCB == LCB && isWaitRCB == RCB && isWaitColon == colon && isWaitDQM == DQM && isWaitComma == comma && isWaitLSB == LSB && isWaitRSB == RSB;
    }
    private void changeWaitAfter_LCB_RCB(){
        isWaitLCB = false;
        isWaitRCB = false;
        isWaitColon = false;
        isWaitDQM = true;
        isWaitComma = false;
        isWaitLSB = false;
        isWaitRSB = false;
    }
}
