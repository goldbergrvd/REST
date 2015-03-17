package haha.controller;

import haha.jpa.Customer;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/customer")
@Transactional
public class CustomerController {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     *  {"name":"Mitsubishi","address":"earth","phone":"0987654321"}
     */
    @RequestMapping(method = POST)
    public String addCustomer(@RequestBody Customer customer) {
        System.out.println(customer.getName() + " - " +
                           customer.getAddress() + " - " +
                           customer.getPhone());
        try {
            entityManager.persist(customer);
        } catch (EntityExistsException e) {
            return "已存在！";
        }
        return String.format("客戶 %s 新增成功！", customer.getName());
    }

    @RequestMapping(method = GET)
    public List<Customer> getCustomers() {
        return entityManager
                .createQuery("Select c from Customer c", Customer.class)
                .getResultList();
    }

}
