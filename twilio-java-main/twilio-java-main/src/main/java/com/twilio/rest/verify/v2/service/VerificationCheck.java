/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Verify
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.verify.v2.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Objects;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class VerificationCheck extends Resource {

    private static final long serialVersionUID = 194586011367791L;

    public static VerificationCheckCreator creator(
        final String pathServiceSid
    ) {
        return new VerificationCheckCreator(pathServiceSid);
    }

    /**
     * Converts a JSON String into a VerificationCheck object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return VerificationCheck object represented by the provided JSON
     */
    public static VerificationCheck fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, VerificationCheck.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a VerificationCheck object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return VerificationCheck object represented by the provided JSON
     */
    public static VerificationCheck fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, VerificationCheck.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum Channel {
        SMS("sms"),
        CALL("call"),
        EMAIL("email"),
        WHATSAPP("whatsapp"),
        SNA("sna");

        private final String value;

        private Channel(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Channel forValue(final String value) {
            return Promoter.enumFromString(value, Channel.values());
        }
    }

    private final String sid;
    private final String serviceSid;
    private final String accountSid;
    private final String to;
    private final VerificationCheck.Channel channel;
    private final String status;
    private final Boolean valid;
    private final String amount;
    private final String payee;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final List<Map<String, Object>> snaAttemptsErrorCodes;

    @JsonCreator
    private VerificationCheck(
        @JsonProperty("sid") final String sid,
        @JsonProperty("service_sid") final String serviceSid,
        @JsonProperty("account_sid") final String accountSid,
        @JsonProperty("to") final String to,
        @JsonProperty("channel") final VerificationCheck.Channel channel,
        @JsonProperty("status") final String status,
        @JsonProperty("valid") final Boolean valid,
        @JsonProperty("amount") final String amount,
        @JsonProperty("payee") final String payee,
        @JsonProperty("date_created") final String dateCreated,
        @JsonProperty("date_updated") final String dateUpdated,
        @JsonProperty(
            "sna_attempts_error_codes"
        ) final List<Map<String, Object>> snaAttemptsErrorCodes
    ) {
        this.sid = sid;
        this.serviceSid = serviceSid;
        this.accountSid = accountSid;
        this.to = to;
        this.channel = channel;
        this.status = status;
        this.valid = valid;
        this.amount = amount;
        this.payee = payee;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.snaAttemptsErrorCodes = snaAttemptsErrorCodes;
    }

    public final String getSid() {
        return this.sid;
    }

    public final String getServiceSid() {
        return this.serviceSid;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getTo() {
        return this.to;
    }

    public final VerificationCheck.Channel getChannel() {
        return this.channel;
    }

    public final String getStatus() {
        return this.status;
    }

    public final Boolean getValid() {
        return this.valid;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getPayee() {
        return this.payee;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final List<Map<String, Object>> getSnaAttemptsErrorCodes() {
        return this.snaAttemptsErrorCodes;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VerificationCheck other = (VerificationCheck) o;

        return (
            Objects.equals(sid, other.sid) &&
            Objects.equals(serviceSid, other.serviceSid) &&
            Objects.equals(accountSid, other.accountSid) &&
            Objects.equals(to, other.to) &&
            Objects.equals(channel, other.channel) &&
            Objects.equals(status, other.status) &&
            Objects.equals(valid, other.valid) &&
            Objects.equals(amount, other.amount) &&
            Objects.equals(payee, other.payee) &&
            Objects.equals(dateCreated, other.dateCreated) &&
            Objects.equals(dateUpdated, other.dateUpdated) &&
            Objects.equals(snaAttemptsErrorCodes, other.snaAttemptsErrorCodes)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            sid,
            serviceSid,
            accountSid,
            to,
            channel,
            status,
            valid,
            amount,
            payee,
            dateCreated,
            dateUpdated,
            snaAttemptsErrorCodes
        );
    }
}