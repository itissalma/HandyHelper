/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.messaging;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link Body}
 */
public class BodyTest {
    @Test
    public void testElementWithParams() {
        Body elem = new Body.Builder("message").build();

        Assert.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Body>message</Body>",
            elem.toXml()
        );
    }

    @Test
    public void testXmlAttributesDeserialization() {
        final Body elem = new Body.Builder("message").build();

        Assert.assertEquals(
            Body.Builder.fromXml("<Body>message</Body>").build().toXml(),
            elem.toXml()
        );
    }
}