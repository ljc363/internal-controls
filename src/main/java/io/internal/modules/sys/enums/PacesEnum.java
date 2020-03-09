package io.internal.modules.sys.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PacesEnum {
    NOT_STARTS(0,"未开始"),
    HAVE_IN_HAND(1,"进行中"),
    DELAY(2,"延期"),
    END(3,"完成");

    @EnumValue
    private int value;
    private String desc;

    PacesEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
