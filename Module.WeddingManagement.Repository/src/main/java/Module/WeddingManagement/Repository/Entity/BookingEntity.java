package Module.WeddingManagement.Repository.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class BookingEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    private CustomerEntity customer;

    @OneToOne
    private EmployeeEntity employee;

    @OneToOne
    private MenuEntity menu;

    @OneToOne
    private HallEntity hall;

    @ManyToMany
    private List<ServiceEntity> services;

}
