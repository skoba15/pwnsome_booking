package com.booking.pwnsome_booking;


import com.booking.pwnsome_booking.model.*;
import com.booking.pwnsome_booking.repository.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.context.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.transaction.annotation.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class HibernateIntegrationTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void whenBootstrapHibernateSession_thenNoException() {
        Customer customer = new Customer("shota", "koba");
        customerRepository.save(customer);
        Assert.assertTrue(("shota").equals(customerRepository.findById(1).getUsername()));
    }


    @Test
    public void test1(){
        Assert.assertTrue(1==1);
    }
}
