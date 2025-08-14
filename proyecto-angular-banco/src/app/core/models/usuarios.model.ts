export interface Usuario {
  id_usuario: number;
  nombre: string;
  email: string;
  password?: string; // opcional para no enviarla siempre
  rol: string; // admin, comercial, finanzas
  estado: string; // activo o inactivo
  fecha_creacion: Date;
}

/*
Usamos interface en lugar de class porque Angular las usa solo para tipado y no para lógica.

Los nombres de campos coinciden con la base de datos para evitar confusiones en el API.

Fechas tipadas como Date para fácil conversión en formularios.

*/