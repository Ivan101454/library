package ru.clevertec.library;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.clevertec.library.dao.BookRepository;
import ru.clevertec.library.entity.Author;
import ru.clevertec.library.entity.Book;
import ru.clevertec.library.entity.Genre;
import ru.clevertec.library.util.HibernateUtil;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Session session = initDatabaseSession();
        session.beginTransaction();
        BookRepository bookRepository = new BookRepository(session);
//        bookRepository.task221();
        bookRepository.task221Criteria();
        session.getTransaction().commit();




//        Genre genre = Genre.builder().nameGenre("Роман").build();
//        Author author = Author.builder().nameAuthor("Булгаков М.А.").build();
//        Book book = Book.builder().title("Мастер и Маргарита").author(author).genre(genre).price(BigDecimal.valueOf(670.99)).amount(3).build();
//        try (SessionFactory sessionFactory = HibernateUtil.buildFactory()) {
//            sessionFactory.inTransaction(session -> {
//                session.persist(genre);
//                session.persist(author);
//                session.persist(book);
//            });
//        }



//        try(Session session = initDatabaseSession()) {
//            session.beginTransaction();
//            session.persist(genre);
//            session.getTransaction().commit();
//        }
//        try(SessionFactory sessionFactory = HibernateUtil.buildFactory();
//            Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//            session.persist(author);
//            session.getTransaction().commit();
//        }
    }
    private static Session initDatabaseSession() {
        SessionFactory sessionFactory = HibernateUtil.buildFactory();
        return (Session) Proxy.newProxyInstance(SessionFactory.class.getClassLoader(), new Class[]{Session.class},
                ((proxy, method, args) -> method.invoke(sessionFactory.getCurrentSession(), args)));
    }
}