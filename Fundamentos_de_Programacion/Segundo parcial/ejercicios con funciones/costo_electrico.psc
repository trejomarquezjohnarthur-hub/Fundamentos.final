Proceso CostoElectrico
    Definir CARGO_FIJO Como Real
    Definir lecturaAnterior, lecturaActual, consumo Como Real
    Definir tieneApoyo Como Logico
    Definir costoConsumo, costoAntesImpuesto, descuento, baseImponible, impuesto, total Como Real
	
    CARGO_FIJO <- 95.0
	
    // --- 1. VALIDACIÓN DE LECTURAS ---
    Repetir
        Escribir "Ingresa la lectura anterior (>= 0): "
        Leer lecturaAnterior
        Si lecturaAnterior < 0 Entonces
            Escribir "Error: La lectura no puede ser negativa."
        FinSi
    Hasta Que lecturaAnterior >= 0
	
    Repetir
        Escribir "Ingresa la lectura actual (>= lectura anterior, máx. 10,000 kWh de consumo): "
        Leer lecturaActual
        
        consumo <- calcularConsumo(lecturaAnterior, lecturaActual)
		
        Si lecturaActual < lecturaAnterior Entonces
            Escribir "Error: La lectura actual debe ser mayor o igual que la anterior."
        Sino
            Si consumo > 10000 Entonces
                Escribir "Error: El consumo excede el límite máximo permitido de 10,000 kWh."
            FinSi
        FinSi
    Hasta Que lecturaActual >= lecturaAnterior Y consumo <= 10000
	
    // --- 2. PROGRAMA DE APOYO ---
    Escribir "¿La vivienda pertenece al programa de apoyo? (verdadero/falso): "
    Leer tieneApoyo
	
    // --- 3. CÁLCULOS ---
    costoConsumo <- calcularCostoConsumo(consumo)
    costoAntesImpuesto <- costoConsumo + CARGO_FIJO
    descuento <- calcularDescuentoApoyo(consumo, costoAntesImpuesto, tieneApoyo)
    
    baseImponible <- costoAntesImpuesto - descuento
    impuesto <- calcularImpuesto(baseImponible)
    total <- calcularTotal(costoConsumo, CARGO_FIJO, descuento, impuesto)
	
    // --- 4. MOSTRAR RESULTADOS ---
    mostrarRecibo(consumo, costoConsumo, descuento, impuesto, total)
	
FinProceso


// --- FUNCIONES Y SUBPROCESOS ---

Funcion resultado <- calcularConsumo(lecturaAnterior, lecturaActual)
    resultado <- lecturaActual - lecturaAnterior
FinFuncion

Funcion costo <- calcularCostoConsumo(consumo)
    Si consumo <= 150 Entonces
        costo <- consumo * 1.20
    Sino
        Si consumo <= 400 Entonces
            costo <- (150 * 1.20) + ((consumo - 150) * 1.80)
        Sino
            costo <- (150 * 1.20) + (250 * 1.80) + ((consumo - 400) * 2.75)
        FinSi
    FinSi
FinFuncion

Funcion desc <- calcularDescuentoApoyo(consumo, costoAntesImpuesto, tieneApoyo)
    desc <- 0.0
    Si tieneApoyo Y consumo <= 250 Entonces
        desc <- costoAntesImpuesto * 0.30
    FinSi
FinFuncion

Funcion imp <- calcularImpuesto(baseImponible)
    imp <- baseImponible * 0.16
FinFuncion

Funcion resultadoTotal <- calcularTotal(costoConsumo, cargoFijo, descuento, impuesto)
    resultadoTotal <- (costoConsumo + cargoFijo) - descuento + impuesto
FinFuncion

SubProceso mostrarRecibo(consumo, costoConsumo, descuento, impuesto, total)
    Escribir ""
    Escribir "--- RECIBO DE CONSUMO ELÉCTRICO ---"
    Escribir "Consumo total: ", consumo, " kWh"
    Escribir "Costo por consumo (bloques): $", costoConsumo
    Escribir "Cargo fijo: $95.0"
    Escribir "Descuento aplicado: $", descuento
    Escribir "Impuesto (16%): $", impuesto
    Escribir "Total a pagar: $", total
FinSubProceso