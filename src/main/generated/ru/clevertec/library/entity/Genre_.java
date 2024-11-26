package ru.clevertec.library.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Genre.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Genre_ {

	public static final String GENRE_ID = "genreId";
	public static final String NAME_GENRE = "nameGenre";

	
	/**
	 * @see ru.clevertec.library.entity.Genre#genreId
	 **/
	public static volatile SingularAttribute<Genre, Long> genreId;
	
	/**
	 * @see ru.clevertec.library.entity.Genre#nameGenre
	 **/
	public static volatile SingularAttribute<Genre, String> nameGenre;
	
	/**
	 * @see ru.clevertec.library.entity.Genre
	 **/
	public static volatile EntityType<Genre> class_;

}

