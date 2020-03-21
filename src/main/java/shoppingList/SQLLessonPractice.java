package shoppingList;

public class SQLLessonPractice {
//-- Scenario 9
//    select wh.warehouse_name, cus.customer_name, od.*
//    from xx_warehouse wh,
//    xx_customers cus,
//    xx_orders od
//    where cus.customer_id = od.customer_id
//    and od.warehouse_id = wh.warehouse_id;
//
//    select od.*, cus.customer_name, wh.warehouse_name
//    from xx_orders od
//    inner join xx_customers cus on (od.customer_id = cus.customer_id)
//    inner join xx_warehouse wh on (od.warehouse_id = wh.warehouse_id);
//
//    select od.order_number, ol.*
//    from xx_orders od
//    inner join xx_order_lines ol on (od.order_id = ol.line_id)
//    where od.status = 'ORDERED';
//
//    select od.order_number, ol.*
//    from xx_orders od, xx_order_lines ol
//    where od.order_id = ol.line_id
//    and od.status = 'ORDERED';
//
// -- Scenario 10
//    select cn.customer_name, onu.order_number, wh.warehouse_name
//    from xx_customers cn,
//    xx_orders onu,
//    xx_warehouse wh
//    where cn.customer_id = onu.customer_id(+)
//    and  onu.warehouse_id = wh.warehouse_id(+)
//    order by cn.customer_name;
//
//    select cus.customer_name, onu.order_number, wn.warehouse_name
//    from xx_customers cus
//    LEFT JOIN xx_orders onu ON (cus.customer_id = onu.customer_id)
//    LEFT JOIN xx_warehouse wn ON (onu.warehouse_id = wn.warehouse_id)
//    ORDER BY cus.customer_name;
//
//-- Scenario 11
//    select cus.customer_name, ord.order_number, wn.warehouse_name
//    from xx_customers cus,
//    xx_orders ord,
//    xx_warehouse wn
//    where ord.customer_id(+) = cus.customer_id
//    and  ord.warehouse_id = wn.warehouse_id(+)
//    order by cus.customer_name;
//
//    select cus.customer_name, ord.order_number, wn.warehouse_name
//    from xx_orders ord
//    RIGHT JOIN xx_customers cus ON (cus.customer_id = ord.customer_id)
//    LEFT JOIN xx_warehouse wn ON (ord.warehouse_id = wn.warehouse_id)
//    ORDER BY cus.customer_name;
//
//-- Scenario 12
//    ALTER TABLE xx_customers
//    ADD active_flag VARCHAR2(1);
//
//    select *
//    from xx_customers
//
//    update xx_customers cus
//    set cus.active_flag = 'Y'
//    where EXISTS
//            (
//                    select 1
//                    from xx_orders
//                    where customer_id = cus.customer_id
//            );
//
//    COMMIT;
//
//-- Scenario 13
//
//    ALTER table xx_customers
//    ADD DISCOUNT number;
//
//
//    UPDATE xx_customers cus
//    set discount = 20
//    where EXISTS
//            (
//                    select 1
//                    from xx_orders
//                    where customer_id = cus.customer_id
//                    and status = 'SHIPPED'
//            );
//
//
//    UPDATE xx_customers
//    set discount = 0
//    where discount is null;
//
//
//    COMMIT;
//
//
//    select *
//    from xx_customers;
//
//
//    select cus.customer_name, onu.order_number, onu.total_amount,
//    CASE
//    WHEN (cus.discount = 0 ) THEN onu.total_amount
//    ELSE onu.total_amount * ((100 - cus.discount) / 100)
//    END with_discount,
//    cus.discount
//    from xx_orders onu,
//    xx_customers cus
//    where onu.customer_id = cus.customer_id;
//
//
//    select cus.customer_name, onu.order_number, onu.total_amount,
//    DECODE(cus.discount,0, onu.total_amount, onu.total_amount * ((100 - cus.discount) / 100)) with_discount,
//    cus.discount
//    from xx_orders onu,
//    xx_customers cus
//    where onu.customer_id = cus.customer_id;
//
//-- Scenario 14
//
//    select customer_id
//    from xx_customers
//    MINUS
//    select customer_id
//    from xx_orders;
}
