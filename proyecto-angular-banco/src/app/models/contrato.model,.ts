export interface Contrato {
  id_contrato: number;
  id_solicitud: number;
  fecha_inicio: string;
  fecha_fin?: string;
  monto: number;
  estado: 'activo' | 'inactivo';
}
