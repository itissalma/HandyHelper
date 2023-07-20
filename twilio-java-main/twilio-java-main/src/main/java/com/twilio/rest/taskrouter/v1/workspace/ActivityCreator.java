/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Taskrouter
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.taskrouter.v1.workspace;

import com.twilio.base.Creator;
import com.twilio.constant.EnumConstants;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class ActivityCreator extends Creator<Activity> {

    private String pathWorkspaceSid;
    private String friendlyName;
    private Boolean available;

    public ActivityCreator(
        final String pathWorkspaceSid,
        final String friendlyName
    ) {
        this.pathWorkspaceSid = pathWorkspaceSid;
        this.friendlyName = friendlyName;
    }

    public ActivityCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public ActivityCreator setAvailable(final Boolean available) {
        this.available = available;
        return this;
    }

    @Override
    public Activity create(final TwilioRestClient client) {
        String path = "/v1/Workspaces/{WorkspaceSid}/Activities";

        path =
            path.replace(
                "{" + "WorkspaceSid" + "}",
                this.pathWorkspaceSid.toString()
            );
        path =
            path.replace(
                "{" + "FriendlyName" + "}",
                this.friendlyName.toString()
            );

        Request request = new Request(
            HttpMethod.POST,
            Domains.TASKROUTER.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                "Activity creation failed: Unable to connect to server"
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

        return Activity.fromJson(
            response.getStream(),
            client.getObjectMapper()
        );
    }

    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }
        if (available != null) {
            request.addPostParam("Available", available.toString());
        }
    }
}
