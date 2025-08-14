export interface Producto {
  id_producto: number;
  nombre: string;
  tipo: 'cuenta' | 'prestamo' | 'tarjeta' | 'seguro' | 'inversion';
  descripcion?: string;
  tasa_interes: number;
  estado: 'activo' | 'inactivo';
  fecha_creacion: string; // ISO date
}
