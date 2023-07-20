/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Ip_messaging
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.ipmessaging.v1.service.channel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Objects;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Member extends Resource {

    private static final long serialVersionUID = 102757132179124L;

    public static MemberCreator creator(
        final String pathServiceSid,
        final String pathChannelSid,
        final String identity
    ) {
        return new MemberCreator(pathServiceSid, pathChannelSid, identity);
    }

    public static MemberDeleter deleter(
        final String pathServiceSid,
        final String pathChannelSid,
        final String pathSid
    ) {
        return new MemberDeleter(pathServiceSid, pathChannelSid, pathSid);
    }

    public static MemberFetcher fetcher(
        final String pathServiceSid,
        final String pathChannelSid,
        final String pathSid
    ) {
        return new MemberFetcher(pathServiceSid, pathChannelSid, pathSid);
    }

    public static MemberReader reader(
        final String pathServiceSid,
        final String pathChannelSid
    ) {
        return new MemberReader(pathServiceSid, pathChannelSid);
    }

    public static MemberUpdater updater(
        final String pathServiceSid,
        final String pathChannelSid,
        final String pathSid
    ) {
        return new MemberUpdater(pathServiceSid, pathChannelSid, pathSid);
    }

    /**
     * Converts a JSON String into a Member object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Member object represented by the provided JSON
     */
    public static Member fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Member.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Member object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Member object represented by the provided JSON
     */
    public static Member fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Member.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String channelSid;
    private final String serviceSid;
    private final String identity;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final String roleSid;
    private final Integer lastConsumedMessageIndex;
    private final ZonedDateTime lastConsumptionTimestamp;
    private final URI url;

    @JsonCreator
    private Member(
        @JsonProperty("sid") final String sid,
        @JsonProperty("account_sid") final String accountSid,
        @JsonProperty("channel_sid") final String channelSid,
        @JsonProperty("service_sid") final String serviceSid,
        @JsonProperty("identity") final String identity,
        @JsonProperty("date_created") final String dateCreated,
        @JsonProperty("date_updated") final String dateUpdated,
        @JsonProperty("role_sid") final String roleSid,
        @JsonProperty(
            "last_consumed_message_index"
        ) final Integer lastConsumedMessageIndex,
        @JsonProperty(
            "last_consumption_timestamp"
        ) final String lastConsumptionTimestamp,
        @JsonProperty("url") final URI url
    ) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.channelSid = channelSid;
        this.serviceSid = serviceSid;
        this.identity = identity;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.roleSid = roleSid;
        this.lastConsumedMessageIndex = lastConsumedMessageIndex;
        this.lastConsumptionTimestamp =
            DateConverter.iso8601DateTimeFromString(lastConsumptionTimestamp);
        this.url = url;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getChannelSid() {
        return this.channelSid;
    }

    public final String getServiceSid() {
        return this.serviceSid;
    }

    public final String getIdentity() {
        return this.identity;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final String getRoleSid() {
        return this.roleSid;
    }

    public final Integer getLastConsumedMessageIndex() {
        return this.lastConsumedMessageIndex;
    }

    public final ZonedDateTime getLastConsumptionTimestamp() {
        return this.lastConsumptionTimestamp;
    }

    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Member other = (Member) o;

        return (
            Objects.equals(sid, other.sid) &&
            Objects.equals(accountSid, other.accountSid) &&
            Objects.equals(channelSid, other.channelSid) &&
            Objects.equals(serviceSid, other.serviceSid) &&
            Objects.equals(identity, other.identity) &&
            Objects.equals(dateCreated, other.dateCreated) &&
            Objects.equals(dateUpdated, other.dateUpdated) &&
            Objects.equals(roleSid, other.roleSid) &&
            Objects.equals(
                lastConsumedMessageIndex,
                other.lastConsumedMessageIndex
            ) &&
            Objects.equals(
                lastConsumptionTimestamp,
                other.lastConsumptionTimestamp
            ) &&
            Objects.equals(url, other.url)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            sid,
            accountSid,
            channelSid,
            serviceSid,
            identity,
            dateCreated,
            dateUpdated,
            roleSid,
            lastConsumedMessageIndex,
            lastConsumptionTimestamp,
            url
        );
    }
}