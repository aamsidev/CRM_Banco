export interface Kpi {
  id_kpi: number;
  nombre: string;
  valor: number;
  periodo: string;
  descripcion?: string;
  estado: 'activo' | 'inactivo';
}
