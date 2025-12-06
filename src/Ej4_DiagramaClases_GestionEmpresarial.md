# Solución: Ejercicio - Sistema de Gestión Empresarial

## Análisis del Problema

### Identificación de Clases

1. **Empleado** (abstracta)
   * Representa a cualquier trabajador de la empresa
   * **Atributos**: `nombre_completo`, `fecha_nacimiento`, `sueldo_bruto`, `retencion`
   * **Métodos**: `calcular_edad()`

2. **Supervisor**
   * Empleado con responsabilidades de supervisión
   * **Atributos**: `puesto`
   * **Métodos**: `modificar_retencion()`, `modificar_sueldo_bruto()` 

3. **Cliente**
   * Representa la relacion comercial con la empresa
   * **Atributos**: `nombre_completo`, `fecha_nacimiento`, `numero_telefono` 

4. **Sistema_de_Pagos**
   * Sistema que gestiona las nóminas
   * **Métodos**: `obtener_retencion()`, `calcular_salario()`

5. **Empresa**
   * Entidad principal del sistema
   * **Atributos**: `nombre_corporativo`, `CIF`, `direccion_fiscal`

## Análisis de Relaciones

### 1. Herencia (Empleado → Supervisor)
* **Tipo**: Generalización/Especialización
* Un Supervisor **es un** Empleado con responsabilidades adicionales

### 2. Asociación Jerárquica
* **Relación**: "supervisa"
* **Cardinalidad**: Supervisor (1) → Empleado (0..n)
* Modela la estructura organizacional de la empresa

### 3. Dependencia Técnica
* **Relación**: "calcula_salario_a" 
* `Sistema_de_Pagos` utiliza datos de `Empleado` para cálculos

### 4. Relación Comercial
* **Relación**: "representado_por"
* **Cardinalidad**: Empresa (1..*) ↔ Cliente (0..*)
* Representa clientes gestionados por la empresa

## Diagrama de Clases

´´´

    @startuml Sistema_de_Gestion_Empresarial

    abstract class Empleado {
    - nombre_completo
    - fecha_nacimiento
    - sueldo_bruto
    - retencion
    + calcular_edad()
    }

    class Empleado_Responsable {
    - puesto
    + modificar_retencion()
    + modificar_sueldo_bruto()
    }

    class Cliente {
    - nombre_completo
    - fecha_nacimiento
    - numero_telefono
    }

    class Sistema_de_Pagos {
    + obtener_retencion()
    + calcular_salario()
    }

    class Empresa {
    - nombre_corporativo
    - CIF
    - direccion_fiscal
    }

    Empleado <|-- Empleado_Responsable
    Empleado_Responsable "1" --- "0..n" Empleado : supervisa
    Sistema_de_Pagos .> Empleado : calcula_salario_a
    Empresa "1.." -- "0.." Cliente : representado_por
´´´