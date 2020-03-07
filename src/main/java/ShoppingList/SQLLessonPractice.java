package ShoppingList;

public class SQLLessonPractice {
//    -- Scenario 5
//    select *
//    from xx_orders
//    where status = 'ORDERED'
//    union all
//    select *
//    from xx_orders
//    where status = 'SHIPPED';
//
//-- Scenario 6
//    select order_id,
//    CASE when total_amount < 100 THEN 'CHEAP'
//    when total_amount >100 and total_amount < 400 THEN 'MEDIUM'
//            else 'EXPENSIVE'
//    END amount_description,total_amount
//    from xx_orders
//    order by order_id asc;
//
//-- Scenario 7
//    select (select customer_name from xx_customers where customer_id = xo.customer_id) customer_name, xo.order_number
//    from xx_orders xo;
//
//    select *
//    from xx_customers
//    where customer_id in (select customer_id from xx_orders);
}
