package cinema.Soft2.Controller;

import cinema.Soft2.Model.Combos;
import cinema.Soft2.Service.CombosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/combos")
@CrossOrigin
public class CombosController {

    @Autowired
    private CombosService combosService;

    @GetMapping("/findAll")
    private ResponseEntity<List<Combos>> getFindAll() {
        return ResponseEntity.ok(combosService.findAll());
    }

    @GetMapping("/findById/{idCombo}")
    private ResponseEntity<Optional<Combos>> getFindById(@PathVariable("idCombo") Long idCombo) {
        return ResponseEntity.ok(combosService.findById(idCombo));
    }

    @PostMapping("/save")
    private ResponseEntity<Combos> getSave(@RequestBody Combos combos) {
        try {
            Combos combosGuardado = combosService.save(combos);
            return ResponseEntity.created(new URI("/api/v1/combos" + combosGuardado.getIdCombo())).body(combosGuardado);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/deleteById/{idCombo}")
    private ResponseEntity<Boolean> deleteById(@PathVariable("idCombo") Long idCombos){
        combosService.deleteById(idCombos);
        return ResponseEntity.ok(true);
        //odio aki
    }
}