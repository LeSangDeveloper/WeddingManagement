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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;

    @Basic
    private String name;

    @Basic
    private String phone;

    @Basic
    private String address;

    public long getCustomerId() {
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
