package com.nvv.itstep.lection.l11_enum;

public enum ColorEnum {
    RED("красный","#FF0000"),
    YELLOW("желтый","#FFFF00"),
    GREEN("зеленый","#00FF00");

    public final String ru;
    public final String hex;

    ColorEnum(String ru,String hex) {
        this.ru = ru;
        this.hex = hex;
    }

//    public String getRu() {
//        return ru;
//    }
//
//    public String getHex() {
//        return hex;
//    }

//    public void setRu(String ru) {
//        this.ru = ru;
//    }
//
//    public void setHex(String hex) {
//        this.hex = hex;
//    }
}
