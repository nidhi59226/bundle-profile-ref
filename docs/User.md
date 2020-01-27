

# User

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**active** | **Boolean** | A Boolean value indicating the user&#39;s administrative status. When a user is registered with a bank, it is stored in a database with active &#x3D; false flag, the user gets activated and can log in after entering an activation code. |  [optional]
**addresses** | [**List&lt;Address&gt;**](Address.md) |  |  [optional]
**displayName** | **String** | The name of the User, suitable for display to end-users. The name should be the full name of the User being described, if known. |  [optional]
**emails** | [**List&lt;Email&gt;**](Email.md) |  |  [optional]
**userId** | **String** | Unique, opaque identifier for the user as defined by the provisioning client. The allowed values for alphanumeric characters are [a-z, A-Z, 0-9] and unreserved special characters [-_.!~*&#39;()] |  [optional]
**externalId** | **String** | External client unique identifier, identical to the userId for external clients |  [optional]
**id** | **String** | Unique identifier for the user as defined by MA. |  [optional]
**identifications** | [**List&lt;Identification&gt;**](Identification.md) |  |  [optional]
**ims** | [**List&lt;Im&gt;**](Im.md) |  |  [optional]
**locale** | **String** | Used to indicate the User&#39;s default location for purposes of localizing items such as currency, date time format, or numerical representations. |  [optional]
**name** | [**Name**](Name.md) |  |  [optional]
**nickName** | **String** | The casual way to address the user in real life, e.g., &#39;Bob&#39; or &#39;Bobby&#39; instead of &#39;Robert&#39;. This attribute should not be used to represent a User&#39;s username (e.g., &#39;bjensen&#39; or &#39;mpepperidge&#39;). |  [optional]
**password** | **String** |  |  [optional]
**phoneNumbers** | [**List&lt;PhoneNumber&gt;**](PhoneNumber.md) |  |  [optional]
**photos** | [**List&lt;Photo&gt;**](Photo.md) |  |  [optional]
**preferredLanguage** | **String** | Indicates Preferred spoken/written Language with/without region form - Internationalization (Locale) like zh_CN, en_GB, fr |  [optional]
**profileUrl** | **String** | A fully qualified URL pointing to a page representing the User&#39;s online profile. |  [optional]
**timezone** | **String** | The User&#39;s time zone in the &#39;Olson&#39; time zone database format, e.g., &#39;America/Los_Angeles&#39;. |  [optional]
**title** | **String** | The user&#39;s title, such as Vice President. |  [optional]
**userName** | **String** | Unique identifier for the User, typically used by the user to directly authenticate to the client provider. Each User must include a non-empty userName value. This identifier must be unique across the client&#39;s entire set of Users. |  [optional]
**userType** | **String** | Used to identify the relationship between the organization and the user. Typical values used might be &#39;Contractor&#39;, &#39;Employee&#39;, &#39;Intern&#39;, &#39;Temp&#39;, &#39;External&#39;, and &#39;Unknown&#39;, but any value may be used. |  [optional]
**dateOfBirth** | **String** | date of birth of user in format YYYY-MM-DD |  [optional]



