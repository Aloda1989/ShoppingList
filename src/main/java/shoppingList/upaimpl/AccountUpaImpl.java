package shoppingList.upaimpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import shoppingList.entity.Account;
import shoppingList.userproductactions.AccountUpa;

public class AccountUpaImpl implements AccountUpa {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Account findAccount(String userName) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Account.class);
        criteria.add(Restrictions.eq("userName", userName));
        return (Account) criteria.uniqueResult();
    }
}
