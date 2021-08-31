package order.domain.repository;

import order.domain.OrderEntryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface OrderEntryRepository extends JpaRepository<OrderEntryModel, UUID> {
}
