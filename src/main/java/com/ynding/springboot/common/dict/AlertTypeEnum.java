package com.ynding.springboot.common.dict;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dyn
 * 行为分析预警类型
 */
@SuppressWarnings("ALL")
@AllArgsConstructor
public enum AlertTypeEnum {

    BEHAVIOR_SAFETY_VIOLATION_ALERT("behavior_safety_violation_alert", "有限空间行为风险预警"),
    MISSING_PROTECTION_ALERT("missing_protection_alert", "劳保用品穿戴风险预警"),
    PROTECTION_ZONE_VIOLATION_ALERT("protection_zone_violation_alert", "周边风险行为预警"),
    ZONE_VIOLATION_ALERT("zone_violation_alert", "临边越界行为预警风险预警"),
    FALL_DOWN_VIOLATION_ALERT("fall_down_violation_alert", "人员摔倒行为预警"),
    SMOKE_VIOLATION_ALERT("smoke_violation_alert", "抽烟行为预警"),
    FIRE_ALERT("fire_alert", "火灾风险预警");
    @Getter
    private String alertType;
    @Getter
    private String alert;

    public final static Map<String,String> ALERT_TYPE_MAP = new HashMap<>();
    static {
        for(AlertTypeEnum typeEnum : AlertTypeEnum.values()){
            ALERT_TYPE_MAP.put(typeEnum.alertType,typeEnum.alert);
        }
    }
}
