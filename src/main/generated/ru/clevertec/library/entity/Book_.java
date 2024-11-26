package ru.clevertec.library.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(Book.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Book_ {

	public static final String AMOUNT = "amount";
	public static final String AUTHOR = "author";
	public static final String PRICE = "price";
	public static final String GENRE = "genre";
	public static final String TITLE = "title";
	public static final String BOOK_ID = "bookId";

	
	/**
	 * @see ru.clevertec.library.entity.Book#amount
	 **/
	public static volatile SingularAttribute<Book, Integer> amount;
	
	/**
	 * @see ru.clevertec.library.entity.Book#author
	 **/
	public static volatile SingularAttribute<Book, Author> author;
	
	/**
	 * @see ru.clevertec.library.entity.Book#price
	 **/
	public static volatile SingularAttribute<Book, BigDecimal> price;
	
	/**
	 * @see ru.clevertec.library.entity.Book#genre
	 **/
	public static volatile SingularAttribute<Book, Genre> genre;
	
	/**
	 * @see ru.clevertec.library.entity.Book#title
	 **/
	public static volatile SingularAttribute<Book, String> title;
	
	/**
	 * @see ru.clevertec.library.entity.Book
	 **/
	public static volatile EntityType<Book> class_;
	
	/**
	 * @see ru.clevertec.library.entity.Book#bookId
	 **/
	public static volatile SingularAttribute<Book, Long> bookId;

}

