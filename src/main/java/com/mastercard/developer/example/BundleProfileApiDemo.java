package com.mastercard.developer.example;



import com.mastercard.developer.bundle_client.model.*;
import com.mastercard.developer.bundle_client.ApiClient;
import com.mastercard.developer.bundle_client.ApiException;
import com.mastercard.developer.bundle_client.api.BundleProfileApi;
import com.mastercard.developer.interceptors.OkHttpOAuth1Interceptor;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.*;
import java.util.*;


public class BundleProfileApiDemo {

    public static void main(String [] args) throws Exception {

        RequestHelper.loadProperties();

        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(RequestHelper.getBaseURL());
        apiClient.getHttpClient().newBuilder().interceptors().add(new OkHttpOAuth1Interceptor(RequestHelper.getConsumerkey(),RequestHelper.getPrivateKey()));
        apiClient.setDebugging(true);

        BundleProfileApi bundleProfileApi = new BundleProfileApi(apiClient);

      if (runThisScenario(args, "readUser")) {
            executeGetBundleUserScenario(bundleProfileApi);
        }

        if (runThisScenario(args, "createUser")) {
            executeCreateBundleUserScenario(bundleProfileApi);
        }

        if (runThisScenario(args, "addProduct")) {
            executeAddProductBundleUserScenario(bundleProfileApi);
        }

        if (runThisScenario(args, "addAccount")) {
            executeAddAccountBundleUserScenario(bundleProfileApi);
        }

        if (runThisScenario(args, "removeAccount")) {
            executeRemoveAccountBundleUserScenario(bundleProfileApi);
        }

        if (runThisScenario(args, "replaceAccount")) {
            executeReplaceAccountBundleUserScenario(bundleProfileApi);
        }

        if (runThisScenario(args, "replaceUser")) {
            executeReplaceUserDetailScenario(bundleProfileApi);
        }




    }


 private static void executeGetBundleUserScenario(BundleProfileApi bundleProfileApi) {
        String userId = "specialpayUser";
        String xClientCorrelationId = "bundle-reference-app-stage";
        try {
            printMessage("STARTING GET USER FOR BUNDLE PROFILE");
            bundleProfileApi.readUser(userId,xClientCorrelationId);
        } catch (Exception e) {
            System.err.println("Exception when calling Lounge Details");
            e.printStackTrace();
        }
    }

    private static void executeCreateBundleUserScenario(BundleProfileApi bundleProfileApi) throws IOException, ApiException {
        printMessage("STARTING CREATE USER FOR BUNDLE PROFILE");
        ObjectMapper mapper = new ObjectMapper();
        String xClientCorrelationId = "bundle-reference-app-stage";

        ArrayList<InputStream> createUserPayload = RequestHelper.getPostBody();
        for (InputStream createProductBasedUser : createUserPayload){
            BundleUser userBody = mapper.readValue(createProductBasedUser, BundleUser.class);
            bundleProfileApi.createUser(userBody, xClientCorrelationId);
        }
    }

    private static void executeAddProductBundleUserScenario(BundleProfileApi bundleProfileApi) throws IOException, ApiException {
        printMessage("STARTING ADD PRODUCT FOR BUNDLE PROFILE");
        ObjectMapper mapper = new ObjectMapper();
        String xClientCorrelationId = "bundle-reference-app-stage";

        ArrayList<InputStream> patchUserPayload = RequestHelper.getAddProductBody();
        for (InputStream createProductBasedUser : patchUserPayload){
            BundleUserPatch userBody = mapper.readValue(createProductBasedUser, BundleUserPatch.class);
            bundleProfileApi.patchUser(userBody.getPatch().get(0).getValue().getData().getUser().getUserId(),userBody, xClientCorrelationId);
        }
    }

    private static void executeAddAccountBundleUserScenario(BundleProfileApi bundleProfileApi) throws ApiException, UnsupportedEncodingException {
        printMessage("STARTING ADD ACCOUNT FOR BUNDLE PROFILE");
        ObjectMapper mapper = new ObjectMapper();
        String xClientCorrelationId = "bundle-reference-app-stage";
        BundleUserPatch bundleUserPatch = createAddAccountPayload();
        bundleProfileApi.patchUser("user234",bundleUserPatch, xClientCorrelationId);
    }



    private static void executeRemoveAccountBundleUserScenario(BundleProfileApi bundleProfileApi) throws ApiException, UnsupportedEncodingException {
        printMessage("STARTING REMOVE ACCOUNT FOR BUNDLE PROFILE");
        ObjectMapper mapper = new ObjectMapper();
        String xClientCorrelationId = "bundle-reference-app-stage";
        BundleUserPatch bundleUserPatch = createRemoveAccountPayload();
        bundleProfileApi.patchUser("user1234",bundleUserPatch, xClientCorrelationId);
    }

    private static void executeReplaceAccountBundleUserScenario(BundleProfileApi bundleProfileApi) throws ApiException, UnsupportedEncodingException {
        printMessage("STARTING REPLACE ACCOUNT FOR BUNDLE PROFILE");
        ObjectMapper mapper = new ObjectMapper();
        String xClientCorrelationId = "bundle-reference-app-stage";
        BundleUserPatch bundleUserPatch = createReplaceAccountPayload();
        bundleProfileApi.patchUser("specialpayUser",bundleUserPatch, xClientCorrelationId);
    }

    private static void executeReplaceUserDetailScenario(BundleProfileApi bundleProfileApi) throws ApiException, IOException {
        printMessage("STARTING REPLACE USER FOR BUNDLE PROFILE");
        ObjectMapper mapper = new ObjectMapper();
        String xClientCorrelationId = "bundle-reference-app-stage";

        ArrayList<InputStream> patchUserPayload = RequestHelper.getUserUpdateBody();
        for (InputStream createProductBasedUser : patchUserPayload){
            BundleUserPatch userBody = mapper.readValue(createProductBasedUser, BundleUserPatch.class);
            bundleProfileApi.patchUser("specialpayUser",userBody, xClientCorrelationId);
        }
    }


    private static BundleUserPatch createReplaceAccountPayload() {
        BundleUserPatch bundleUserPatch = new BundleUserPatch();
        List<PatchDocument> patchDocumentList = new ArrayList<PatchDocument>();
        PatchDocument patchDocument = new PatchDocument();
        PatchDocumentValue patchDocumentValue = new PatchDocumentValue();
        BundleUserData bundleUserData = new BundleUserData();
        UserProduct userProduct = new UserProduct();
        Account account = new Account();
        account.setPan("5000000000000000");
        account.setNameOnCard("XYZ Systems");
        account.setCardExpiryDate("02/2020");
        account.setCvcCode("123");
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        userProduct.setAccounts(accounts);
        List<UserProduct> products = new ArrayList<>();
        products.add(userProduct);
        bundleUserData.setProducts(products);
        patchDocument.setOp("replace");
        patchDocument.setPath("$.data.products[?(@.product=='')].accounts[?(@.pan=='5412167896000045')]");
        patchDocument.setFrom("string");
        patchDocument.setValue(patchDocumentValue);
        patchDocumentValue.setData(bundleUserData);
        patchDocumentList.add(patchDocument);
        bundleUserPatch.setPatch(patchDocumentList);
        return bundleUserPatch;
    }




    private static BundleUserPatch createAddAccountPayload() {
        BundleUserPatch bundleUserPatch = new BundleUserPatch();
        List<PatchDocument> patchDocumentList = new ArrayList<PatchDocument>();
        PatchDocument patchDocument = new PatchDocument();
        PatchDocumentValue patchDocumentValue = new PatchDocumentValue();
        BundleUserData bundleUserData = new BundleUserData();
        UserProduct userProduct = new UserProduct();
        Account account = new Account();
        account.setPan("5000000000000000");
        account.setIca(1017L);
        account.setCvcCode("876");
        account.setCardExpiryDate("02/2022");
        account.setNameOnCard("nameOnCard");
        account.setAccountType("accountType");
        Object object = new Object();
        account.setObject(object);
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        patchDocument.setOp("add");
        patchDocument.setPath("$.data.products[?(@.product=='')].account");
        patchDocument.setFrom("string");
        patchDocument.setValue(patchDocumentValue);
        patchDocumentValue.setAccounts(accounts);
        patchDocumentList.add(patchDocument);
        bundleUserPatch.setPatch(patchDocumentList);
        return bundleUserPatch;
    }

    private static BundleUserPatch createRemoveAccountPayload() {
        BundleUserPatch bundleUserPatch = new BundleUserPatch();
        List<PatchDocument> patchDocumentList = new ArrayList<PatchDocument>();
        PatchDocument patchDocument = new PatchDocument();
        PatchDocumentValue patchDocumentValue = new PatchDocumentValue();
        BundleUserData bundleUserData = new BundleUserData();
        UserProduct userProduct = new UserProduct();
        Account account = new Account();
        account.setPan("5000000000000000");
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        userProduct.setAccounts(accounts);
        List<UserProduct> products = new ArrayList<>();
        products.add(userProduct);
        bundleUserData.setProducts(products);
        patchDocument.setOp("remove");
        patchDocument.setPath("$.data.products[?(@.product=='')].accounts[?(@.pan=='5000000000000000')]");
        patchDocument.setFrom("string");
        patchDocument.setValue(patchDocumentValue);
        patchDocumentValue.setData(bundleUserData);
        patchDocumentList.add(patchDocument);
        bundleUserPatch.setPatch(patchDocumentList);
        return bundleUserPatch;
    }

    private static boolean runThisScenario(String[] args, String scenario) {
        return (args!=null && args.length>0 && args[0].contains(scenario)) || (args == null || args.length == 0);
    }


    private static void printMessage(String scenario) {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println(scenario+"---------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
    }





}
