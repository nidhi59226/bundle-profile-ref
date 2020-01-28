package com.mastercard.developer.example;

import com.mastercard.developer.bundle_client.model.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.*;

public class RequestHelper{

    private static String CONSUMER_KEY ="mastercard.bundle.client.ref.app.consumer.key";

    private static String KEYSTORE_PATH ="mastercard.bundle.client.ref.app.keystore.path";

    private static String KEYSTORE_PASSWORD ="mastercard.bundle.client.ref.app.keystore.password";

    private static String BASE_URL = "mastercard.bundle.client.ref.app.url";

    private static String POST_USER_PAYLOADS = "post-user-payloads";

    private static String PATCH_ADD_PRODUCT_PAYLOADS = "patch-add-product-payloads";

    private static String PATCH_USER_UPDATE_PAYLOADS = "patch-user-update-payload";

    private static String TEMPLATES = "templates/";


    private static Properties prop = null;

    public static PrivateKey getPrivateKey() throws Exception {

        PrivateKey privateKey = null;
        KeyStore ks = null;

        try {

            ks = KeyStore.getInstance("PKCS12");
            InputStream is = getResourceStream(KEYSTORE_PATH);
            ks.load(is, prop.getProperty(KEYSTORE_PASSWORD).toCharArray());
            Enumeration aliases = ks.aliases();
            String keyAlias = "";

            while (aliases.hasMoreElements()) {
                keyAlias = (String) aliases.nextElement();
            }

            privateKey = (PrivateKey) ks.getKey(keyAlias, prop.getProperty(KEYSTORE_PASSWORD).toCharArray());
            is.close();
        } catch (Exception e) {
        }

        return privateKey;
    }

    public static String getConsumerkey() {
        return prop.getProperty(CONSUMER_KEY);
    }

    public static String getBaseURL() {
        return prop.getProperty(BASE_URL);
    }

    public static ArrayList<InputStream> getPostBody() {
        ArrayList<InputStream> postCreationMap = new ArrayList<>();
        List<String> listOfPostPayloads = Arrays.asList(prop.getProperty(POST_USER_PAYLOADS).split(","));
        for (String productBasedPayloads : listOfPostPayloads){
            postCreationMap.add(getResourceStream(TEMPLATES+productBasedPayloads));
        }
        return postCreationMap;

    }

    public static ArrayList<InputStream> getAddProductBody() {
        ArrayList<InputStream> patchCreationMap = new ArrayList<>();
        List<String> listOfPatchPayloads = Arrays.asList(prop.getProperty(PATCH_ADD_PRODUCT_PAYLOADS).split(","));
        for (String productBasedPayloads : listOfPatchPayloads){
            patchCreationMap.add(getResourceStream(TEMPLATES + productBasedPayloads));
        }
        return patchCreationMap;
    }

    public static ArrayList<InputStream> getUserUpdateBody() {
        ArrayList<InputStream> patchUserUpdateMap = new ArrayList<>();
        List<String> listOfAccountPayloads = Arrays.asList(prop.getProperty(PATCH_USER_UPDATE_PAYLOADS).split(","));
        for (String accountPayloads : listOfAccountPayloads){
            patchUserUpdateMap.add(getResourceStream(TEMPLATES + accountPayloads));
        }
        return patchUserUpdateMap;
    }



    private static InputStream getResourceStream(String inputString) {
        return RequestHelper.class.getClassLoader().getResourceAsStream(inputString);
    }


    public static void loadProperties() {
        if (prop == null || prop.isEmpty()) {
            try (InputStream input = RequestHelper.class.getClassLoader()
                    .getResourceAsStream("application.properties")) {
                prop = new Properties();
                if (input == null) {
                    return;
                }
                prop.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static BundleUserPatch createReplaceAccountPayload() {
        BundleUserPatch bundleUserPatch = new BundleUserPatch();
        List<PatchDocument> patchDocumentList = new ArrayList<PatchDocument>();
        PatchDocument patchDocument = new PatchDocument();
        PatchDocumentValue patchDocumentValue = new PatchDocumentValue();
        BundleUserData bundleUserData = new BundleUserData();
        UserProduct userProduct = new UserProduct();
        Account account = new Account();
        account.setPan("123456789909090");
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
        patchDocument.setPath("$.data.products[?(@.product=='')].accounts[?(@.pan=='123456789909089')]");
        patchDocument.setFrom("string");
        patchDocument.setValue(patchDocumentValue);
        patchDocumentValue.setData(bundleUserData);
        patchDocumentList.add(patchDocument);
        bundleUserPatch.setPatch(patchDocumentList);
        return bundleUserPatch;
    }

    public static BundleUserPatch createAddAccountPayload() {
        BundleUserPatch bundleUserPatch = new BundleUserPatch();
        List<PatchDocument> patchDocumentList = new ArrayList<PatchDocument>();
        PatchDocument patchDocument = new PatchDocument();
        PatchDocumentValue patchDocumentValue = new PatchDocumentValue();
        BundleUserData bundleUserData = new BundleUserData();
        UserProduct userProduct = new UserProduct();
        Account account = new Account();
        account.setPan("123456789909089");
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

    public static BundleUserPatch createRemoveAccountPayload() {
        BundleUserPatch bundleUserPatch = new BundleUserPatch();
        List<PatchDocument> patchDocumentList = new ArrayList<PatchDocument>();
        PatchDocument patchDocument = new PatchDocument();
        PatchDocumentValue patchDocumentValue = new PatchDocumentValue();
        BundleUserData bundleUserData = new BundleUserData();
        UserProduct userProduct = new UserProduct();
        Account account = new Account();
        account.setPan("123456789909089");
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        userProduct.setAccounts(accounts);
        List<UserProduct> products = new ArrayList<>();
        products.add(userProduct);
        bundleUserData.setProducts(products);
        patchDocument.setOp("remove");
        patchDocument.setPath("$.data.products[?(@.product=='')].accounts[?(@.pan=='123456789909089')]");
        patchDocument.setFrom("string");
        patchDocument.setValue(patchDocumentValue);
        patchDocumentValue.setData(bundleUserData);
        patchDocumentList.add(patchDocument);
        bundleUserPatch.setPatch(patchDocumentList);
        return bundleUserPatch;
    }




}
