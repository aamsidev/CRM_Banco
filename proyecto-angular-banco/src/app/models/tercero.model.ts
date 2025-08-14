export interface Tercero {
  id_tercero: number;
  tipo: 'cliente' | 'prospecto';
  nombre: string;
  documento_tipo: 'DNI' | 'RUC' | 'Pasaporte';
  documento_numero: string;
  telefono?: string;
  correo?: string;
  direccion?: string;
  estado: 'activo' | 'inactivo';
  fecha_creacion: string; // ISO date
}
