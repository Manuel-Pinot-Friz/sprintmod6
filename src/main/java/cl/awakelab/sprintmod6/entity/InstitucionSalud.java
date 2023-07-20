package cl.awakelab.sprintmod6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Institucion_Salud")
public class InstitucionSalud {
    @Id
    @Column(name = "id_inst_salud")
    private int idInstSalud;
    @Column
    private String descripcion;
    @Column(name = "porc_dcto")
    private int porcDcto;
    //Relacion inst. salud - trabajador
    @OneToMany(mappedBy = "instSalud")
    List<Trabajador> listaTrabajadores;
    //Relacion inst. salud - liquidacion
    @OneToMany(mappedBy = "instSalud")
    List<Liquidacion> listaLiquidaciones;
}

