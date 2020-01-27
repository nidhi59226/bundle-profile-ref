

# PatchDocument

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**op** | [**OpEnum**](#OpEnum) | The operation to be performed | 
**path** | **String** | JSONPath | 
**from** | **String** | A string containing a JSON Pointer value. |  [optional]
**value** | [**PatchDocumentValue**](PatchDocumentValue.md) |  |  [optional]



## Enum: OpEnum

Name | Value
---- | -----
ADD | &quot;add&quot;
REMOVE | &quot;remove&quot;
REPLACE | &quot;replace&quot;



