/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.cdi;

import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.store.Item;
import org.apache.camel.cdi.store.ShoppingBean;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.Test;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class InjectCamelAnnotationsTest extends CdiContextTestSupport {

    @EndpointInject(uri="direct:inject")
    Endpoint directInjectEndpoint;

    @EndpointInject(uri="mock:result")
    MockEndpoint mockResultendpoint;

    @Produce(uri = "mock:result")
    ProducerTemplate myProducer;

    @Test
    public void beanShouldBeInjected() throws InterruptedException {
        mockResultendpoint.expectedMessageCount(1);
        myProducer.sendBody("direct:inject", "hello");

        assertMockEndpointsSatisfied();

        Exchange exchange = mockResultendpoint.getExchanges().get(0);
        List<?> results = exchange.getIn().getBody(List.class);
        List<Item> expected = itemsExpected();
        assertNotNull(results);
        assertNotNull(expected);
        assertEquals(expected.size(), results.size());
        assertEquals(expected, results);
    }

    private List<Item> itemsExpected() {
        List<Item> products = new ArrayList<Item>();
        for (int i = 1; i < 10; i++) {
            products.add(new Item("Item-" + i, 1500L * i));
        }
        return products;
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from(directInjectEndpoint)
                    .beanRef("shoppingBean", "listAllProducts")
                    .to(mockResultendpoint);
            }
        };
    }
}
