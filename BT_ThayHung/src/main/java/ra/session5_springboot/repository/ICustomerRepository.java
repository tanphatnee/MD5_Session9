package ra.session5_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.session5_springboot.model.domain.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phone);
}
