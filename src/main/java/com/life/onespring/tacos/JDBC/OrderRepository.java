package com.life.onespring.tacos.JDBC;

import com.life.onespring.tacos.TacoOrder;

public interface OrderRepository {
    // repo abstraction for orders access

    TacoOrder save(TacoOrder order);

}
