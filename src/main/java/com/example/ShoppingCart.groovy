package com.example

import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

import java.util.ArrayList
import java.util.List

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class ShoppingCart {
    List<String> orders = new ArrayList<>()

    void addItem(String name, int qty) {
        orders.add("order. Item: $name qty: $qty")
    }

    String checkout() {
        String msg = placeOrders()
        orders.clear()
        msg
    }

    String placeOrders() {
        "${orders.size()} orders placed"
    }
}