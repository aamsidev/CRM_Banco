export interface Pago {
  id_pago: number;
  id_contrato: number;
  fecha_pago: string;
  monto: number;
  metodo_pago: 'transferencia' | 'efectivo' | 'tarjeta';
  estado: 'registrado' | 'anulado';
}
