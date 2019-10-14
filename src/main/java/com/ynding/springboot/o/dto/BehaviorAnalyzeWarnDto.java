package com.ynding.springboot.o.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
public class BehaviorAnalyzeWarnDto {

    private long sid;

    @JsonProperty(value = "org_id")
    private long orgId;

    @JsonProperty(value = "project_id")
    private long projectId;

    @JsonProperty(value = "device_name")
    private String deviceName;

    @JsonProperty(value = "warn_type")
    private String warnType;

    @JsonProperty(value = "warn_info")
    private String warnInfo;

    @JsonProperty(value = "position")
    private String position;

    @JsonProperty(value = "warn_time")
    private long warnTimel;

    private String warnTime;

    @JsonProperty(value = "device_no")
    private String deviceNo;

    @JsonProperty(value = "device_ip")
    private String deviceIp;

    @JsonProperty(value = "risk_score")
    private int riskScore;

    @JsonProperty(value = "images")
    private String images;

    @JsonProperty(value = "video_url")
    private String videoUrl;

    @JsonProperty(value = "related_events_id")
    private List<String> relatedEventsIds;

    private String relatedEventsId;

    @JsonProperty(value = "user_id")
    private long userId;

    public String getRelatedEventsId(){
        return relatedEventsIds.toString();
    }

    public String getWarnTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd = sdf.format(new Date(warnTimel * 1000));
        return sd;
    }
}
