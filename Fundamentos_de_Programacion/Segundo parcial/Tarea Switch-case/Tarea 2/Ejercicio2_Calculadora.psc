Algoritmo  Ejercicio2_Calculadora
    Definir num1, num2, resultado Como Real
    Definir op Como Caracter
    Escribir "Introduce el primer número:"
    Leer num1
    Escribir "Introduce el segundo número:"
    Leer num2
    Escribir "Introduce la operación (+, -, *, /):"
    Leer op
    
    Segun op Hacer
        "+":
            resultado = num1 + num2
            Escribir "Resultado: ", resultado
        "-":
            resultado = num1 - num2
            Escribir "Resultado: ", resultado
        "*":
            resultado = num1 * num2
            Escribir "Resultado: ", resultado
        "/":
            Si num2 <> 0 Entonces
                resultado = num1 / num2
                Escribir "Resultado: ", resultado
            SiNo
                Escribir "Error: No se puede dividir por cero."
            FinSi
        De Otro Modo:
            Escribir "Operador no válido."
    FinSegun
FinAlgoritmo
