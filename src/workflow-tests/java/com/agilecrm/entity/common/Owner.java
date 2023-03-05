package com.agilecrm.entity.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import org.springframework.stereotype.Component;


@ToString
@Component
public class Owner {
  private Long id;
  private String domain;
  private String email;
  private String phone;
  private String name;
  private String pic;
  private String scheduleId;
  private String calendarUrl;
  private String calendarURL;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPic() {
    return pic;
  }

  public void setPic(String pic) {
    this.pic = pic;
  }

  @JsonProperty("schedule_id")
  public String getScheduleId() {
    return scheduleId;
  }

  @JsonProperty("schedule_id")
  public void setScheduleId(String scheduleId) {
    this.scheduleId = scheduleId;
  }

  @JsonProperty("calendar_url")
  public String getCalendarUrl() {
    return calendarUrl;
  }

  @JsonProperty("calendar_url")
  public void setCalendarUrl(String calendarUrl) {
    this.calendarUrl = calendarUrl;
  }

  public String getCalendarURL() {
    return calendarURL;
  }


  public void setCalendarURL(String calendarURL) {
    this.calendarURL = calendarURL;
  }


}
