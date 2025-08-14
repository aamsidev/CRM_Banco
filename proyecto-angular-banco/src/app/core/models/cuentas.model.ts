export interface Cuenta {
  id_cuenta: number;
  id_tercero: number;
  numero_cuenta: string;
  saldo: number;
  estado: 'activo' | 'inactivo';
  fecha_apertura: string;
}
