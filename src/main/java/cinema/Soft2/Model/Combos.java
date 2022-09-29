package cinema.Soft2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="Combos")

public class Combos implements Serializable {

    @Id
    private Long idCombo;

    @Column(name = "nameCombo")
    private  String nameCombo;

    @Column(name = "description")
    private  String description;

    @Column(name = "imageCombo")
    private  String imageCombo;

    @Column(name = "price")
    private  int price;



}