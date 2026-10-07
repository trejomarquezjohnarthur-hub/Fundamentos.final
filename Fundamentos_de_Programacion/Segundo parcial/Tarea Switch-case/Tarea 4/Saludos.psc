Algoritmo  Saludos
    Definir hora Como Entero
    Escribir "Introduce la hora (0-23): "
    Leer hora
    
    Si hora >= 6 Y hora <= 12 Entonces
        Escribir "Buenos días"
    SiNo
        Si hora >= 13 Y hora <= 20 Entonces
            Escribir "Buenas tardes"
        SiNo
            Si (hora >= 21 Y hora <= 23) O (hora >= 0 Y hora <= 5) Entonces
                Escribir "Buenas noches"
            SiNo
                Escribir "Hora inválida."
            FinSi
        FinSi
    FinSi
FinAlgoritmo
