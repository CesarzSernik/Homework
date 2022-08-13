package pl.coderslab.beans;

import java.util.List;

public interface CustomerRepository {

    void add(Customer customer);
    void delete(Customer customer);
    void list();
}
