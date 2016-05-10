package hibernate.example.entity;

import javax.persistence.*;

/**
 * Created by SL on 2016/5/4.
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue
    Long id;

    String name;

    @Version
    int version;

    @JoinColumn(name = "department_id")
    @ManyToOne
    Department department;

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
    public Employee setId(Long id) {
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
    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @return {@link #department}
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * @param department {@link  #department}
     * @return
     */
    public Employee setDepartment(Department department) {
        this.department = department;
        return this;
    }

    /**
     * @return {@link #version}
     */
    public int getVersion() {
        return version;
    }

    /**
     * @param version {@link  #version}
     * @return
     */
    public Employee setVersion(int version) {
        this.version = version;
        return this;
    }
}
