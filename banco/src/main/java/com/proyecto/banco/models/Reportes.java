package com.proyecto.banco.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "reportes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reportes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reporte")
    private Integer id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Tipo tipo; // financiero, comercial, general

    @Column(name = "ruta_archivo", length = 255)
    private String rutaArchivo;

    @CreationTimestamp
    @Column(name = "fecha_generacion", updatable = false)
    private LocalDateTime fechaGeneracion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "generado_por", nullable = false)
    private Usuarios generadoPor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado = Estado.activo;

    public enum Tipo { financiero, comercial, general }
    public enum Estado { activo, inactivo }
}
