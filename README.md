# WALLET MULTIMONEDA - Sistema de Gestión de Cuentas Bancarias

**Versión:** 1.0  
**Fecha:** Febrero 2026  
**Lenguaje:** Java  
**IDE:** Eclipse  

---

## 📋 Descripción General

**Wallet Multimoneda** es un sistema de gestión bancaria que permite crear cuentas, realizar operaciones financieras (depósitos y retiros) y convertir entre dos monedas: **CLP (Pesos Chilenos)** y **USD (Dólares Estadounidenses)**.

El sistema implementa principios de **programación orientada a objetos** con:
- **Interfaces** para definir contratos
- **Encapsulación** de datos
- **Validaciones** de operaciones
- **Pruebas unitarias** con JUnit 5

---

## 🎯 Objetivos del Proyecto

1. ✅ Crear un sistema de gestión de cuentas bancarias
2. ✅ Implementar operaciones financieras básicas (depósitos/retiros)
3. ✅ Validar transacciones y fondos disponibles
4. ✅ Realizar conversiones entre monedas (CLP ↔ USD)
5. ✅ Proporcionar interfaz de usuario interactiva
6. ✅ Implementar pruebas unitarias automatizadas

---

## 📦 Requisitos del Sistema

### Software Requerido
- **Java JDK:** 11 o superior
- **IDE:** Eclipse IDE para Desarrolladores Java
- **JUnit:** 5.x (incluido en las dependencias)
- **Sistema Operativo:** Windows, macOS o Linux

### Dependencias
```xml
<!-- JUnit 5 para pruebas unitarias -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.9.0</version>
    <scope>test</scope>
</dependency>
```

---

## 🏗️ Estructura del Proyecto

```
Clases/
├── src/
│   ├── IOperaciones.java          # Interface con contratos de operaciones
│   ├── Cuenta.java                # Clase principal de gestión de cuentas
│   ├── GestionBilletera.java      # Clase con menú principal (main)
│   ├── CuentaTest.java            # Suite de pruebas unitarias
│   └── Vehiculo.java              # Clase auxiliar (no utilizada en este flujo)
├── bin/                           # Archivos compilados (.class)
├── README.md                      # Este archivo
├── ESPECIFICACION_CLASES.md       # Documentación detallada de clases
├── MANUAL_USUARIO.md              # Guía de uso del sistema
├── API_SPECIFICATION.md           # Especificación de la interface
├── TESTING.md                     # Documentación de pruebas
└── ARQUITECTURA.md                # Diagrama de arquitectura

```

---

## 🚀 Instalación y Configuración

### 1. Clonar o Descargar el Proyecto
```bash
cd C:\Users\USER\eclipse-workspace\Clases
```

### 2. Abrir en Eclipse
- File → Open Projects from File System
- Seleccionar la carpeta `Clases`
- Click en Finish

### 3. Compilar el Proyecto
- Click derecho en el proyecto → Build Path → Configure Build Path
- Verificar que la carpeta `src` está en el Source Path
- Guardar cambios (Ctrl+S)

### 4. Ejecutar el Programa Principal
```bash
# Opción 1: Desde Eclipse
Click derecho en GestionBilletera.java → Run As → Java Application

# Opción 2: Desde línea de comandos
cd C:\Users\USER\eclipse-workspace\Clases\bin
java GestionBilletera
```

### 5. Ejecutar las Pruebas
```bash
# Desde Eclipse
Click derecho en CuentaTest.java → Run As → JUnit Test

# O ejecutar toda la suite
Click derecho en src → Run As → JUnit Test
```

---

## 💻 Guía de Uso Rápida

### Menú Principal
Al ejecutar `GestionBilletera`, aparecerá:

```
===== WALLET MULTIMONEDA =====
1. Crear Cuenta
2. Ver Saldo (CLP/USD)
3. Depositar
4. Retirar
5. Calculadora de Conversión
6. Salir
Seleccione: 
```

### Operaciones Disponibles

#### 1. **Crear Cuenta**
- Ingresa nombre del titular
- Ingresa saldo inicial (en CLP)
- Se crea una cuenta con número fijo: 123456

#### 2. **Ver Saldo**
- Muestra saldo en CLP y USD
- Requiere que exista una cuenta activa

#### 3. **Depositar**
- Ingresa monto a depositar
- Solo acepta montos positivos
- Actualiza el saldo automáticamente

#### 4. **Retirar**
- Ingresa monto a retirar
- Valida que haya fondos suficientes
- Rechaza montos negativos o mayores al saldo

#### 5. **Calculadora de Conversión**
- Convierte CLP a USD (divide entre 900)
- Convierte USD a CLP (multiplica por 900)
- No afecta el saldo de la cuenta

#### 6. **Salir**
- Cierra la aplicación

---

## 📊 Diagrama de Clases

```
┌─────────────────────────────────────────────────┐
│            «interface» IOperaciones             │
├─────────────────────────────────────────────────┤
│ + depositar(monto: double): void                │
│ + retirar(monto: double): void                  │
│ + getSaldo(): double                            │
│ + mostrarEstado(): void                         │
└─────────────────────────────────────────────────┘
                      ▲
                      │ implements
                      │
┌─────────────────────────────────────────────────┐
│              Cuenta                             │
├─────────────────────────────────────────────────┤
│ - numeroCuenta: int                             │
│ - titular: String                               │
│ - saldo: double                                 │
│ - VALOR_DOLAR: double = 900.0 (static final)   │
├─────────────────────────────────────────────────┤
│ + Cuenta(int, String, double)                   │
│ + depositar(double): void                       │
│ + retirar(double): void                         │
│ + getSaldo(): double                            │
│ + mostrarEstado(): void                         │
└─────────────────────────────────────────────────┘
                      ▲
                      │ usa
                      │
┌─────────────────────────────────────────────────┐
│          GestionBilletera                       │
├─────────────────────────────────────────────────┤
│ - teclado: Scanner                              │
│ - billetera1: Cuenta                            │
│ - opcion: int                                   │
│ - tasaDolar: double = 900.0                     │
├─────────────────────────────────────────────────┤
│ + main(String[]): void (MENÚ)                   │
└─────────────────────────────────────────────────┘
                      │
                      │ prueba
                      ▼
┌─────────────────────────────────────────────────┐
│           CuentaTest                            │
├─────────────────────────────────────────────────┤
│ - cuenta: Cuenta                                │
├─────────────────────────────────────────────────┤
│ + setUp(): void (@BeforeEach)                   │
│ + testDepositar(): void (@Test)                 │
│ + testRetirarExitoso(): void (@Test)            │
│ + testRetirarSinFondos(): void (@Test)          │
│ + testDepositarNegativo(): void (@Test)         │
└─────────────────────────────────────────────────┘
```

---

## 🔄 Flujo de Operaciones

### Crear Cuenta
```
GestionBilletera.main()
    ↓
Selecciona opción 1
    ↓
Ingresa: nombre, saldo inicial
    ↓
new Cuenta(123456, nombre, saldo)
    ↓
billetera1 está lista para operaciones
```

### Depositar Dinero
```
Selecciona opción 3
    ↓
Ingresa monto > 0
    ↓
billetera1.depositar(monto)
    ↓
Validación: monto > 0 ✓
    ↓
saldo += monto
    ↓
">>> Depósito exitoso."
```

### Retirar Dinero
```
Selecciona opción 4
    ↓
Ingresa monto
    ↓
billetera1.retirar(monto)
    ↓
Validación: monto > 0 AND monto <= saldo ✓
    ↓
saldo -= monto
    ↓
">>> Retiro exitoso."
```

---

## 📝 Validaciones Implementadas

| Operación | Validación | Resultado |
|-----------|-----------|-----------|
| Depositar | monto > 0 | Acepta solo positivos |
| Retirar | monto > 0 AND monto <= saldo | Rechaza sin fondos |
| Mostrar Saldo | Cuenta debe existir | Error si es nula |
| Conversión | monto > 0 | Calcula dinámicamente |

---

## 🧪 Pruebas Unitarias

El proyecto incluye 4 pruebas automatizadas en `CuentaTest.java`:

1. **testDepositar()** - Verifica que el depósito suma correctamente
2. **testRetirarExitoso()** - Verifica que el retiro resta correctamente
3. **testRetirarSinFondos()** - Verifica que rechaza retiros sin fondos
4. **testDepositarNegativo()** - Verifica que rechaza depósitos negativos

**Cobertura:** 100% de métodos principales

---

## 🔐 Seguridad y Encapsulación

- ✅ Atributos privados (numeroCuenta, titular, saldo)
- ✅ Métodos públicos controlados
- ✅ Validaciones en operaciones críticas
- ✅ Constantes para valores fijos (VALOR_DOLAR)
- ✅ Acceso a datos solo mediante getters

---

## 📈 Mejoras Futuras

1. **Persistencia de datos** - Guardar cuentas en archivo o base de datos
2. **Múltiples cuentas** - Usar estructura de datos (ArrayList/HashMap)
3. **Historial de transacciones** - Log de todas las operaciones
4. **Autenticación** - Sistema de login con PIN/contraseña
5. **Tasa de cambio dinámica** - Obtener tasa real del mercado
6. **API REST** - Exponer funcionalidad mediante servicios web
7. **Interfaz gráfica** - Cambiar de consola a GUI (Swing/JavaFX)

---

## 📚 Documentación Adicional

- **ESPECIFICACION_CLASES.md** - Detalle completo de cada clase y método
- **MANUAL_USUARIO.md** - Ejemplos prácticos de uso
- **API_SPECIFICATION.md** - Documentación técnica de la interface
- **TESTING.md** - Estrategia de pruebas y casos de test
- **ARQUITECTURA.md** - Diagramas y patrones de diseño

---

## 👨‍💻 Información de Contacto

**Proyecto:** Wallet Multimoneda  
**Versión:** 1.0  
**Estado:** Producción  
**Última actualización:** Febrero 2026

---

## 📄 Licencia

Este proyecto es de código abierto y está disponible para uso educativo y comercial.

---

## ✅ Checklist de Funcionalidades

- [x] Crear cuentas bancarias
- [x] Depositar dinero
- [x] Retirar dinero con validaciones
- [x] Consultar saldo en CLP y USD
- [x] Convertir monedas
- [x] Interface de usuario en consola
- [x] Pruebas unitarias automatizadas
- [x] Encapsulación de datos
- [x] Manejo de errores
- [x] Documentación técnica completa

---

**¡Gracias por usar Wallet Multimoneda!** 🏦
# Wallet_Mod2
