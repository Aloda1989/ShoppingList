package shoppingList.userproductactions;

import shoppingList.model.CartInfo;
import shoppingList.model.OrderDetailInfo;
import shoppingList.model.OrderInfo;
import shoppingList.model.PaginationResult;

import java.util.List;

public interface OrderUpa {
    public void saveOrder(CartInfo cartInfo);

    public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage);

    public OrderInfo getOrderInfo(String orderId);

    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);
}
