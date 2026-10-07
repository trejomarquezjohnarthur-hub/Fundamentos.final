Proceso Tienda
    Definir precio1, precio2, precio3 Como Real
    Definir cantidad1, cantidad2, cantidad3, tipoCliente Como Entero
    Definir codigoPostal Como Caracter
    Definir sub1, sub2, sub3, subtotalGeneral, descuento, subtotalConDescuento Como Real
    Definir envio, impuesto, totalPagar Como Real
	
    // --- 1. DATOS DEL PRODUCTO 1 ---
    Repetir
        Escribir "Producto 1 - Ingresa el precio (> 0): "
        Leer precio1
        Si precio1 <= 0 Entonces
            Escribir "Error: El precio debe ser mayor que cero."
        FinSi
    Hasta Que precio1 > 0
	
    Repetir
        Escribir "Producto 1 - Ingresa la cantidad (> 0): "
        Leer cantidad1
        Si cantidad1 <= 0 Entonces
            Escribir "Error: La cantidad debe ser un entero mayor que cero."
        FinSi
    Hasta Que cantidad1 > 0
	
    // --- 2. DATOS DEL PRODUCTO 2 ---
    Repetir
        Escribir ""
        Escribir "Producto 2 - Ingresa el precio (> 0): "
        Leer precio2
        Si precio2 <= 0 Entonces
            Escribir "Error: El precio debe ser mayor que cero."
        FinSi
    Hasta Que precio2 > 0
	
    Repetir
        Escribir "Producto 2 - Ingresa la cantidad (> 0): "
        Leer cantidad2
        Si cantidad2 <= 0 Entonces
            Escribir "Error: La cantidad debe ser un entero mayor que cero."
        FinSi
    Hasta Que cantidad2 > 0
	
    // --- 3. DATOS DEL PRODUCTO 3 ---
    Repetir
        Escribir ""
        Escribir "Producto 3 - Ingresa el precio (> 0): "
        Leer precio3
        Si precio3 <= 0 Entonces
            Escribir "Error: El precio debe ser mayor que cero."
        FinSi
    Hasta Que precio3 > 0
	
    Repetir
        Escribir "Producto 3 - Ingresa la cantidad (> 0): "
        Leer cantidad3
        Si cantidad3 <= 0 Entonces
            Escribir "Error: La cantidad debe ser un entero mayor que cero."
        FinSi
    Hasta Que cantidad3 > 0
	
    // --- 4. TIPO DE CLIENTE Y CÓDIGO POSTAL ---
    Repetir
        Escribir ""
        Escribir "Tipo de cliente (1: Regular, 2: Frecuente): "
        Leer tipoCliente
        Si tipoCliente <> 1 Y tipoCliente <> 2 Entonces
            Escribir "Error: El tipo de cliente solo puede ser 1 o 2."
        FinSi
    Hasta Que tipoCliente = 1 O tipoCliente = 2
	
    Repetir
        Escribir "Ingresa el código postal (exactamente 5 dígitos): "
        Leer codigoPostal
        // Nota: En PSeInt la validación con expresiones regulares (\d{5}) nativas puede variar 
        // según la versión, pero validamos la longitud de 5 caracteres como alternativa segura:
        Si Longitud(codigoPostal) <> 5 Entonces
            Escribir "Error: El código postal debe contener exactamente cinco dígitos numéricos."
        FinSi
    Hasta Que Longitud(codigoPostal) = 5
	
    // --- CÁLCULOS MEDIANTE FUNCIONES Y MÉTODOS ---
    sub1 <- calcularSubtotalProducto(precio1, cantidad1)
    sub2 <- calcularSubtotalProducto(precio2, cantidad2)
    sub3 <- calcularSubtotalProducto(precio3, cantidad3)
	
    subtotalGeneral <- calcularSubtotalGeneral(sub1, sub2, sub3)
    descuento <- calcularDescuento(subtotalGeneral, tipoCliente)
    subtotalConDescuento <- subtotalGeneral - descuento
    
    envio <- calcularEnvio(subtotalGeneral, codigoPostal)
    impuesto <- calcularImpuesto(subtotalConDescuento)
    totalPagar <- calcularTotal(subtotalGeneral, descuento, impuesto, envio)
	
    // --- 5. RESULTADOS ---
    mostrarResumen(subtotalGeneral, descuento, envio, impuesto, totalPagar)
	
FinProceso


// --- MÉTODOS Y FUNCIONES REQUERIDOS ---

Funcion resultado <- calcularSubtotalProducto(precio, cantidad)
    resultado <- precio * cantidad
FinFuncion

Funcion resultado <- calcularSubtotalGeneral(sub1, sub2, sub3)
    resultado <- sub1 + sub2 + sub3
FinFuncion

Funcion desc <- calcularDescuento(subtotal, tipoCliente)
    Si tipoCliente = 2 Entonces
        desc <- subtotal * 0.10  // Cliente frecuente: 10%
    Sino
        desc <- 0.0              // Cliente regular: 0%
    FinSi
	FINFUNCION // O "FinFuncion" según la versión de PSeInt
	
	Funcion costoEnvio <- calcularEnvio(subtotal, codigoPostal)
		Si subtotal < 1000.0 Entonces
			costoEnvio <- 150.0
		Sino
			Si subtotal >= 1000.0 Y subtotal < 3000.0 Entonces
				costoEnvio <- 80.0
			Sino
				costoEnvio <- 0.0
			FinSi
		FinSi
FinFuncion

Funcion imp <- calcularImpuesto(subtotalConDescuento)
    imp <- subtotalConDescuento * 0.16
FinFuncion

Funcion total <- calcularTotal(subtotal, descuento, impuesto, envio)
    total <- subtotal - descuento + impuesto + envio
FinFuncion

SubProceso mostrarResumen(subtotalGeneral, descuento, envio, impuesto, totalPagar)
    Escribir ""
    Escribir "--- RESUMEN DE LA COMPRA ---"
    Escribir "Subtotal general: $", subtotalGeneral
    Escribir "Descuento aplicado: $", descuento
    Escribir "Costo de envío: $", envio
    Escribir "Impuesto (16%): $", impuesto
    Escribir "Total a pagar: $", totalPagar
FinSubProceso