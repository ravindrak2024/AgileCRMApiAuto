package entity.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;


@ToString
public class Viewed {
  private Long viewedTime;
  private Long viewerId;

  @JsonProperty("viewed_time")
  public Long getViewedTime() {
    return viewedTime;
  }


  @JsonProperty("viewed_time")
  public void setViewedTime(Long viewedTime) {
    this.viewedTime = viewedTime;
  }

  @JsonProperty("viewer_id")
  public Long getViewerId() {
    return viewerId;
  }

  @JsonProperty("viewer_id")
  public void setViewerId(Long viewerId) {
    this.viewerId = viewerId;
  }


}
