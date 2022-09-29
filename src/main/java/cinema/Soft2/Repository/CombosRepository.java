package cinema.Soft2.Repository;
import cinema.Soft2.Model.Combos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CombosRepository extends JpaRepository<Combos,Long> {
}