package com.life.onespring.tacos.JDBC;

import com.life.onespring.tacos.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder order);

}
