package com.proyecto.banco.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_contrato", nullable = false)
    private Contratos contrato;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @Column(nullable = false)
    private Double monto;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago", nullable = false)
    private MetodoPago metodoPago;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado = Estado.registrado;

    public enum MetodoPago { transferencia, efectivo, tarjeta }
    public enum Estado { registrado, anulado }
}
