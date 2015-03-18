package haha.repository;

import haha.jpa.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findByIdGreaterThan(Integer id);
    List<Customer> findByIdBetween(Integer id1, Integer id2);
    Customer findByName(String name);
}
