/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Conversations
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.conversations.v1.service.configuration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Map;
import java.util.Objects;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Notification extends Resource {

    private static final long serialVersionUID = 46010876689651L;

    public static NotificationFetcher fetcher(final String pathChatServiceSid) {
        return new NotificationFetcher(pathChatServiceSid);
    }

    public static NotificationUpdater updater(final String pathChatServiceSid) {
        return new NotificationUpdater(pathChatServiceSid);
    }

    /**
     * Converts a JSON String into a Notification object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Notification object represented by the provided JSON
     */
    public static Notification fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Notification.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Notification object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Notification object represented by the provided JSON
     */
    public static Notification fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Notification.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String chatServiceSid;
    private final Map<String, Object> newMessage;
    private final Map<String, Object> addedToConversation;
    private final Map<String, Object> removedFromConversation;
    private final Boolean logEnabled;
    private final URI url;

    @JsonCreator
    private Notification(
        @JsonProperty("account_sid") final String accountSid,
        @JsonProperty("chat_service_sid") final String chatServiceSid,
        @JsonProperty("new_message") final Map<String, Object> newMessage,
        @JsonProperty(
            "added_to_conversation"
        ) final Map<String, Object> addedToConversation,
        @JsonProperty(
            "removed_from_conversation"
        ) final Map<String, Object> removedFromConversation,
        @JsonProperty("log_enabled") final Boolean logEnabled,
        @JsonProperty("url") final URI url
    ) {
        this.accountSid = accountSid;
        this.chatServiceSid = chatServiceSid;
        this.newMessage = newMessage;
        this.addedToConversation = addedToConversation;
        this.removedFromConversation = removedFromConversation;
        this.logEnabled = logEnabled;
        this.url = url;
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getChatServiceSid() {
        return this.chatServiceSid;
    }

    public final Map<String, Object> getNewMessage() {
        return this.newMessage;
    }

    public final Map<String, Object> getAddedToConversation() {
        return this.addedToConversation;
    }

    public final Map<String, Object> getRemovedFromConversation() {
        return this.removedFromConversation;
    }

    public final Boolean getLogEnabled() {
        return this.logEnabled;
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

        Notification other = (Notification) o;

        return (
            Objects.equals(accountSid, other.accountSid) &&
            Objects.equals(chatServiceSid, other.chatServiceSid) &&
            Objects.equals(newMessage, other.newMessage) &&
            Objects.equals(addedToConversation, other.addedToConversation) &&
            Objects.equals(
                removedFromConversation,
                other.removedFromConversation
            ) &&
            Objects.equals(logEnabled, other.logEnabled) &&
            Objects.equals(url, other.url)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            accountSid,
            chatServiceSid,
            newMessage,
            addedToConversation,
            removedFromConversation,
            logEnabled,
            url
        );
    }
}
