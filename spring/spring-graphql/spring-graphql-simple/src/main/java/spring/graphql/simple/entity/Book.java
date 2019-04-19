package spring.graphql.simple.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by genghz on 18/3/29.
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Book extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5035704566414099645L;

	@Column(columnDefinition = "varchar(50)")
    private String title;

    private String isbn;

    private int pageCount;

    private long authorId;
}