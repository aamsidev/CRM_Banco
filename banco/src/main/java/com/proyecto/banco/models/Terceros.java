package com.proyecto.banco.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "terceros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Terceros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tercero")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Tipo tipo; // cliente o prospecto

    @Column(nullable = false, length = 150)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "documento_tipo", nullable = false)
    private DocumentoTipo documentoTipo;

    @Column(name = "documento_numero", nullable = false, unique = true, length = 20)
    private String documentoNumero;

    @Column(length = 20)
    private String telefono;

    @Column(length = 150)
    private String correo;

    @Column(columnDefinition = "TEXT")
    private String direccion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado = Estado.activo;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    public enum Tipo { cliente, prospecto }
    public enum DocumentoTipo { DNI, RUC, Pasaporte }
    public enum Estado { activo, inactivo }
}
