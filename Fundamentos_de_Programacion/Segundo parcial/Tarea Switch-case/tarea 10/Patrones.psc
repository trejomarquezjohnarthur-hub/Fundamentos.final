Algoritmo  PatronesAsteriscos
		Definir n, i, j Como Entero
		Escribir "Ingresa el número de líneas (n):"
		Leer n
		
		Escribir "--- Patrón 1 (Cuadrado) ---"
		Para i <- 1 Hasta n Hacer
			Para j <- 1 Hasta n Hacer
				Escribir Sin Saltar "* "
			FinPara
			Escribir ""
		FinPara
		Escribir ""
		
		Escribir "--- Patrón 2 (Pirámide Invertida) ---"
		Para i <- 1 Hasta n Hacer
			
			Para j <- 1 Hasta i - 1 Hacer
				Escribir Sin Saltar " "
			FinPara
			
			Para j <- 1 Hasta (2 * (n - i) + 1) Hacer
				Escribir Sin Saltar "*"
			FinPara
			Escribir ""
		FinPara
		Escribir ""
		
		Escribir "--- Patrón 3 (Pirámide Normal) ---"
		Para i <- 1 Hasta n Hacer
		
			Para j <- 1 Hasta n - i Hacer
				Escribir Sin Saltar " "
			FinPara
			
			Para j <- 1 Hasta (2 * i - 1) Hacer
				Escribir Sin Saltar "*"
			FinPara
			Escribir ""
		FinPara

FinAlgoritmo
