# BundleProfileApi

All URIs are relative to *https://api.mastercard.com/bundle/profile*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUser**](BundleProfileApi.md#createUser) | **POST** /users | Create Profile
[**patchUser**](BundleProfileApi.md#patchUser) | **POST** /users/{user_id}/patch | Partially Update Profile
[**readConsent**](BundleProfileApi.md#readConsent) | **GET** /users/{user_id}/products/{product}/consents | Find Consent by Id and product
[**readUser**](BundleProfileApi.md#readUser) | **GET** /users/{user_id} | Find User by Id


<a name="createUser"></a>
# **createUser**
> BundleUserResponse createUser(body, xClientCorrelationId)

Create Profile

Create Profile user and associated product service(s) consents and card account(s)

### Example
```java
// Import classes:
import com.mastercard.developer.bundle_client.ApiClient;
import com.mastercard.developer.bundle_client.ApiException;
import com.mastercard.developer.bundle_client.Configuration;
import com.mastercard.developer.bundle_client.models.*;
import com.mastercard.developer.bundle_client.api.BundleProfileApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mastercard.com/bundle/profile");

    BundleProfileApi apiInstance = new BundleProfileApi(defaultClient);
    BundleUser body = new BundleUser(); // BundleUser | Bundle Profile body
    String xClientCorrelationId = "xClientCorrelationId_example"; // String | Unique request identifier from the client, usually a Version 4 UUID string (36 characters long including dashes, such as \"f6fd03c6-2dfe-46ea-99f9-6fd7bc34d8d8\")
    try {
      BundleUserResponse result = apiInstance.createUser(body, xClientCorrelationId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BundleProfileApi#createUser");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**BundleUser**](BundleUser.md)| Bundle Profile body |
 **xClientCorrelationId** | **String**| Unique request identifier from the client, usually a Version 4 UUID string (36 characters long including dashes, such as \&quot;f6fd03c6-2dfe-46ea-99f9-6fd7bc34d8d8\&quot;) | [optional]

### Return type

[**BundleUserResponse**](BundleUserResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Create resource with messages |  -  |
**201** | Successful create resource |  -  |
**0** | Unexpected error |  -  |

<a name="patchUser"></a>
# **patchUser**
> BundleUserResponse patchUser(userId, body, xClientCorrelationId)

Partially Update Profile

Partial updates of Profile user and associated product service(s) consents and card account(s)

### Example
```java
// Import classes:
import com.mastercard.developer.bundle_client.ApiClient;
import com.mastercard.developer.bundle_client.ApiException;
import com.mastercard.developer.bundle_client.Configuration;
import com.mastercard.developer.bundle_client.models.*;
import com.mastercard.developer.bundle_client.api.BundleProfileApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mastercard.com/bundle/profile");

    BundleProfileApi apiInstance = new BundleProfileApi(defaultClient);
    String userId = "userId_example"; // String | Opaque identifier for the consumer. Issuer/Acquirer to send it complies to IETF RFC2396; MC provisions it depends on the use case, such as user123-partnerBank
    BundleUserPatch body = new BundleUserPatch(); // BundleUserPatch | Bundle Profile body
    String xClientCorrelationId = "xClientCorrelationId_example"; // String | Unique request identifier from the client, usually a Version 4 UUID string (36 characters long including dashes, such as \"f6fd03c6-2dfe-46ea-99f9-6fd7bc34d8d8\")
    try {
      BundleUserResponse result = apiInstance.patchUser(userId, body, xClientCorrelationId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BundleProfileApi#patchUser");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| Opaque identifier for the consumer. Issuer/Acquirer to send it complies to IETF RFC2396; MC provisions it depends on the use case, such as user123-partnerBank |
 **body** | [**BundleUserPatch**](BundleUserPatch.md)| Bundle Profile body |
 **xClientCorrelationId** | **String**| Unique request identifier from the client, usually a Version 4 UUID string (36 characters long including dashes, such as \&quot;f6fd03c6-2dfe-46ea-99f9-6fd7bc34d8d8\&quot;) | [optional]

### Return type

[**BundleUserResponse**](BundleUserResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Update resource with messages |  -  |
**0** | Unexpected error |  -  |

<a name="readConsent"></a>
# **readConsent**
> BundleUserResponse readConsent(userId, product, xClientCorrelationId)

Find Consent by Id and product

Returns a Consent on the basis of provided id, product as path params (https://tools.ietf.org/html/draft-ietf-scim-api-19#section-3.4.2.1)

### Example
```java
// Import classes:
import com.mastercard.developer.bundle_client.ApiClient;
import com.mastercard.developer.bundle_client.ApiException;
import com.mastercard.developer.bundle_client.Configuration;
import com.mastercard.developer.bundle_client.models.*;
import com.mastercard.developer.bundle_client.api.BundleProfileApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mastercard.com/bundle/profile");

    BundleProfileApi apiInstance = new BundleProfileApi(defaultClient);
    String userId = "userId_example"; // String | Opaque identifier for the consumer. Issuer/Acquirer to send it complies to IETF RFC2396; MC provisions it depends on the use case. Ex - User123Z
    String product = "product_example"; // String | product identifier
    String xClientCorrelationId = "xClientCorrelationId_example"; // String | Unique request identifier from the client, usually a Version 4 UUID string (36 characters long including dashes, such as \"f6fd03c6-2dfe-46ea-99f9-6fd7bc34d8d8\")
    try {
      BundleUserResponse result = apiInstance.readConsent(userId, product, xClientCorrelationId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BundleProfileApi#readConsent");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| Opaque identifier for the consumer. Issuer/Acquirer to send it complies to IETF RFC2396; MC provisions it depends on the use case. Ex - User123Z |
 **product** | **String**| product identifier |
 **xClientCorrelationId** | **String**| Unique request identifier from the client, usually a Version 4 UUID string (36 characters long including dashes, such as \&quot;f6fd03c6-2dfe-46ea-99f9-6fd7bc34d8d8\&quot;) | [optional]

### Return type

[**BundleUserResponse**](BundleUserResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Read resource with messages |  -  |
**0** | Unexpected error |  -  |

<a name="readUser"></a>
# **readUser**
> BundleUserResponse readUser(userId, xClientCorrelationId)

Find User by Id

Returns a Users on the basis of provided id as path param (https://tools.ietf.org/html/draft-ietf-scim-api-19#section-3.4.2.1)

### Example
```java
// Import classes:
import com.mastercard.developer.bundle_client.ApiClient;
import com.mastercard.developer.bundle_client.ApiException;
import com.mastercard.developer.bundle_client.Configuration;
import com.mastercard.developer.bundle_client.models.*;
import com.mastercard.developer.bundle_client.api.BundleProfileApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mastercard.com/bundle/profile");

    BundleProfileApi apiInstance = new BundleProfileApi(defaultClient);
    String userId = "userId_example"; // String | Opaque identifier for the consumer. Issuer/Acquirer to send it complies to IETF RFC2396; MC provisions it depends on the use case, such as user123-partnerBank
    String xClientCorrelationId = "xClientCorrelationId_example"; // String | Unique request identifier from the client, usually a Version 4 UUID string (36 characters long including dashes, such as \"f6fd03c6-2dfe-46ea-99f9-6fd7bc34d8d8\")
    try {
      BundleUserResponse result = apiInstance.readUser(userId, xClientCorrelationId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BundleProfileApi#readUser");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **String**| Opaque identifier for the consumer. Issuer/Acquirer to send it complies to IETF RFC2396; MC provisions it depends on the use case, such as user123-partnerBank |
 **xClientCorrelationId** | **String**| Unique request identifier from the client, usually a Version 4 UUID string (36 characters long including dashes, such as \&quot;f6fd03c6-2dfe-46ea-99f9-6fd7bc34d8d8\&quot;) | [optional]

### Return type

[**BundleUserResponse**](BundleUserResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Read resource with messages |  -  |
**0** | Unexpected error |  -  |

