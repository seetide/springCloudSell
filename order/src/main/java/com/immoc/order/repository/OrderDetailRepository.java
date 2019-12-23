package com.immoc.order.repository;

import com.immoc.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by haitao on 12/23/19
 *
 * @project: order
 */

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
