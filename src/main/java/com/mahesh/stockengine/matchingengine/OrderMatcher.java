package com.mahesh.stockengine.matchingengine;

import com.mahesh.stockengine.domain.Order;
import com.mahesh.stockengine.messaging.events.OrderCreatedEvent;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Queue;

@Component
public class OrderMatcher {

    private Map<String, OrderBook> books;

    public OrderMatcher(Map<String, OrderBook> books) {
        this.books = books;
    }
    public void process(OrderCreatedEvent event) {

        String sym = event.symbol();
        String side  = event.side();
        OrderBook book = books.computeIfAbsent(sym, OrderBook::new);


        if("BUY".equals(side)) {

            NavigableMap<Double, Queue<Order>> buyBook = book.getSellBook();
            if(event.type() == "MARKET") {
                // keep checking for that top sell order/orders until quantity satisfies.

                boolean flag = false;

                while(!flag) {

                    // if()
                }
            }
            else if(event.type() == "LIMIT") {

                // stop when sell order/orders price > limit. Partial order if not found enough buys.
            }
        }
        else if("SELL".equals(side)) {

            if(event.type() == "MARKET") {

                // keep checking for that top buy order/orders until quantity satisfies.
            }
            else if(event.type() == "LIMIT") {

                // stop when buy order/orders price < limit. Partial order if not found enough buys.
            }
        }
        // OrderCreatedEvent[orderId=48879bd6-05d6-4e27-8c3d-d655a4cc7e29, clientId=C1, symbol=GOOG, side=BUY, type=LIMIT, quantity=10, price=180, createdAt=2026-06-11T16:53:21.412546Z]
        // System.out.println(event);


    }
}
