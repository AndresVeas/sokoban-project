# Sokoban - Clean Architecture & MVC with JavaFX

Este proyecto consiste en una reestructuración completa del clásico juego **Sokoban** para aplicar una arquitectura limpia y robusta, siguiendo los patrones de diseño **Composite**, **Factory** y **Memento (Memento/Caretaker)**, estructurado bajo el patrón arquitectónico **Modelo-Vista-Controlador (MVC)** e implementando la interfaz gráfica utilizando **JavaFX** y gestionado con **Maven**.

## Arquitectura del Proyecto

El sistema se divide claramente en capas según el patrón MVC, asegurando una alta cohesión y bajo acoplamiento:
*   **Modelo (`model`)**: Contiene la lógica del negocio (reglas, colisiones, tablero, nivel) y las entidades del dominio.
    *   **Patrón Composite**: La clase abstracta `Casilla` representa el componente base. Las hojas (`Pared`, `SueloComun`, `Meta`, `Caja`, `Personaje`) y el compuesto (`Tablero`) heredan de `Casilla`, permitiendo tratar a todos los elementos del mapa de manera uniforme.
    *   **Patrón Factory**: `FabricaNiveles` se encarga de instanciar y ensamblar el `Tablero` y sus celdas a partir de la representación del `Nivel`.
    *   **Patrón Memento**: `PartidaMomento` (el Memento) almacena instantáneas del estado del juego (`Map<Caja, Casilla>` y `Casilla` del personaje) y `HistorialMovimientos` (el Caretaker) permite realizar operaciones de deshacer (undo) usando una pila de estados.
*   **Vista (`view`)**: Implementa la interfaz gráfica usando **JavaFX** (`VentanaPrincipal`, `MenuInicio`, `PanelTablero`), renderizando el estado del modelo visualmente y abstrayéndose de la lógica de reglas de negocio.
*   **Controlador (`controller`)**: `ControladorTeclado` coordina la interacción del usuario (eventos de teclado) y el modelo, actualizando la vista según corresponda.
*   **Persistencia**: El `GestorPersistencia` desacopla la carga de niveles y almacenamiento del progreso en archivos `.txt`.

---

## Estructura del Proyecto

```text
sokoban-project/
├── pom.xml
├── README.md
├── especificacionClases.md
├── divisionGrupos.md
├── creacionNiveles.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ec/
│   │   │       └── edu/
│   │   │           └── epn/
│   │   │               └── sokoban/
│   │   │                   ├── Main.java
│   │   │                   ├── MainApp.java
│   │   │                   ├── controller/
│   │   │                   │   └── ControladorTeclado.java
│   │   │                   ├── model/
│   │   │                   │   ├── Direccion.java
│   │   │                   │   ├── JuegoSokoban.java
│   │   │                   │   ├── escenario/
│   │   │                   │   │   ├── Casilla.java
│   │   │                   │   │   ├── Pared.java
│   │   │                   │   │   ├── SueloComun.java
│   │   │                   │   │   ├── Meta.java
│   │   │                   │   │   ├── Caja.java
│   │   │                   │   │   ├── Personaje.java
│   │   │                   │   │   └── Tablero.java
│   │   │                   │   ├── historial/
│   │   │                   │   │   ├── Nivel.java
│   │   │                   │   │   ├── PartidaMomento.java
│   │   │                   │   │   └── HistorialMovimientos.java
│   │   │                   │   ├── reglas/
│   │   │                   │   │   ├── ReglasJuego.java
│   │   │                   │   │   └── GestorColisiones.java
│   │   │                   │   ├── persistencia/
│   │   │                   │   │   └── GestorPersistencia.java
│   │   │                   │   └── factory/
│   │   │                   │       └── FabricaNiveles.java
│   │   │                   └── view/
│   │   │                       ├── VentanaPrincipal.java
│   │   │                       ├── MenuInicio.java
│   │   │                       └── PanelTablero.java
│   │   └── resources/
│   │       └── niveles/
│   │           ├── 1.txt
│   │           └── 2.txt
```

---

## Compilación y Ejecución

Para compilar y ejecutar el proyecto utilizando Maven, asegúrate de tener instalado JDK 17 (o superior) y Maven en tu sistema.

### 1. Compilar el proyecto
Ejecuta el siguiente comando en la raíz del proyecto para limpiar los archivos compilados anteriores y compilar los archivos fuentes nuevos:
```bash
mvn clean compile
```

### 2. Ejecutar el juego con JavaFX
Para iniciar la interfaz gráfica del juego, ejecuta:
```bash
mvn javafx:run
```
