package com.proyecto.banco.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "solicitudes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Solicitudes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tercero", nullable = false)
    private Terceros tercero;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_producto", nullable = false)
    private Productos producto;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_solicitud", nullable = false)
    private EstadoSolicitud estadoSolicitud = EstadoSolicitud.pendiente;

    @Column(name = "fecha_solicitud", nullable = false)
    private LocalDate fechaSolicitud;

    @Column(name = "fecha_respuesta")
    private LocalDate fechaRespuesta;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado = Estado.activo;

    public enum EstadoSolicitud { pendiente, aprobada, rechazada, cancelada }
    public enum Estado { activo, inactivo }
}
