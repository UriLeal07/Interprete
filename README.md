# Intérprete
Programa que traduce instrucciones de un pseudo-lenguaje de programación (inventado) a funciones que realizan cambios en la ventana de dibujo (lienzo) de la interfaz.

## Estructura del programa
```
Programa nombreDelPrograma
Inicio
	Instrucciones
Fin
```
## Sintáxis

### Palabras reservadas
* Programa
* Inicio
* Fin
* DibujarCara
* EliminarCara
* Dormir
* CambiarModo

### Instrucciones (Funciones)

* DibujarCara (coordX, coordY, radio, nombreCara, modo)
* EliminarCara (nombreCara)
* Dormir(nsegundos)
* CambiarModo(nombreCara, nuevoModo)


## Ejemplos de programas válidos

Ejemplo 1:
```
Programa primerPrograma
Inicio
   DibujarCara(30,30,20, Caro, enojada)
   DibujarCara(50,100,20,Manuel,feliz)
   Dormir(2)
   EliminarCara(Caro)
   Dormir(3)
   DibujarCara(70,50,20, Caro, triste)
   Dormir(2)
   CambiarModo(Caro,dormida)
Fin
```
Ejemplo 2:
```
Programa ejemploDos
Inicio  DibujarCara(40, 30, 25,  Miguel, triste) Dormir(3)
   CambiarModo(Miguel, feliz)   DibujarCara
(80, 150, 50,   Carmen, neutral)
Dormir ( 2)
EliminarCara (Carmen)   Fin
```

## Ejemplos de programas inválidos

```
Programa segundoPrograma
Inicio
   DibujarCara(  30, 60,120, Samuel, enojada)  // Debería marcar error ya que la cara no esta contenida completamenta en la pantalla
   Dormir(2)    EliminarCara(Guillermo)   //Error, no existe Guillermo
dormir(3)   // Error dormir no es una instrucción, la correcta es Dormir
   DibujarCara(70,50,20, Caro, triste)
   Dormir(2)    CambiarModo(Caro,dormida)
Fin
```
