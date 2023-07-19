package cl.awakelab.sprintmod6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "InstPrev")
public class InstPrev {
    @Id
    @Column(name = "idInstPrev")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInstPrevision;
    @Column
    private String descripcion;
    @Column(name = "porc_dcto")
    private float porcDcto;

    @OneToMany(mappedBy = "instPrevision")
    List<Trabajador> listaTrabajadores;


    @OneToMany(mappedBy = "instPrevisional")
    List<Liquidacion> listaLiquidaciones;


}
