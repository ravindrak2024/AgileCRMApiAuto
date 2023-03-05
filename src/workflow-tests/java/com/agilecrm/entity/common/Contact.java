package com.agilecrm.entity.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@ToString
public class Contact {
  private Long id;
  private String type;
  private Integer createdTime;
  private Integer updatedTime;
  private Integer lastContacted;
  private Integer lastEmailed;
  private Integer lastCampaignEmaild;
  private Integer lastCalled;
  private Integer viewedTime;
  private Viewed viewed;
  private Integer starValue;
  private Integer leadScore;
  private String kloutScore;
  private List<String> tags = new ArrayList<>();
  private List<Object> tagsWithTime = new ArrayList<Object>();
  private List<Property> properties = new ArrayList<Property>();
  private List<Object> campaignStatus = new ArrayList<Object>();
  private String entityType;
  private String source;
  private List<Object> unsubscribeStatus = new ArrayList<Object>();
  private List<Object> emailBounceStatus = new ArrayList<Object>();
  private Integer formId;
  private List<Object> browserId = new ArrayList<Object>();
  private Integer leadSourceId;
  private Integer leadStatusId;
  private Boolean isLeadConverted;
  private Integer leadConvertedTime;
  private Boolean isDuplicateExisted;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("created_time")
  public Integer getCreatedTime() {
    return createdTime;
  }

  @JsonProperty("created_time")
  public void setCreatedTime(Integer createdTime) {
    this.createdTime = createdTime;
  }

  @JsonProperty("updated_time")
  public Integer getUpdatedTime() {
    return updatedTime;
  }

  @JsonProperty("updated_time")
  public void setUpdatedTime(Integer updatedTime) {
    this.updatedTime = updatedTime;
  }

  @JsonProperty("last_contacted")
  public Integer getLastContacted() {
    return lastContacted;
  }

  @JsonProperty("last_contacted")
  public void setLastContacted(Integer lastContacted) {
    this.lastContacted = lastContacted;
  }

  @JsonProperty("last_emailed")
  public Integer getLastEmailed() {
    return lastEmailed;
  }

  @JsonProperty("last_emailed")
  public void setLastEmailed(Integer lastEmailed) {
    this.lastEmailed = lastEmailed;
  }

  @JsonProperty("last_campaign_emaild")
  public Integer getLastCampaignEmaild() {
    return lastCampaignEmaild;
  }

  @JsonProperty("last_campaign_emaild")
  public void setLastCampaignEmaild(Integer lastCampaignEmaild) {
    this.lastCampaignEmaild = lastCampaignEmaild;
  }

  @JsonProperty("last_called")
  public Integer getLastCalled() {
    return lastCalled;
  }

  @JsonProperty("last_called")
  public void setLastCalled(Integer lastCalled) {
    this.lastCalled = lastCalled;
  }

  @JsonProperty("viewed_time")
  public Integer getViewedTime() {
    return viewedTime;
  }

  @JsonProperty("viewed_time")
  public void setViewedTime(Integer viewedTime) {
    this.viewedTime = viewedTime;
  }


  public Viewed getViewed() {
    return viewed;
  }

  public void setViewed(Viewed viewed) {
    this.viewed = viewed;
  }

  @JsonProperty("star_value")
  public Integer getStarValue() {
    return starValue;
  }

  @JsonProperty("star_value")
  public void setStarValue(Integer starValue) {
    this.starValue = starValue;
  }

  @JsonProperty("lead_score")
  public Integer getLeadScore() {
    return leadScore;
  }

  @JsonProperty("lead_score")
  public void setLeadScore(Integer leadScore) {
    this.leadScore = leadScore;
  }

  @JsonProperty("klout_score")
  public String getKloutScore() {
    return kloutScore;
  }

  @JsonProperty("klout_score")
  public void setKloutScore(String kloutScore) {
    this.kloutScore = kloutScore;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public List<Object> getTagsWithTime() {
    return tagsWithTime;
  }

  public void setTagsWithTime(List<Object> tagsWithTime) {
    this.tagsWithTime = tagsWithTime;
  }

  public List<Property> getProperties() {
    return properties;
  }

  public void setProperties(List<Property> properties) {
    this.properties = properties;
  }

  public List<Object> getCampaignStatus() {
    return campaignStatus;
  }

  public void setCampaignStatus(List<Object> campaignStatus) {
    this.campaignStatus = campaignStatus;
  }

  @JsonProperty("entity_type")
  public String getEntityType() {
    return entityType;
  }

  @JsonProperty("entity_type")
  public void setEntityType(String entityType) {
    this.entityType = entityType;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public List<Object> getUnsubscribeStatus() {
    return unsubscribeStatus;
  }

  public void setUnsubscribeStatus(List<Object> unsubscribeStatus) {
    this.unsubscribeStatus = unsubscribeStatus;
  }

  public List<Object> getEmailBounceStatus() {
    return emailBounceStatus;
  }

  public void setEmailBounceStatus(List<Object> emailBounceStatus) {
    this.emailBounceStatus = emailBounceStatus;
  }

  public Integer getFormId() {
    return formId;
  }

  public void setFormId(Integer formId) {
    this.formId = formId;
  }

  public List<Object> getBrowserId() {
    return browserId;
  }

  public void setBrowserId(List<Object> browserId) {
    this.browserId = browserId;
  }

  @JsonProperty("lead_source_id")
  public Integer getLeadSourceId() {
    return leadSourceId;
  }

  @JsonProperty("lead_source_id")
  public void setLeadSourceId(Integer leadSourceId) {
    this.leadSourceId = leadSourceId;
  }

  @JsonProperty("lead_status_id")
  public Integer getLeadStatusId() {
    return leadStatusId;
  }

  @JsonProperty("lead_status_id")
  public void setLeadStatusId(Integer leadStatusId) {
    this.leadStatusId = leadStatusId;
  }

  @JsonProperty("is_lead_converted")
  public Boolean getLeadConverted() {
    return isLeadConverted;
  }

  @JsonProperty("is_lead_converted")
  public void setLeadConverted(Boolean leadConverted) {
    isLeadConverted = leadConverted;
  }

  @JsonProperty("lead_converted_time")
  public Integer getLeadConvertedTime() {
    return leadConvertedTime;
  }


  @JsonProperty("lead_converted_time")
  public void setLeadConvertedTime(Integer leadConvertedTime) {
    this.leadConvertedTime = leadConvertedTime;
  }

  @JsonProperty("is_duplicate_existed")
  public Boolean getDuplicateExisted() {
    return isDuplicateExisted;
  }

  @JsonProperty("is_duplicate_existed")
  public void setDuplicateExisted(Boolean duplicateExisted) {
    isDuplicateExisted = duplicateExisted;
  }

  @JsonProperty("trashed_time")
  public Integer getTrashedTime() {
    return trashedTime;
  }

  @JsonProperty("trashed_time")
  public void setTrashedTime(Integer trashedTime) {
    this.trashedTime = trashedTime;
  }

  @JsonProperty("restored_time")
  public Integer getRestoredTime() {
    return restoredTime;
  }

  @JsonProperty("restored_time")
  public void setRestoredTime(Integer restoredTime) {
    this.restoredTime = restoredTime;
  }

  @JsonProperty("is_duplicate_verification_failed")
  public Boolean getDuplicateVerificationFailed() {
    return isDuplicateVerificationFailed;
  }

  @JsonProperty("is_duplicate_verification_failed")
  public void setDuplicateVerificationFailed(Boolean duplicateVerificationFailed) {
    isDuplicateVerificationFailed = duplicateVerificationFailed;
  }

  @JsonProperty("is_client_import")
  public Boolean getClientImport() {
    return isClientImport;
  }

  @JsonProperty("is_client_import")
  public void setClientImport(Boolean clientImport) {
    isClientImport = clientImport;
  }

  @JsonProperty("concurrent_save_allowed")
  public Boolean getConcurrentSaveAllowed() {
    return concurrentSaveAllowed;
  }

  @JsonProperty("concurrent_save_allowed")
  public void setConcurrentSaveAllowed(Boolean concurrentSaveAllowed) {
    this.concurrentSaveAllowed = concurrentSaveAllowed;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  private Integer trashedTime;
  private Integer restoredTime;
  private Boolean isDuplicateVerificationFailed;
  private Boolean isClientImport;
  private Boolean concurrentSaveAllowed;
  private Owner owner;
}