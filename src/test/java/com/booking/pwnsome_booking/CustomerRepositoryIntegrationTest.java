package com.booking.pwnsome_booking;

import com.booking.pwnsome_booking.model.*;
import com.booking.pwnsome_booking.repository.*;
import org.assertj.core.api.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.junit4.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryIntegrationTest {


    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CustomerRepository customerRepository;


    @Test
    public void whenFindByUsername_thenReturnCustomer(){
        Customer shota = new Customer("shota", "password");
        testEntityManager.persist(shota);
        testEntityManager.flush();

        Customer found = customerRepository.findByUsername(shota.getUsername());

        assertThat(found.getUsername()).isEqualTo(shota.getUsername());
        assertThat(found.getPassword()).isEqualTo(shota.getPassword());
    }


}
