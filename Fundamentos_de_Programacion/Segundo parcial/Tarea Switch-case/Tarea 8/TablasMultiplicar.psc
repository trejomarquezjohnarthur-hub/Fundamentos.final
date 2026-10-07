Algoritmo TablasMultiplicar
		Definir n, i Como Entero
		
		Repetir
			Escribir "Ingresa un número para ver su tabla (0 para salir): "
			Leer n
			
			Si n <> 0 Entonces
				Escribir "Tabla del ",n
				Para i <- 1 Hasta 10 Con Paso 1 Hacer
					Escribir n, " x ", i, " = ", n * i
				FinPara
				Escribir "" 
			FinSi
			
		Hasta Que n = 0
		
		Escribir "Programa terminado."

FinAlgoritmo
