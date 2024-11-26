package ru.clevertec.library.dao;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import ru.clevertec.library.entity.Book;
import ru.clevertec.library.entity.Book_;
import ru.clevertec.library.entity.Genre;
import ru.clevertec.library.entity.Genre_;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor

public class BookRepository {

    private final Session session;

    public void showResultList(List<Object[]> resultList) {
        for(Object[] o: resultList) {
            Object o1 = o[0];
            Object o2 = o[1];
            Object o3 = o[2];
            System.out.println(o1 + " " + o2 + " " + o3);
        }
    }

    public void task221() {
        List<Object[]> resultList = session.createNativeQuery("""
                SELECT title, name_genre, price
                FROM library.book
                JOIN library.genre USING (genre_id)
                WHERE amount>8
                ORDER BY price DESC; 
                       """).getResultList();
        showResultList(resultList);



    }
    /**  Вывести название, жанр и цену тех книг,
    количество которых больше 8, в отсортированном по убыванию цены виде. */
    public List<Object[]> task221Criteria() {
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        JpaCriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        Root<Book> root = criteria.from(Book.class);
        Join<Book, Genre> genres = root.join(Book_.genre);
        Path<String> genre = genres.get(Genre_.nameGenre);
        Path<String> title = root.get(Book_.title);
        Path<BigDecimal> price = root.get(Book_.price);
//        criteria.select(builder.array(title, price, genre));
        criteria.multiselect(title, genre, price);
        criteria.where(builder.gt(root.get(Book_.amount), 8));
        criteria.orderBy(builder.desc(root.get((Book_.price))));

        return session.createQuery(criteria).getResultList();
    }
}
