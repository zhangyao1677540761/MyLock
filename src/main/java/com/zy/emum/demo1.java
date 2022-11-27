package com.zy.emum;

import lombok.Getter;

/**
 * @学习小结
 */
public enum demo1 {
    ONE(1, "春"), TWO(1, "夏"), THREE(1, "秋"), FOUR(1, "冬");

    @Getter
    private Integer retCode;
    @Getter
    private String retMessage;

    demo1(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }



    public static demo1 FindOne(int index){
        demo1[] Array= demo1.values();
        for (demo1 o :Array) {
            if (index == o.getRetCode()){
                return o;
            }

        }
        return null;
    }
}
class A{
    public static void main(String[] args) {
        System.out.println(demo1.FindOne(1).getRetMessage());
    }
}
