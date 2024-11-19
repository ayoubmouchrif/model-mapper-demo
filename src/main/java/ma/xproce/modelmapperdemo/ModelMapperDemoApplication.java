package ma.xproce.modelmapperdemo;

import ma.xproce.modelmapperdemo.dtos.CustomerDTO;
import ma.xproce.modelmapperdemo.entities.Customer;
import ma.xproce.modelmapperdemo.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ModelMapperDemoApplication {

    @Autowired
    private CustomerMapper customerMapper;

    public static void main(String[] args) {
        SpringApplication.run(ModelMapperDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner start() {
        return args -> {
            List<Customer> customers = new ArrayList<>(List.of(
                    Customer.builder()
                            .name("Ahmed")
                            .email("ahmed@gmail.com")
                            .password("Password1")
                            .build(),
                    Customer.builder()
                            .name("Achraf")
                            .email("achraf@gmail.com")
                            .password("Password2")
                            .build(),
                    Customer.builder()
                            .name("Ayman")
                            .email("ayman@gmail.com")
                            .password("Password3")
                            .build()
            ));

            List<CustomerDTO> customerdtosList =
                    customers.stream()
                            .map(customerMapper::fromCustomer)
                            .collect(Collectors.toList());

            System.out.println(customers);
            System.out.println(customerdtosList);
        };
    }
}
