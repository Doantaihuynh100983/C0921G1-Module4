package vn.codegym.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import vn.codegym.context.ConnectionUtil;
import vn.codegym.model.Customer;

import javax.annotation.PreDestroy;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository {

    Session session = null;
    Transaction transaction = null;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            customerList = session.createQuery("FROM  Customer").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return customerList;
    }


    @Override
    public void save(Customer customer) {
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.createNativeQuery("INSERT INTO Customer (name,age) VALUE (?,?)").setParameter(1, customer.getName())
                    .setParameter(2, customer.getAge()).executeUpdate();
//            session.save(customer);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(int id) {
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.createNativeQuery("DELETE FROM Customer WHERE id = ?").setParameter(1, id).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }

    }

    // từ thêm xóa hiển thị list dùng cách query thuần
    //hàm hiển thị theo id là dùng JPA để làm

    @Override
    public Customer findById(int id) {
        TypedQuery<Customer> typedQuery = ConnectionUtil.entityManager.createQuery("select c from Customer c where  c.id=:id", Customer.class)
                .setParameter("id", id);
        try {
            return typedQuery.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}

