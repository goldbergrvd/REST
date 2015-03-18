package haha.controller;

import haha.jpa.Customer;
import haha.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

@RestController
@RequestMapping("/customer_repository")
public class CustomerRepositoryController {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * [{"name":"East evil","address":"Peach Island","phone":"0987654321"},{"name":"West poison","address":"White Mountain","phone":"0987654321"},{"name":"South emperor","address":"Da Lee","phone":"0987654321"},{"name":"North beggar","address":"Northern","phone":"0987654321"}]
     */
    @RequestMapping(method = POST)
    public Iterable<Customer> addCustomers(@RequestBody List<Customer> customers) {
        return customerRepository.save(customers);
    }

    @RequestMapping(method = DELETE)
    public String deleteCustomer(@RequestParam(value = "id") Integer id) {
        customerRepository.delete(id);
        return "Success!!";
    }

    @RequestMapping(value = "/id", method = GET)
    public Customer getCustomer(@RequestParam(value = "id") Integer id) {
        return customerRepository.findOne(id);
    }

    @RequestMapping(value = "/idGreaterThan", method = GET)
    public List<Customer> getCustomerByIdGreaterThan(@RequestParam(value = "id") Integer id) {
        return customerRepository.findByIdGreaterThan(id);
    }

    @RequestMapping(value = "/idBetween", method = GET)
    public List<Customer> getCustomerByIdBetween(@RequestParam(value = "id1") Integer id1,
                                                 @RequestParam(value = "id2") Integer id2) {
        return customerRepository.findByIdBetween(id1, id2);
    }

    @RequestMapping(value = "/name", method = GET)
    public Customer getCustomerByName(@RequestParam(value = "name") String name) {
        return customerRepository.findByName(name);
    }

}
