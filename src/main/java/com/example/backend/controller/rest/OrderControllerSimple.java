package com.example.backend.controller.rest;

import com.example.backend.dto.OrderDTO;
import com.example.backend.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@RestController
@RequestMapping("/order")
public class OrderControllerSimple {
  /*
  1 - Products in an order -- /order/{orderid}/products - GET
  2 - Place an order -- /order/create  - POST  - Req body - Order data
  3 - View a placed order -- /order/{orderid} - GET
  4 - Edit an order -- /order/{orderid}/edit - PATCH - Req body : Updated data
  5 - Cancel an order -- /order/{orderid}/cancel - DELETE/PUT
  6 - Invoice of an order -- /order/{orderid}/invoice - GET
  7 - Order history -- /order/history -- GET
   */

    @Autowired
    private TreeMap<Integer, OrderDTO> orderDatabase;

    @GetMapping("/{orderid}/products")
    public List<ProductDTO> getProductListInOrder(@PathVariable("orderid") final Integer orderId) {
        return orderDatabase.get(orderId)
                            .getProductList();
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDTO createOrder(@RequestBody final OrderDTO orderData) {
        orderData.setId(orderDatabase.lastKey() + 1);
        orderDatabase.put(orderData.getId(), orderData);
        return orderDatabase.get(orderData.getId());
    }

    @GetMapping("/{orderid}")
    public OrderDTO getOrderDetails(@PathVariable("orderid") final Integer orderId) {
        return orderDatabase.get(orderId);
    }

    @GetMapping("/history")
    public List<OrderDTO> getOrderHistory() {
        return new ArrayList<>(orderDatabase.values());
    }

}
