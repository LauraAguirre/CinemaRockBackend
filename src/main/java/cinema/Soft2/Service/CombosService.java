package cinema.Soft2.Service;

import cinema.Soft2.Model.Combos;
import cinema.Soft2.Model.User;
import cinema.Soft2.Repository.CombosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CombosService {

    @Autowired
    private CombosRepository combosRepository;

    public List<Combos> findAll() {
        return combosRepository.findAll();
    }

    public Optional<Combos> findById(Long idCombo) {
        return combosRepository.findById(idCombo);
    }

    public <S extends Combos> S save(S combo) {
        return combosRepository.save(combo);
    }

    public void deleteById(Long idCombo) {
        combosRepository.deleteById(idCombo);
    }

}