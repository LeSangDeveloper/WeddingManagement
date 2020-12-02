package Module.WeddingManagement.Repository.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Customers")
@NamedQueries({
    @NamedQuery(name = CustomerEntity.QUERY_FIND_BY_ID, query = "SELECT i from CustomerEntity i where i.customerId = :customerId"),
        @NamedQuery(name = CustomerEntity.QUERY_FIND_ALL_CUSTOMERS, query = "SELECT i from CustomerEntity i")
})
public class CustomerEntity {
    public static final String QUERY_FIND_ALL_CUSTOMERS = "CustomerEntity.FindAll";
    public static final String QUERY_FIND_BY_ID = "ItemEntity.FindById";

    public CustomerEntity(long customerId, String name, String phone, String address)
    {

    }

    public CustomerEntity(int customerId, String name, String phone, String address) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Basic
    private String name;

    @Basic
    private String phone;

    @Basic
    private String address;

    public CustomerEntity(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
