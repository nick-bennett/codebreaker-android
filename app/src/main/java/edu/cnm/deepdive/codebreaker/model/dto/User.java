package edu.cnm.deepdive.codebreaker.model.dto;

import com.google.gson.annotations.Expose;
import java.util.UUID;

public class User {

  @Expose
  private UUID id;

  @Expose
  private String displayName;

  @Expose
  private boolean incognito;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public boolean isIncognito() {
    return incognito;
  }

  public void setIncognito(boolean incognito) {
    this.incognito = incognito;
  }

}
