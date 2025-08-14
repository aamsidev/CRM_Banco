package com.proyecto.banco.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "cuentas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cuentas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tercero", nullable = false)
    private Terceros tercero;

    @Column(name = "numero_cuenta", nullable = false, unique = true, length = 30)
    private String numeroCuenta;

    @Column(nullable = false)
    private Double saldo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado = Estado.activo;

    @Column(name = "fecha_apertura", nullable = false)
    private LocalDate fechaApertura;

    public enum Estado { activo, inactivo }
}
