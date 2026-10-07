Algoritmo  Cine
    Definir personas, parejas, sueltos Como Entero
    Definir dia, membresia Como Cadena
    Definir total Como Real
    
    Escribir "¿Qué día es hoy? (ej. miercoles, jueves): "
    Leer dia
    Escribir "¿Cuántas personas son?: "
    Leer personas
    Escribir "¿Tienes membresía? (si/no): "
    Leer membresia
    
    Si dia = "miercoles" Entonces
        total = personas * 30
    SiNo
        Si dia = "jueves" Entonces
            parejas = trunc(personas / 2)
            sueltos = personas mod 2
            total = (parejas * 75) + (sueltos * 50)
        SiNo
            total = personas * 50
        FinSi
    FinSi
    
    Si membresia = "si" Entonces
        total = total - (total * 0.10)
    FinSi
    
    Escribir "El total a pagar es: $", total
FinAlgoritmo
