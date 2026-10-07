Proceso Areas
    Definir opcion Como Entero
    Definir lado, base, altura, radio, area Como Real
    
    Escribir "Menú de Áreas:"
    Escribir "1. Cuadrado"
    Escribir "2. Rectángulo"
    Escribir "3. Triángulo"
    Escribir "4. Círculo"
    Escribir "Elige una opción:"
    Leer opcion
    
    Segun opcion Hacer
        1:
            Escribir "Lado del cuadrado:"
            Leer lado
            area = lado * lado
            Escribir "El área es: ", area
        2:
            Escribir "Base y altura del rectángulo:"
            Leer base, altura
            area = base * altura
            Escribir "El área es: ", area
        3:
            Escribir "Base y altura del triángulo:"
            Leer base, altura
            area = (base * altura) / 2
            Escribir "El área es: ", area
        4:
            Escribir "Radio del círculo:"
            Leer radio
            area = 3.14159 * (radio * radio)
            Escribir "El área es: ", area
        De Otro Modo:
            Escribir "Opción inválida."
    FinSegun
FinProceso