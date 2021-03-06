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
 * UserReadAccountResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-01-23T15:18:38.136+05:30[Asia/Calcutta]")
public class UserReadAccountResponse {
  public static final String SERIALIZED_NAME_LAST4_PAN = "last4Pan";
  @SerializedName(SERIALIZED_NAME_LAST4_PAN)
  private Integer last4Pan;


   /**
   * Get last4Pan
   * @return last4Pan
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "0", value = "")

  public Integer getLast4Pan() {
    return last4Pan;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserReadAccountResponse userReadAccountResponse = (UserReadAccountResponse) o;
    return Objects.equals(this.last4Pan, userReadAccountResponse.last4Pan);
  }

  @Override
  public int hashCode() {
    return Objects.hash(last4Pan);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserReadAccountResponse {\n");
    sb.append("    last4Pan: ").append(toIndentedString(last4Pan)).append("\n");
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

