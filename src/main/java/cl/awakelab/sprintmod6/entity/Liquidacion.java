package cl.awakelab.sprintmod6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Liquidacion")
public class Liquidacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_liquidacion")
    private long idLiquidacion;
    //Relacion liquidacion - trabajador
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "id_trabajador")
    private Trabajador trabajador;
    @Column
    private LocalDate periodo;
    @Column(name = "sueldo_imponible")
    private int sueldoImponible;
    @Column(name = "sueldo_liquido")
    private int sueldoLiquido;
    //Relacion liquidacion - institucion salud
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "id_inst_salud",nullable = false)
    private InstitucionSalud instSalud;

    @Column(name = "monto_inst_salud")
    private int montoInstSalud;
    //Relacion liquidacion - institucion previsional
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "id_inst_previsional",nullable = false)
    private InstitucionPrevision instPrevisional;

    @Column(name = "monto_inst_previsional")
    private int montoInstPrevisional;

    @Column(name = "total_descuento")
    private int totalDescuento;
    @Column(name = "total_haberes")
    private int totalHaberes;
    @Column
    private int anticipo;
}
