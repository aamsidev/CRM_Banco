package com.proyecto.banco.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Tipo tipo; // cuenta, prestamo, etc.

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "tasa_interes")
    private Double tasaInteres = 0.00;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado = Estado.activo;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    public enum Tipo { cuenta, prestamo, tarjeta, seguro, inversion }
    public enum Estado { activo, inactivo }
}
