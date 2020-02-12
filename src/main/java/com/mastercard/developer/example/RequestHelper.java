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





}
