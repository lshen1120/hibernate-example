package hibernate.example.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by SL on 2016/5/4.
 */
@Entity
public class Department {

    @GeneratedValue
    @Id
    Long id;

    String name;

    @OneToMany(mappedBy = "department")
    Set<Employee> employees;

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
    public Department setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * @param name {@link  #name}
     * @return
     */
    public Department setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @return {@link #employees}
     */
    public Set<Employee> getEmployees() {
        return employees;
    }

    /**
     * @param employees {@link  #employees}
     * @return
     */
    public Department setEmployees(Set<Employee> employees) {
        this.employees = employees;
        return this;
    }
}
