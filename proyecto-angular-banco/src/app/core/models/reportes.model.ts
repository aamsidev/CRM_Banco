export interface Reporte {
  id_reporte: number;
  titulo: string;
  descripcion?: string;
  tipo: 'financiero' | 'comercial' | 'general';
  ruta_archivo?: string;
  fecha_generacion: string;
  generado_por: number;
  estado: 'activo' | 'inactivo';
}
