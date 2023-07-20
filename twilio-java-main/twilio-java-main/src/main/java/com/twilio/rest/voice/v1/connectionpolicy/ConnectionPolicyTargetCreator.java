/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Voice
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.voice.v1.connectionpolicy;

import com.twilio.base.Creator;
import com.twilio.constant.EnumConstants;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.net.URI;
import java.net.URI;

public class ConnectionPolicyTargetCreator
    extends Creator<ConnectionPolicyTarget> {

    private String pathConnectionPolicySid;
    private URI target;
    private String friendlyName;
    private Integer priority;
    private Integer weight;
    private Boolean enabled;

    public ConnectionPolicyTargetCreator(
        final String pathConnectionPolicySid,
        final URI target
    ) {
        this.pathConnectionPolicySid = pathConnectionPolicySid;
        this.target = target;
    }

    public ConnectionPolicyTargetCreator setTarget(final URI target) {
        this.target = target;
        return this;
    }

    public ConnectionPolicyTargetCreator setTarget(final String target) {
        return setTarget(Promoter.uriFromString(target));
    }

    public ConnectionPolicyTargetCreator setFriendlyName(
        final String friendlyName
    ) {
        this.friendlyName = friendlyName;
        return this;
    }

    public ConnectionPolicyTargetCreator setPriority(final Integer priority) {
        this.priority = priority;
        return this;
    }

    public ConnectionPolicyTargetCreator setWeight(final Integer weight) {
        this.weight = weight;
        return this;
    }

    public ConnectionPolicyTargetCreator setEnabled(final Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    @Override
    public ConnectionPolicyTarget create(final TwilioRestClient client) {
        String path = "/v1/ConnectionPolicies/{ConnectionPolicySid}/Targets";

        path =
            path.replace(
                "{" + "ConnectionPolicySid" + "}",
                this.pathConnectionPolicySid.toString()
            );
        path = path.replace("{" + "Target" + "}", this.target.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.VOICE.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                "ConnectionPolicyTarget creation failed: Unable to connect to server"
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

        return ConnectionPolicyTarget.fromJson(
            response.getStream(),
            client.getObjectMapper()
        );
    }

    private void addPostParams(final Request request) {
        if (target != null) {
            request.addPostParam("Target", target.toString());
        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }
        if (priority != null) {
            request.addPostParam("Priority", priority.toString());
        }
        if (weight != null) {
            request.addPostParam("Weight", weight.toString());
        }
        if (enabled != null) {
            request.addPostParam("Enabled", enabled.toString());
        }
    }
}
