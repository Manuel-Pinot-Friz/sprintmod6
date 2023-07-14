package cl.awakelab.sprintmod6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Trabajador")
public class Trabajador {
    @Id
    @Column(name = "id_trabajador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrabajador;
    @Column
    private int run;
    @Column
    private String nombre;
    @Column(name = "apellido_1")
    private String apellido1;
    @Column(name = "apellido_2")
    private String apellido2;
    @Column
    private String email;

    //Relacion trabajador - inst. prevision
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_inst_prevision",nullable = false)
    private InstitucionPrevision instPrevision;

    //Relacion trabajador - inst. salud
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_inst_salud", nullable = false)
    private InstitucionSalud instSalud;

    @Column
    private long telefono;

    //Relacion tabla intermedia
    @ManyToMany(mappedBy = "listaTrabajadores")
    List<Empleador> listaEmpleadores;

    //Relacion trabajador - liquidacion
    @OneToMany(mappedBy = "trabajador")
    List<Liquidacion> listaLiquidaciones;
}
