CREATE DATABASE IF NOT EXISTS crm_bancario;
USE crm_bancario;

-- ========================================================
-- TABLA DE USUARIOS (Para login y control de roles)
-- ========================================================
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    correo VARCHAR(150) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    rol ENUM('admin','asesor','analista','finanzas') DEFAULT 'asesor',
    estado ENUM('activo','inactivo') DEFAULT 'activo',
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ========================================================
-- MODULO: TERCEROS → Gestión de clientes y prospectos
-- ========================================================
CREATE TABLE terceros (
    id_tercero INT AUTO_INCREMENT PRIMARY KEY,
    tipo ENUM('cliente','prospecto') NOT NULL,
    nombre VARCHAR(150) NOT NULL,
    documento_tipo ENUM('DNI','RUC','Pasaporte') NOT NULL,
    documento_numero VARCHAR(20) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    correo VARCHAR(150),
    direccion TEXT,
    estado ENUM('activo','inactivo') DEFAULT 'activo',
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ========================================================
-- MODULO: PRODUCTOS Y SERVICIOS → Productos financieros
-- ========================================================
CREATE TABLE productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    tipo ENUM('cuenta','prestamo','tarjeta','seguro','inversion') NOT NULL,
    descripcion TEXT,
    tasa_interes DECIMAL(5,2) DEFAULT 0.00,
    estado ENUM('activo','inactivo') DEFAULT 'activo',
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ========================================================
-- MODULO: COMERCIAL → Seguimiento de solicitudes y contratos
-- ========================================================
CREATE TABLE solicitudes (
    id_solicitud INT AUTO_INCREMENT PRIMARY KEY,
    id_tercero INT NOT NULL,
    id_producto INT NOT NULL,
    estado_solicitud ENUM('pendiente','aprobada','rechazada','cancelada') DEFAULT 'pendiente',
    fecha_solicitud DATE NOT NULL,
    fecha_respuesta DATE,
    observaciones TEXT,
    estado ENUM('activo','inactivo') DEFAULT 'activo',
    FOREIGN KEY (id_tercero) REFERENCES terceros(id_tercero),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

CREATE TABLE contratos (
    id_contrato INT AUTO_INCREMENT PRIMARY KEY,
    id_solicitud INT NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE,
    monto DECIMAL(12,2) NOT NULL,
    estado ENUM('activo','inactivo') DEFAULT 'activo',
    FOREIGN KEY (id_solicitud) REFERENCES solicitudes(id_solicitud)
);

-- ========================================================
-- MODULO: FINANZAS → Control de pagos, vencimientos y cuentas
-- ========================================================
CREATE TABLE cuentas (
    id_cuenta INT AUTO_INCREMENT PRIMARY KEY,
    id_tercero INT NOT NULL,
    numero_cuenta VARCHAR(30) UNIQUE NOT NULL,
    saldo DECIMAL(12,2) DEFAULT 0.00,
    estado ENUM('activo','inactivo') DEFAULT 'activo',
    fecha_apertura DATE NOT NULL,
    FOREIGN KEY (id_tercero) REFERENCES terceros(id_tercero)
);

CREATE TABLE pagos (
    id_pago INT AUTO_INCREMENT PRIMARY KEY,
    id_contrato INT NOT NULL,
    fecha_pago DATE NOT NULL,
    monto DECIMAL(12,2) NOT NULL,
    metodo_pago ENUM('transferencia','efectivo','tarjeta') NOT NULL,
    estado ENUM('registrado','anulado') DEFAULT 'registrado',
    FOREIGN KEY (id_contrato) REFERENCES contratos(id_contrato)
);

-- ========================================================
-- MODULO: UTILIDADES → Reportes e informes
-- ========================================================
CREATE TABLE reportes (
    id_reporte INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    descripcion TEXT,
    tipo ENUM('financiero','comercial','general') NOT NULL,
    ruta_archivo VARCHAR(255),
    fecha_generacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    generado_por INT NOT NULL,
    estado ENUM('activo','inactivo') DEFAULT 'activo',
    FOREIGN KEY (generado_por) REFERENCES usuarios(id_usuario)
);

-- ========================================================
-- TABLA PARA KPIs DEL PANEL DE CONTROL (Módulo Inicio)
-- ========================================================
CREATE TABLE kpis (
    id_kpi INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    valor DECIMAL(15,2) NOT NULL,
    periodo DATE NOT NULL,
    descripcion TEXT,
    estado ENUM('activo','inactivo') DEFAULT 'activo'
);

-- ========================================================
-- DATOS DE PRUEBA
-- ========================================================
INSERT INTO usuarios (nombre, apellido, correo, contrasena, rol) VALUES
('Admin', 'Principal', 'admin@crm.com', 'admin123', 'admin');

INSERT INTO terceros (tipo, nombre, documento_tipo, documento_numero, telefono, correo, direccion) VALUES
('cliente', 'Juan Pérez', 'DNI', '12345678', '999888777', 'juan@correo.com', 'Av. Siempre Viva 123'),
('prospecto', 'Empresa XYZ', 'RUC', '20123456789', '011234567', 'contacto@empresa.com', 'Calle Comercio 456');

INSERT INTO productos (nombre, tipo, descripcion, tasa_interes) VALUES
('Cuenta Ahorros', 'cuenta', 'Cuenta de ahorros con intereses', 2.5),
('Préstamo Personal', 'prestamo', 'Préstamo personal a 12 meses', 15.0);
