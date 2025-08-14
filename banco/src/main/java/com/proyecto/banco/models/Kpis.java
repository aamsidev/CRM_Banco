package com.proyecto.banco.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "kpis")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kpis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kpi")
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private LocalDate periodo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado = Estado.activo;

    public enum Estado { activo, inactivo }
}
