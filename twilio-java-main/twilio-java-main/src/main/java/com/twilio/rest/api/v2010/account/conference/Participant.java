/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Api
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.api.v2010.account.conference;

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
import java.util.Objects;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Participant extends Resource {

    private static final long serialVersionUID = 78654773226378L;

    public static ParticipantCreator creator(
        final String pathConferenceSid,
        final com.twilio.type.Endpoint from,
        final com.twilio.type.Endpoint to
    ) {
        return new ParticipantCreator(pathConferenceSid, from, to);
    }

    public static ParticipantCreator creator(
        final String pathAccountSid,
        final String pathConferenceSid,
        final com.twilio.type.Endpoint from,
        final com.twilio.type.Endpoint to
    ) {
        return new ParticipantCreator(
            pathAccountSid,
            pathConferenceSid,
            from,
            to
        );
    }

    public static ParticipantDeleter deleter(
        final String pathConferenceSid,
        final String pathCallSid
    ) {
        return new ParticipantDeleter(pathConferenceSid, pathCallSid);
    }

    public static ParticipantDeleter deleter(
        final String pathAccountSid,
        final String pathConferenceSid,
        final String pathCallSid
    ) {
        return new ParticipantDeleter(
            pathAccountSid,
            pathConferenceSid,
            pathCallSid
        );
    }

    public static ParticipantFetcher fetcher(
        final String pathConferenceSid,
        final String pathCallSid
    ) {
        return new ParticipantFetcher(pathConferenceSid, pathCallSid);
    }

    public static ParticipantFetcher fetcher(
        final String pathAccountSid,
        final String pathConferenceSid,
        final String pathCallSid
    ) {
        return new ParticipantFetcher(
            pathAccountSid,
            pathConferenceSid,
            pathCallSid
        );
    }

    public static ParticipantReader reader(final String pathConferenceSid) {
        return new ParticipantReader(pathConferenceSid);
    }

    public static ParticipantReader reader(
        final String pathAccountSid,
        final String pathConferenceSid
    ) {
        return new ParticipantReader(pathAccountSid, pathConferenceSid);
    }

    public static ParticipantUpdater updater(
        final String pathConferenceSid,
        final String pathCallSid
    ) {
        return new ParticipantUpdater(pathConferenceSid, pathCallSid);
    }

    public static ParticipantUpdater updater(
        final String pathAccountSid,
        final String pathConferenceSid,
        final String pathCallSid
    ) {
        return new ParticipantUpdater(
            pathAccountSid,
            pathConferenceSid,
            pathCallSid
        );
    }

    /**
     * Converts a JSON String into a Participant object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Participant object represented by the provided JSON
     */
    public static Participant fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Participant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Participant object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Participant object represented by the provided JSON
     */
    public static Participant fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Participant.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public enum Status {
        QUEUED("queued"),
        CONNECTING("connecting"),
        RINGING("ringing"),
        CONNECTED("connected"),
        COMPLETE("complete"),
        FAILED("failed");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    private final String accountSid;
    private final String callSid;
    private final String label;
    private final String callSidToCoach;
    private final Boolean coaching;
    private final String conferenceSid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final Boolean endConferenceOnExit;
    private final Boolean muted;
    private final Boolean hold;
    private final Boolean startConferenceOnEnter;
    private final Participant.Status status;
    private final String uri;

    @JsonCreator
    private Participant(
        @JsonProperty("account_sid") final String accountSid,
        @JsonProperty("call_sid") final String callSid,
        @JsonProperty("label") final String label,
        @JsonProperty("call_sid_to_coach") final String callSidToCoach,
        @JsonProperty("coaching") final Boolean coaching,
        @JsonProperty("conference_sid") final String conferenceSid,
        @JsonProperty("date_created") final String dateCreated,
        @JsonProperty("date_updated") final String dateUpdated,
        @JsonProperty(
            "end_conference_on_exit"
        ) final Boolean endConferenceOnExit,
        @JsonProperty("muted") final Boolean muted,
        @JsonProperty("hold") final Boolean hold,
        @JsonProperty(
            "start_conference_on_enter"
        ) final Boolean startConferenceOnEnter,
        @JsonProperty("status") final Participant.Status status,
        @JsonProperty("uri") final String uri
    ) {
        this.accountSid = accountSid;
        this.callSid = callSid;
        this.label = label;
        this.callSidToCoach = callSidToCoach;
        this.coaching = coaching;
        this.conferenceSid = conferenceSid;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.endConferenceOnExit = endConferenceOnExit;
        this.muted = muted;
        this.hold = hold;
        this.startConferenceOnEnter = startConferenceOnEnter;
        this.status = status;
        this.uri = uri;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getCallSid() {
        return this.callSid;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getCallSidToCoach() {
        return this.callSidToCoach;
    }

    public final Boolean getCoaching() {
        return this.coaching;
    }

    public final String getConferenceSid() {
        return this.conferenceSid;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    public final Boolean getEndConferenceOnExit() {
        return this.endConferenceOnExit;
    }

    public final Boolean getMuted() {
        return this.muted;
    }

    public final Boolean getHold() {
        return this.hold;
    }

    public final Boolean getStartConferenceOnEnter() {
        return this.startConferenceOnEnter;
    }

    public final Participant.Status getStatus() {
        return this.status;
    }

    public final String getUri() {
        return this.uri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Participant other = (Participant) o;

        return (
            Objects.equals(accountSid, other.accountSid) &&
            Objects.equals(callSid, other.callSid) &&
            Objects.equals(label, other.label) &&
            Objects.equals(callSidToCoach, other.callSidToCoach) &&
            Objects.equals(coaching, other.coaching) &&
            Objects.equals(conferenceSid, other.conferenceSid) &&
            Objects.equals(dateCreated, other.dateCreated) &&
            Objects.equals(dateUpdated, other.dateUpdated) &&
            Objects.equals(endConferenceOnExit, other.endConferenceOnExit) &&
            Objects.equals(muted, other.muted) &&
            Objects.equals(hold, other.hold) &&
            Objects.equals(
                startConferenceOnEnter,
                other.startConferenceOnEnter
            ) &&
            Objects.equals(status, other.status) &&
            Objects.equals(uri, other.uri)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            accountSid,
            callSid,
            label,
            callSidToCoach,
            coaching,
            conferenceSid,
            dateCreated,
            dateUpdated,
            endConferenceOnExit,
            muted,
            hold,
            startConferenceOnEnter,
            status,
            uri
        );
    }
}
