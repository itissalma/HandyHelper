/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Sync
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.sync.v1.service.syncmap;

import com.twilio.base.Creator;
import com.twilio.constant.EnumConstants;
import com.twilio.converter.Converter;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.util.Map;
import java.util.Map;

public class SyncMapItemCreator extends Creator<SyncMapItem> {

    private String pathServiceSid;
    private String pathMapSid;
    private String key;
    private Map<String, Object> data;
    private Integer ttl;
    private Integer itemTtl;
    private Integer collectionTtl;

    public SyncMapItemCreator(
        final String pathServiceSid,
        final String pathMapSid,
        final String key,
        final Map<String, Object> data
    ) {
        this.pathServiceSid = pathServiceSid;
        this.pathMapSid = pathMapSid;
        this.key = key;
        this.data = data;
    }

    public SyncMapItemCreator setKey(final String key) {
        this.key = key;
        return this;
    }

    public SyncMapItemCreator setData(final Map<String, Object> data) {
        this.data = data;
        return this;
    }

    public SyncMapItemCreator setTtl(final Integer ttl) {
        this.ttl = ttl;
        return this;
    }

    public SyncMapItemCreator setItemTtl(final Integer itemTtl) {
        this.itemTtl = itemTtl;
        return this;
    }

    public SyncMapItemCreator setCollectionTtl(final Integer collectionTtl) {
        this.collectionTtl = collectionTtl;
        return this;
    }

    @Override
    public SyncMapItem create(final TwilioRestClient client) {
        String path = "/v1/Services/{ServiceSid}/Maps/{MapSid}/Items";

        path =
            path.replace(
                "{" + "ServiceSid" + "}",
                this.pathServiceSid.toString()
            );
        path = path.replace("{" + "MapSid" + "}", this.pathMapSid.toString());
        path = path.replace("{" + "Key" + "}", this.key.toString());
        path = path.replace("{" + "Data" + "}", this.data.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.SYNC.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                "SyncMapItem creation failed: Unable to connect to server"
            );
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(
                response.getStream(),
                client.getObjectMapper()
            );
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return SyncMapItem.fromJson(
            response.getStream(),
            client.getObjectMapper()
        );
    }

    private void addPostParams(final Request request) {
        if (key != null) {
            request.addPostParam("Key", key);
        }
        if (data != null) {
            request.addPostParam("Data", Converter.mapToJson(data));
        }
        if (ttl != null) {
            request.addPostParam("Ttl", ttl.toString());
        }
        if (itemTtl != null) {
            request.addPostParam("ItemTtl", itemTtl.toString());
        }
        if (collectionTtl != null) {
            request.addPostParam("CollectionTtl", collectionTtl.toString());
        }
    }
}
