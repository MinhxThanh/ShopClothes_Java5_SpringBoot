package edu.home.rest.controller;

import com.fasterxml.jackson.databind.JsonNode;
import edu.home.model.Order;
import edu.home.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "rest")
public class OrderRestController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "orders")
    public Order create(@RequestBody JsonNode orderJsonData){
        return orderService.create(orderJsonData);
    }
}
