package ru.clevertec.library.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.clevertec.library.util.HibernateUtil;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BookRepositoryTest {
    private static Session session;

    @BeforeAll
    public static void initDatabaseSession1() {
        SessionFactory sessionFactory = HibernateUtil.buildFactory();
        session = (Session) Proxy.newProxyInstance(SessionFactory.class.getClassLoader(), new Class[]{Session.class},
                ((proxy, method, args) -> method.invoke(sessionFactory.getCurrentSession(), args)));
    }


    @Test
    void task221Criteria() {

        session.beginTransaction();
        BookRepository bookRepository = new BookRepository(session);
        List<Object[]> objects = bookRepository.task221Criteria();
        Object[] expected = {"Стихотворения и поэмы", "Поэзия", new BigDecimal("650.00")};
        Object[] actual = objects.getFirst();

        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
        assertEquals(expected[2], actual[2]);
        for(Object[] o: objects) {
            Object o1 = o[0];
            Object o2 = o[1];
            Object o3 = o[2];
            System.out.println(o1 + " " + o2 + " " + o3);
        }
        session.getTransaction().rollback();
    }
}