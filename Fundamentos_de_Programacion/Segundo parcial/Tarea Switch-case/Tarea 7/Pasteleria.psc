Algoritmo  Pasteleria
    Definir sabor, tipo_choco, extra_snack, extra_nombre Como Cadena
    Definir total Como Real
    total = 0
    
    Escribir "¿Qué sabor quieres (manzana, fresa, chocolate)?"
    Leer sabor
    
    Si sabor = "manzana" Entonces
        total = 200
    FinSi
    
    Si sabor = "fresa" Entonces
        total = 250
    FinSi
    
    Si sabor = "chocolate" Entonces
        Escribir "¿El chocolate es negro o blanco?"
        Leer tipo_choco
        Si tipo_choco = "negro" Entonces
            total = 280
        SiNo
            total = 300
        FinSi
    FinSi
    
    Escribir "¿Añadir snack (fresa, galleta, durazno)? (si/no)"
    Leer extra_snack
    Si extra_snack = "si" Entonces
        total = total + 25
    FinSi
    
    Escribir "¿Personalizar con nombre? (si/no)"
    Leer extra_nombre
    Si extra_nombre = "si" Entonces
        total = total + 30
    FinSi
    
    Escribir "El presupuesto total de la tarta es: $", total
FinAlgoritmo
