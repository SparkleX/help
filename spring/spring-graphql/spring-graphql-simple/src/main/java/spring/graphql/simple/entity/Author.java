package spring.graphql.simple.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by genghz on 18/3/27.
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Author extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5994791645423280656L;

	@Column(columnDefinition = "varchar(50)")
    private String firstName;

    @Column(columnDefinition = "varchar(50)")
    private String lastName;
}
