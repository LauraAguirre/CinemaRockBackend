package cinema.Soft2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="UserCinema")

public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "genre")
    private String genre;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(name = "confirmpassword")
    private String confirmpassword;


}