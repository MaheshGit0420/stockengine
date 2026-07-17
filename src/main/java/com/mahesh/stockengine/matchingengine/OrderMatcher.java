package com.mahesh.stockengine.matchingengine;

import com.mahesh.stockengine.domain.Order;
import com.mahesh.stockengine.dto.OrderRequestDTO;
import com.mahesh.stockengine.enums.OrderType;
import com.mahesh.stockengine.messaging.events.OrderCreatedEvent;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Queue;

@Component
public class OrderMatcher {

    private Map<String, OrderBook> books;

    public OrderMatcher(Map<String, OrderBook> books) {
        this.books = books;
    }
    public void process(OrderRequestDTO event) {

        String sym = event.symbol();
        String side  = event.side().toString();
        OrderBook book = books.computeIfAbsent(sym, OrderBook::new);


        if("BUY".equals(side)) {

            NavigableMap<Double, Queue<OrderRequestDTO>> sellBook = book.getSellBook();
            if(event.type() == OrderType.MARKET) {
                // keep checking for that top sell order/orders until quantity satisfies.
                long stkToBuy = event.quantity();

                while(stkToBuy != 0) {

                    Map.Entry<Double, Queue<OrderRequestDTO>> firstEntry = sellBook.firstEntry();
                    Queue<OrderRequestDTO> curOrdQue = firstEntry.getValue();
                    Iterator<OrderRequestDTO> iter = curOrdQue.iterator();
                    while(stkToBuy>0 && iter.hasNext()) {

                        // stkToBuy -= iter.
                    }
                    // take out the first one, process the events. if still left put back to treemap.
                }

                boolean flag = false;

                while(!flag) {

                    // if()
                }
            }
            else if(event.type() == OrderType.LIMIT) {

                // stop when sell order/orders price > limit. Partial order if not found enough buys.
            }
        }
        else if("SELL".equals(side)) {

            if(event.type() == OrderType.LIMIT) {

                // keep checking for that top buy order/orders until quantity satisfies.
            }
            else if(event.type() == OrderType.MARKET) {

                // stop when buy order/orders price < limit. Partial order if not found enough buys.
            }
        }
        // OrderCreatedEvent[orderId=48879bd6-05d6-4e27-8c3d-d655a4cc7e29, clientId=C1, symbol=GOOG, side=BUY, type=LIMIT, quantity=10, price=180, createdAt=2026-06-11T16:53:21.412546Z]
        // System.out.println(event);


    }
}
