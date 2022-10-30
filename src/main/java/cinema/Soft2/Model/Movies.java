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
@Table(name="Movies")

public class Movies implements Serializable {

    @Id
    private Long idMovie;

    @Column(name = "nameMovie")
    private  String nameMovie;

    @Column(name = "imageMovie")
    private  String imageMovie;

    @Column(name = "idRoom")
    private  String idRoom;

    @Column(name = "state")
    private  String state;

    @Column(name = "ageMin")
    private  int ageMin;

    @Column(name = "genreMovie")
    private  String genreMovie;

    @Column(name = "duration")
    private  String duration;

    @Column(name = "chairsAvailable")
    private  int chairsAvailable;

    @Column(name = "chairsOccupied")
    private  int chairsOccupied;

    @Column(name = "type")
    private String type;




}