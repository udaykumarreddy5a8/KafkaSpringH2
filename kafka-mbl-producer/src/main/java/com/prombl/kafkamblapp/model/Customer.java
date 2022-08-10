package com.prombl.kafkamblapp.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;


public class Customer {
	  @JsonProperty("customerNumber")
	  @Schema(required = true,maxLength = 10)
	  @NotNull
	  private String customerNumber = null;

	  @JsonProperty("firstName")
	  @Schema(required = true,minLength = 10,maxLength = 50)
	  @NotNull
	  private String firstName = null;

	  @JsonProperty("lastName")
	  @Schema(required = true,minLength = 10,maxLength = 50)
	  @NotNull
	  private String lastName = null;

	  @JsonProperty("birthdate")
	  @Schema(defaultValue = "01-01-1900",required = true,format = "dd-MM-yyyy",pattern = "dd-MM-yyyy")
	  @NotNull
	  private String birthdate = null;

	  @JsonProperty("country")
	  @Schema(required = true)
	  @NotNull
	  private String country = null;

	  @JsonProperty("countryCode")
	  @Schema(required = true,maxLength = 2)
	  @NotNull
	  private String countryCode = null;

	  @JsonProperty("email")
	  @Schema(required = true,maxLength = 50)
	  @NotNull
	  private String email = null;

	  /**
	   * Customer Status
	   */
	  @NotNull
	  public enum CustomerStatusEnum {
	    OPEN("open"),
	    
	    CLOSE("close"),
	    
	    SUSPENDED("suspended"),
	    
	    RESTORED("restored");

	    private String value;

	    CustomerStatusEnum(String value) {
	      this.value = value;
	    }

	    @Override
	    @JsonValue
	    public String toString() {
	      return String.valueOf(value);
	    }

	    @JsonCreator
	    public static CustomerStatusEnum fromValue(String text) {
	      for (CustomerStatusEnum b : CustomerStatusEnum.values()) {
	        if (String.valueOf(b.value).equals(text)) {
	          return b;
	        }
	      }
	      return null;
	    }
	  }

	  @JsonProperty("customer status")
	  private CustomerStatusEnum customerStatus = null;

	  @JsonProperty("Address")
	  @NotNull
	  private Address address = null;

	  public Customer customerNumber(String customerNumber) {
	    this.customerNumber = customerNumber;
	    return this;
	  }

	  /**
	   * Get customerNumber
	   * @return customerNumber
	  **/

	  public String getCustomerNumber() {
	    return customerNumber;
	  }

	  public void setCustomerNumber(String customerNumber) {
	    this.customerNumber = customerNumber;
	  }

	  public Customer firstName(String firstName) {
	    this.firstName = firstName;
	    return this;
	  }

	  /**
	   * Get firstName
	   * @return firstName
	  **/

	  public String getFirstName() {
	    return firstName;
	  }

	  public void setFirstName(String firstName) {
	    this.firstName = firstName;
	  }

	  public Customer lastName(String lastName) {
	    this.lastName = lastName;
	    return this;
	  }

	  /**
	   * Get lastName
	   * @return lastName
	  **/

	  public String getLastName() {
	    return lastName;
	  }

	  public void setLastName(String lastName) {
	    this.lastName = lastName;
	  }

	  public Customer birthdate(String birthdate) {
	    this.birthdate = birthdate;
	    return this;
	  }

	  /**
	   * birth date
	   * @return birthdate
	  **/

	  public String getBirthdate() {
	    return birthdate;
	  }

	  public void setBirthdate(String birthdate) {
	    this.birthdate = birthdate;
	  }

	  public Customer country(String country) {
	    this.country = country;
	    return this;
	  }

	  /**
	   * Get country
	   * @return country
	  **/
	  public String getCountry() {
	    return country;
	  }

	  public void setCountry(String country) {
	    this.country = country;
	  }

	  public Customer countryCode(String countryCode) {
	    this.countryCode = countryCode;
	    return this;
	  }

	  /**
	   * Get countryCode
	   * @return countryCode
	  **/
	  
	  public String getCountryCode() {
	    return countryCode;
	  }

	  public void setCountryCode(String countryCode) {
	    this.countryCode = countryCode;
	  }

	  public Customer email(String email) {
	    this.email = email;
	    return this;
	  }

	  /**
	   * Get email
	   * @return email
	  **/
	  
 
	  public String getEmail() {
	    return email;
	  }

	  public void setEmail(String email) {
	    this.email = email;
	  }

	  public Customer customerStatus(CustomerStatusEnum customerStatus) {
	    this.customerStatus = customerStatus;
	    return this;
	  }

	  /**
	   * Customer Status
	   * @return customerStatus
	  **/
	  


	  public CustomerStatusEnum getCustomerStatus() {
	    return customerStatus;
	  }

	  public void setCustomerStatus(CustomerStatusEnum customerStatus) {
	    this.customerStatus = customerStatus;
	  }

	  public Customer address(Address address) {
	    this.address = address;
	    return this;
	  }

	  /**
	   * Get address
	   * @return address
	  **/
	  
	  public Address getAddress() {
	    return address;
	  }

	  public void setAddress(Address address) {
	    this.address = address;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    Customer customer = (Customer) o;
	    return Objects.equals(this.customerNumber, customer.customerNumber) &&
	        Objects.equals(this.firstName, customer.firstName) &&
	        Objects.equals(this.lastName, customer.lastName) &&
	        Objects.equals(this.birthdate, customer.birthdate) &&
	        Objects.equals(this.country, customer.country) &&
	        Objects.equals(this.countryCode, customer.countryCode) &&
	        Objects.equals(this.email, customer.email) &&
	        Objects.equals(this.customerStatus, customer.customerStatus) &&
	        Objects.equals(this.address, customer.address);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(customerNumber, firstName, lastName, birthdate, country, countryCode, email, customerStatus, address);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class Customer {\n");
	    
	    sb.append("    customerNumber: ").append(toIndentedString(customerNumber)).append("\n");
	    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
	    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
	    sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
	    sb.append("    country: ").append(toIndentedString(country)).append("\n");
	    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
	    sb.append("    email: ").append(toIndentedString(email)).append("\n");
	    sb.append("    customerStatus: ").append(toIndentedString(customerStatus)).append("\n");
	    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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
