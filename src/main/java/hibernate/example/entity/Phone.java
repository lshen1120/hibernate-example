package hibernate.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by SL on 2016/5/4.
 */
@Entity
public class Phone {

    @Id
    @GeneratedValue
    Long id;

    /**
     * @return {@link #id}
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id {@link  #id}
     * @return
     */
    public Phone setId(Long id) {
        this.id = id;
        return this;
    }
}
