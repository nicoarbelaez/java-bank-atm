<div align="center">
   <img width="600" src="https://ms-course-generator-prod.static.platzi.com/projects/java-course-full/6465ad00a1-cc8389ee4b/resources/sl02-0a14976799-6c2b44cc89.png" />
</div>

# Java Bank ATM

## Overview: Problema a resolver
> Soy el propietario de *Java Bank ATM* y necesito implementar un sistema que me permita gestionar de manera integral y sencilla las operaciones básicas de mi banco a través de una consola. Requiero que el sistema incluya los siguientes servicios:
> 
> - **Crear cuentas:** Permitir la apertura de nuevas cuentas para los clientes.
> - **Gestionar múltiples cuentas:** Facilitar la administración de varias cuentas asociadas a un mismo cliente.
> - **Tipos de cuentas:** Soportar diferentes tipos de cuentas, como cuentas de ahorro, de corriente e inversión.
> - **Consultar saldo:** Brindar la posibilidad de revisar el saldo disponible en cualquier cuenta.
> - **Depositar dinero:** Habilitar la opción de ingresar fondos a las cuentas.
> - **Retirar dinero:** Permitir la extracción de dinero de las cuentas.
> - **Transferencias:** Facilitar el movimiento de dinero entre cuentas.
> 
> La solución debe ser operable exclusivamente a través de la consola, garantizando que todas las operaciones sean intuitivas y directas, sin necesidad de interfaces gráficas complejas. Con esta herramienta, espero poder gestionar de forma efectiva todas las transacciones y operaciones esenciales de mi banco.

### Alcance (Scope)

#### Actores
- **Cliente**

#### Casos de Uso Principales

1. **Crear Cuenta**
   - **Descripción:** Permitir al cliente crear una cuenta especificando el tipo deseado.
   - **Flujo Principal:**
     1. El cliente selecciona la opción "Crear Cuenta".
     2. El sistema solicita elegir el tipo de cuenta: Ahorro, Corriente o Inversión.
     3. El cliente ingresa la información requerida.
     4. El sistema valida la información y crea la cuenta.
     5. Se muestra un mensaje confirmando la creación exitosa de la cuenta.
   - **Flujo Alternativo:**
     - Si se intenta crear una cuenta de inversión sin tener previamente una cuenta de ahorro o corriente, el sistema mostrará un mensaje de error y no permitirá la creación.

2. **Gestionar Transacciones**
   - **Descripción:** Permitir al cliente realizar operaciones financieras en sus cuentas.
   - **Sub-casos de Uso:**
     - **Depositar Dinero:** Ingresar fondos en la cuenta seleccionada.
     - **Retirar Dinero:** Extraer fondos de la cuenta, siempre que el saldo sea suficiente.
     - **Transferir Dinero:** Mover fondos entre cuentas del cliente o hacia cuentas externas.
     - **Invertir Dinero (o gestionar CDT en cuenta de ahorro):** Realizar operaciones de inversión en cuentas de inversión o gestionar productos financieros en cuentas de ahorro.

3. **Consultar Información**
   - **Descripción:** Permitir al cliente revisar el estado de sus cuentas.
   - **Funcionalidades:**
     - Consultar saldo.
     - Consultar movimientos y transacciones.
     - Consultar detalles de la información personal y de cada cuenta.

#### Fuera del Alcance (Out of Scope)

- **Restricciones en la Creación de Cuentas:**
  - No se permitirá la creación de una cuenta de inversión sin que el cliente tenga previamente una cuenta de ahorro o corriente.
- **Operaciones Financieras Avanzadas:**
  - No se implementarán servicios financieros complejos, tales como inversiones automatizadas o cálculos avanzados de intereses compuestos, en esta versión del sistema.

## Arquitectura

### Diagramas
poner diagramas de secuencia, uml, etc

### Modelo de datos
Poner diseño de entidades, Jsons, tablas, diagramas entidad relación, etc..

---
## Limitaciones
Lista de limitaciones conocidas. Puede ser en formato de lista.
Ej.
* Llamadas del API tienen latencia X
* No se soporta mas de X llamadas por segundo
---
## Costo
Descripción/Análisis de costos
Ejemplo:
"Considerando N usuarios diarios, M llamadas a X servicio/baseDatos/etc"
* 1000 llamadas diarias a serverless functions. $XX.XX
* 1000 read/write units diarias a X Database on-demand. $XX.XX
Total: $xx.xx (al mes/dia/año)