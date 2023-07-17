package cl.awakelab.sprintmod6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="Usuario")
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column
    private int run;
    @Column
    private int clave;
    @Column
    private String nombre;
    @Column(name = "apellido_1")
    private String apellido1;
    @Column(name = "apellido_2")
    private String apellido2;
    //Relacion usuario-perfil
    @ManyToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_perfil",nullable = false)
    private Perfil perfil;
    @Column
    private String email;
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
    @Column
    private long telefono;
    //Relacion usuario-empleador
    @OneToMany(mappedBy = "usuario")
    List<Empleador> listaEmpleador;
}
