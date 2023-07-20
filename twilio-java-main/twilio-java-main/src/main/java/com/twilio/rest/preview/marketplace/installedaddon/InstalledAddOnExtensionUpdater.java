/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Preview
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.preview.marketplace.installedaddon;

import com.twilio.base.Updater;
import com.twilio.constant.EnumConstants;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class InstalledAddOnExtensionUpdater
    extends Updater<InstalledAddOnExtension> {

    private String pathInstalledAddOnSid;
    private String pathSid;
    private Boolean enabled;

    public InstalledAddOnExtensionUpdater(
        final String pathInstalledAddOnSid,
        final String pathSid,
        final Boolean enabled
    ) {
        this.pathInstalledAddOnSid = pathInstalledAddOnSid;
        this.pathSid = pathSid;
        this.enabled = enabled;
    }

    public InstalledAddOnExtensionUpdater setEnabled(final Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    @Override
    public InstalledAddOnExtension update(final TwilioRestClient client) {
        String path =
            "/marketplace/InstalledAddOns/{InstalledAddOnSid}/Extensions/{Sid}";

        path =
            path.replace(
                "{" + "InstalledAddOnSid" + "}",
                this.pathInstalledAddOnSid.toString()
            );
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());
        path = path.replace("{" + "Enabled" + "}", this.enabled.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.PREVIEW.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                "InstalledAddOnExtension update failed: Unable to connect to server"
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

        return InstalledAddOnExtension.fromJson(
            response.getStream(),
            client.getObjectMapper()
        );
    }

    private void addPostParams(final Request request) {
        if (enabled != null) {
            request.addPostParam("Enabled", enabled.toString());
        }
    }
}