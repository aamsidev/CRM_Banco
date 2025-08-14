export interface Solicitud {
  id_solicitud: number;
  id_tercero: number;
  id_producto: number;
  estado_solicitud: 'pendiente' | 'aprobada' | 'rechazada' | 'cancelada';
  fecha_solicitud: string;
  fecha_respuesta?: string;
  observaciones?: string;
  estado: 'activo' | 'inactivo';
}
