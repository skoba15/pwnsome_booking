package com.booking.pwnsome_booking;


import com.booking.pwnsome_booking.config.*;
import com.booking.pwnsome_booking.dto.*;
import com.booking.pwnsome_booking.model.*;
import com.booking.pwnsome_booking.repository.*;
import com.booking.pwnsome_booking.service.*;
import com.booking.pwnsome_booking.util.*;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.context.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={CustomerConverter.class, ApplicationConfig.class, CustomerServiceImpl.class})
public class CustomerServiceImplIntegrationTest {

    @TestConfiguration
    static class CustomerServiceImplTestContextConfiguration {

        @Bean
        public CustomerService customerService(){
            return new CustomerServiceImpl();
        }
    }

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;


    @Before
    public void setUp() {
        Customer shota = new Customer("shota", "password");

        Mockito.when(customerRepository.findByUsername(shota.getUsername()))
                .thenReturn(shota);
    }

    @Test
    public void whenValidUsername_thenCustomerShouldBeFound(){
        String name = "shota";
        CustomerDTO found = customerService.getCustomer("shota");
        assertThat(found.getUsername()).isEqualTo(name);
    }

}
