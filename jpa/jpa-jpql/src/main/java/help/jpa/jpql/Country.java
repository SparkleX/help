package help.jpa.jpql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity(name="Country")
@Table(name="OCNY")
@Data
public class Country {
	@Id @Column Integer id;
}
