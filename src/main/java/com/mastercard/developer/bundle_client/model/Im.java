/*
 * Bundle Profile API
 * MC product bundle profile
 *
 * The version of the OpenAPI document: 1.0
 * Contact: Digital_Enablement_Team_3@mastercard.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.mastercard.developer.bundle_client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Im
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-01-23T15:18:38.136+05:30[Asia/Calcutta]")
public class Im {
  public static final String SERIALIZED_NAME_DISPLAY = "display";
  @SerializedName(SERIALIZED_NAME_DISPLAY)
  private String display;

  public static final String SERIALIZED_NAME_OPERATION = "operation";
  @SerializedName(SERIALIZED_NAME_OPERATION)
  private String operation;

  public static final String SERIALIZED_NAME_PRIMARY = "primary";
  @SerializedName(SERIALIZED_NAME_PRIMARY)
  private Boolean primary;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private String type;

  public static final String SERIALIZED_NAME_VALUE = "value";
  @SerializedName(SERIALIZED_NAME_VALUE)
  private String value;


  public Im display(String display) {
    
    this.display = display;
    return this;
  }

   /**
   * User-name Skype/gtalk/yahoo detail
   * @return display
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "user Yahoo-id", value = "User-name Skype/gtalk/yahoo detail")

  public String getDisplay() {
    return display;
  }



  public void setDisplay(String display) {
    this.display = display;
  }


  public Im operation(String operation) {
    
    this.operation = operation;
    return this;
  }

   /**
   * Get operation
   * @return operation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getOperation() {
    return operation;
  }



  public void setOperation(String operation) {
    this.operation = operation;
  }


  public Im primary(Boolean primary) {
    
    this.primary = primary;
    return this;
  }

   /**
   * A Boolean value indicating the &#39;primary&#39; or preferred messenger, The primary attribute value &#39;true&#39; must appear no more than once.
   * @return primary
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "A Boolean value indicating the 'primary' or preferred messenger, The primary attribute value 'true' must appear no more than once.")

  public Boolean getPrimary() {
    return primary;
  }



  public void setPrimary(Boolean primary) {
    this.primary = primary;
  }


  public Im type(String type) {
    
    this.type = type;
    return this;
  }

   /**
   * A label indicating the attribute&#39;s function, Accepted values include: [aim, gtalk, icq, xmpp, msn, skype, qq, yahoo]
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "aim", value = "A label indicating the attribute's function, Accepted values include: [aim, gtalk, icq, xmpp, msn, skype, qq, yahoo]")

  public String getType() {
    return type;
  }



  public void setType(String type) {
    this.type = type;
  }


  public Im value(String value) {
    
    this.value = value;
    return this;
  }

   /**
   * Instant messaging addresses for the User
   * @return value
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "patrickStar123", value = "Instant messaging addresses for the User")

  public String getValue() {
    return value;
  }



  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Im im = (Im) o;
    return Objects.equals(this.display, im.display) &&
        Objects.equals(this.operation, im.operation) &&
        Objects.equals(this.primary, im.primary) &&
        Objects.equals(this.type, im.type) &&
        Objects.equals(this.value, im.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(display, operation, primary, type, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Im {\n");
    sb.append("    display: ").append(toIndentedString(display)).append("\n");
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
    sb.append("    primary: ").append(toIndentedString(primary)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

