/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Events
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.events.v1.sink;

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
import java.util.Objects;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class SinkTest extends Resource {

    private static final long serialVersionUID = 233814002700195L;

    public static SinkTestCreator creator(final String pathSid) {
        return new SinkTestCreator(pathSid);
    }

    /**
     * Converts a JSON String into a SinkTest object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return SinkTest object represented by the provided JSON
     */
    public static SinkTest fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, SinkTest.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a SinkTest object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return SinkTest object represented by the provided JSON
     */
    public static SinkTest fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, SinkTest.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String result;

    @JsonCreator
    private SinkTest(@JsonProperty("result") final String result) {
        this.result = result;
    }

    public final String getResult() {
        return this.result;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SinkTest other = (SinkTest) o;

        return Objects.equals(result, other.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}