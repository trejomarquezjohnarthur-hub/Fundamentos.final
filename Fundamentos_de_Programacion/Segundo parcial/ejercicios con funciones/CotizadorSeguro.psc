Proceso CotizadorSeguro
    Definir valorVehiculo Como Real
    Definir edad, accidentes Como Entero
    Definir tieneSeguridad Como Logico
    Definir tarifaBase, recargoEdad, recargoAccidentes, subtotalAcumulado, descuento, costoFinal Como Real
	
    // 1. Lectura y validación del valor del vehículo (> 0)
    Repetir
        Escribir "Ingresa el valor del vehículo (> 0): "
        Leer valorVehiculo
        Si valorVehiculo <= 0 Entonces
            Escribir "Error: El valor debe ser mayor a cero."
        FinSi
    Hasta Que valorVehiculo > 0
	
    // 2. Lectura y validación de la edad (18 a 100)
    Repetir
        Escribir "Ingresa la edad del conductor (18-100): "
        Leer edad
        Si edad < 18 O edad > 100 Entonces
            Escribir "Error: La edad debe estar entre 18 y 100 años."
        FinSi
    Hasta Que edad >= 18 Y edad <= 100
	
    // 3. Lectura y validación de accidentes (>= 0)
    Repetir
        Escribir "Ingresa la cantidad de accidentes reportados (>= 0): "
        Leer accidentes
        Si accidentes < 0 Entonces
            Escribir "Error: El número de accidentes no puede ser negativo."
        FinSi
    Hasta Que accidentes >= 0
	
    // 4. Sistema de seguridad adicional
    Escribir "¿Tiene sistema de seguridad adicional? (verdadero/falso): "
    Leer tieneSeguridad
	
    // --- LLAMADA A LOS MÉTODOS OBLIGATORIOS ---
    tarifaBase <- calcularTarifaBase(valorVehiculo)
    recargoEdad <- calcularRecargoPorEdad(tarifaBase, edad)
    recargoAccidentes <- calcularRecargoPorAccidentes(tarifaBase, accidentes)
    
    // El subtotal es la tarifa base más los recargos
    subtotalAcumulado <- tarifaBase + recargoEdad + recargoAccidentes
    descuento <- calcularDescuentoSeguridad(subtotalAcumulado, tieneSeguridad)
    
    costoFinal <- calcularCostoFinal(tarifaBase, recargoEdad, recargoAccidentes, descuento)
	
    // Resultados
    mostrarResumen(tarifaBase, recargoEdad, recargoAccidentes, descuento, costoFinal)
	
FinProceso


// --- MÉTODOS REQUERIDOS ---

Funcion resultado <- calcularTarifaBase(valorVehiculo)
    resultado <- valorVehiculo * 0.04
FinFuncion

Funcion resultado <- calcularRecargoPorEdad(tarifaBase, edad)
    Si edad < 25 Entonces
        resultado <- tarifaBase * 0.20 // 20% de recargo
    Sino
        Si edad > 60 Entonces
            resultado <- tarifaBase * 0.10 // 10% de recargo
        Sino
            resultado <- 0.0 // Entre 25 y 60 años no hay recargo
        FinSi
    FinSi
FinFuncion

Funcion resultado <- calcularRecargoPorAccidentes(tarifaBase, accidentes)
    resultado <- tarifaBase * 0.08 * accidentes // 8% por cada accidente
FinFuncion

Funcion resultado <- calcularDescuentoSeguridad(subtotal, tieneSeguridad)
    Si tieneSeguridad Entonces
        resultado <- subtotal * 0.05 // 5% de descuento sobre el total acumulado
    Sino
        resultado <- 0.0
    FinSi
FinFuncion

Funcion resultado <- calcularCostoFinal(tarifaBase, recargoEdad, recargoAccidentes, descuento)
    resultado <- (tarifaBase + recargoEdad + recargoAccidentes) - descuento
FinFuncion

SubProceso mostrarResumen(tarifaBase, recargoEdad, recargoAccidentes, descuento, costoFinal)
    Escribir ""
    Escribir "--- RESUMEN DE COTIZACIÓN ---"
    Escribir "Tarifa base: $", tarifaBase
    Escribir "Recargo por edad: $", recargoEdad
    Escribir "Recargo por accidentes: $", recargoAccidentes
    Escribir "Descuento por seguridad: $", descuento
    Escribir "Costo final de la póliza: $", costoFinal
FinSubProceso