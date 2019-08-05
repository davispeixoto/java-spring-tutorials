package payroll;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
        orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

        employeeRepository.save(new Employee("Bilbo Baggins", "burglar"));
        employeeRepository.save(new Employee("Frodo Baggins", "thief"));

        return args -> {
            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });

            employeeRepository.findAll().forEach(employee -> {
                log.info("Preloading " + employee);
            });
        };
    }
}
