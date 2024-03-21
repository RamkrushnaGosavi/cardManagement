package XCardManagement.repository;

import XCardManagement.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Double> {
}
