package ru.clevertec.library.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Author.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Author_ {

	public static final String NAME_AUTHOR = "nameAuthor";
	public static final String AUTHOR_ID = "authorId";

	
	/**
	 * @see ru.clevertec.library.entity.Author#nameAuthor
	 **/
	public static volatile SingularAttribute<Author, String> nameAuthor;
	
	/**
	 * @see ru.clevertec.library.entity.Author#authorId
	 **/
	public static volatile SingularAttribute<Author, Long> authorId;
	
	/**
	 * @see ru.clevertec.library.entity.Author
	 **/
	public static volatile EntityType<Author> class_;

}

