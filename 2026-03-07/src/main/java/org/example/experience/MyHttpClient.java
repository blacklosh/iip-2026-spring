package org.example.experience;

public interface MyHttpClient<REQUEST, RESPONSE> {

    void setUrl(String url);
    void setMethod(String method);
    void setPayload(REQUEST request);
    RESPONSE connect();

}
