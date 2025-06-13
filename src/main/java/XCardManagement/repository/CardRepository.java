package XCardManagement.repository;

import XCardManagement.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface CardRepository extends JpaRepository<Card, Double> {
    @Override
    Optional<Card> findById(Double doubles);
}
