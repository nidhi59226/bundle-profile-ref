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


    public static void main(String[] args) throws Exception {

        RequestHelper.loadProperties();

        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(RequestHelper.getBaseURL());
        apiClient.getHttpClient().newBuilder().interceptors().add(new OkHttpOAuth1Interceptor(RequestHelper.getConsumerkey(), RequestHelper.getPrivateKey()));
        apiClient.setDebugging(true);

        BundleProfileApi bundleProfileApi = new BundleProfileApi(apiClient);

        String userID = "specialpayUser";
        String xClientCorrelationId = "bundle-reference-app-stage";

        if (runThisScenario(args, "readUser")) {
            executeGetBundleUserScenario(bundleProfileApi, userID, xClientCorrelationId);
        }

        if (runThisScenario(args, "createUser")) {
            executeCreateBundleUserScenario(bundleProfileApi, xClientCorrelationId);
        }

        if (runThisScenario(args, "addProduct")) {
            executeAddProductBundleUserScenario(bundleProfileApi, xClientCorrelationId);
        }

        if (runThisScenario(args, "addAccount")) {
            executeAddAccountBundleUserScenario(bundleProfileApi, userID, xClientCorrelationId);
        }

        if (runThisScenario(args, "removeAccount")) {
            executeRemoveAccountBundleUserScenario(bundleProfileApi, userID, xClientCorrelationId);
        }

        if (runThisScenario(args, "replaceAccount")) {
            executeReplaceAccountBundleUserScenario(bundleProfileApi, userID, xClientCorrelationId);
        }

        if (runThisScenario(args, "replaceUser")) {
            executeReplaceUserDetailScenario(bundleProfileApi, userID, xClientCorrelationId);
        }


    }


    private static void executeGetBundleUserScenario(BundleProfileApi bundleProfileApi, String userID, String xClientCorrelationId) throws ApiException {

        printMessage("STARTING GET USER FOR BUNDLE PROFILE");
       bundleProfileApi.readUser(userID, xClientCorrelationId);

    }

    private static void executeCreateBundleUserScenario(BundleProfileApi bundleProfileApi, String xClientCorrelationId) throws IOException, ApiException {
        printMessage("STARTING CREATE USER FOR BUNDLE PROFILE");
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<InputStream> createUserPayload = RequestHelper.getPostBody();
        for (InputStream createProductBasedUser : createUserPayload) {
            BundleUser userBody = mapper.readValue(createProductBasedUser, BundleUser.class);
            bundleProfileApi.createUser(userBody, xClientCorrelationId);
        }
    }

    private static void executeAddProductBundleUserScenario(BundleProfileApi bundleProfileApi, String xClientCorrelationId) throws IOException, ApiException {
        printMessage("STARTING ADD PRODUCT FOR BUNDLE PROFILE");
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<InputStream> patchUserPayload = RequestHelper.getAddProductBody();
        for (InputStream createProductBasedUser : patchUserPayload) {
            BundleUserPatch userBody = mapper.readValue(createProductBasedUser, BundleUserPatch.class);
            bundleProfileApi.patchUser(userBody.getPatch().get(0).getValue().getData().getUser().getUserId(), userBody, xClientCorrelationId);
        }
    }

    private static void executeAddAccountBundleUserScenario(BundleProfileApi bundleProfileApi, String userID, String xClientCorrelationId) throws ApiException, UnsupportedEncodingException {
        printMessage("STARTING ADD ACCOUNT FOR BUNDLE PROFILE");
        ObjectMapper mapper = new ObjectMapper();
        BundleUserPatch bundleUserPatch = RequestHelper.createAddAccountPayload();
        bundleProfileApi.patchUser(userID, bundleUserPatch, xClientCorrelationId);
    }


    private static void executeRemoveAccountBundleUserScenario(BundleProfileApi bundleProfileApi, String userID, String xClientCorrelationId) throws ApiException, UnsupportedEncodingException {
        printMessage("STARTING REMOVE ACCOUNT FOR BUNDLE PROFILE");
        ObjectMapper mapper = new ObjectMapper();
        BundleUserPatch bundleUserPatch = RequestHelper.createRemoveAccountPayload();
        bundleProfileApi.patchUser(userID, bundleUserPatch, xClientCorrelationId);
    }

    private static void executeReplaceAccountBundleUserScenario(BundleProfileApi bundleProfileApi, String userID, String xClientCorrelationId) throws ApiException, UnsupportedEncodingException {
        printMessage("STARTING REPLACE ACCOUNT FOR BUNDLE PROFILE");
        ObjectMapper mapper = new ObjectMapper();
        BundleUserPatch bundleUserPatch = RequestHelper.createReplaceAccountPayload();
        bundleProfileApi.patchUser(userID, bundleUserPatch, xClientCorrelationId);
    }

    private static void executeReplaceUserDetailScenario(BundleProfileApi bundleProfileApi, String userID, String xClientCorrelationId) throws ApiException, IOException {
        printMessage("STARTING REPLACE USER FOR BUNDLE PROFILE");
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<InputStream> patchUserPayload = RequestHelper.getUserUpdateBody();
        for (InputStream createProductBasedUser : patchUserPayload) {
            BundleUserPatch userBody = mapper.readValue(createProductBasedUser, BundleUserPatch.class);
            bundleProfileApi.patchUser(userID, userBody, xClientCorrelationId);
        }
    }

    private static boolean runThisScenario(String[] args, String scenario) {
        return (args != null && args.length > 0 && args[0].contains(scenario)) || (args == null || args.length == 0);
    }


    private static void printMessage(String scenario) {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println(scenario + "---------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
    }


}
