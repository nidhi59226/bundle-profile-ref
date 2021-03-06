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
 * Identification
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-01-23T15:18:38.136+05:30[Asia/Calcutta]")
public class Identification {
  public static final String SERIALIZED_NAME_COUNTRY = "country";
  @SerializedName(SERIALIZED_NAME_COUNTRY)
  private String country;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private String type;

  public static final String SERIALIZED_NAME_VALUE = "value";
  @SerializedName(SERIALIZED_NAME_VALUE)
  private String value;


  public Identification country(String country) {
    
    this.country = country;
    return this;
  }

   /**
   * Issuing country ISO code where identification proof has been issued
   * @return country
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "BR", value = "Issuing country ISO code where identification proof has been issued")

  public String getCountry() {
    return country;
  }



  public void setCountry(String country) {
    this.country = country;
  }


  public Identification type(String type) {
    
    this.type = type;
    return this;
  }

   /**
   * The type of identification. Accepted values include: [ssn, cpf, driver&#39;s license, pan, passport, adhaar]
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "CPF", value = "The type of identification. Accepted values include: [ssn, cpf, driver's license, pan, passport, adhaar]")

  public String getType() {
    return type;
  }



  public void setType(String type) {
    this.type = type;
  }


  public Identification value(String value) {
    
    this.value = value;
    return this;
  }

   /**
   * This would be an alphanumeric value of the respective identification (eg. for ssn, the value would be 9 digits/characters)
   * @return value
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "496881234", value = "This would be an alphanumeric value of the respective identification (eg. for ssn, the value would be 9 digits/characters)")

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
    Identification identification = (Identification) o;
    return Objects.equals(this.country, identification.country) &&
        Objects.equals(this.type, identification.type) &&
        Objects.equals(this.value, identification.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(country, type, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Identification {\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
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

