package hibernate.example.entity.base;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by shenli on 16/5/10.
 */
@MappedSuperclass
public class IdKeyEntity {

    @GeneratedValue
    @Id
    Long id;


    public Long getId() {
        return id;
    }

    public IdKeyEntity setId(Long id) {
        this.id = id;
        return this;
    }
}
