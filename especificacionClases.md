# Especificación Formal de Clases del Modelo

Este documento especifica el contrato de cada clase del modelo según el diseño definitivo basado en los patrones Composite, Factory y Memento, y respetando el Principio de Responsabilidad Única (SRP).

---

## 1. Casilla (Abstracta)
*   **Nombre exacto**: `ec.edu.epn.sokoban.model.escenario.Casilla`
*   **Responsabilidad Única (SRP)**: Representa el componente base de la estructura del tablero (patrón Composite). Define las propiedades comunes de fila y columna, así como la firma del método de transitabilidad.
*   **Atributos**:
    *   `private int fila`
    *   `private int columna`
*   **Métodos**:
    *   `public Casilla(int fila, int columna)`: Constructor principal.
    *   `public int getFila()`
    *   `public void setFila(int fila)`
    *   `public int getColumna()`
    *   `public void setColumna(int columna)`
    *   `public abstract boolean esTransitable()`: Determina si un objeto puede desplazarse a esta casilla.

---

## 2. Pared
*   **Nombre exacto**: `ec.edu.epn.sokoban.model.escenario.Pared`
*   **Responsabilidad Única (SRP)**: Representa un límite físico insuperable en el mapa (hoja del Composite).
*   **Atributos**: Ninguno propio (hereda `fila` y `columna`).
*   **Métodos**:
    *   `public Pared(int f, int c)`: Constructor.
    *   `public boolean esTransitable()`: Retorna siempre `false`.

---

## 3. SueloComun
*   **Nombre exacto**: `ec.edu.epn.sokoban.model.escenario.SueloComun`
*   **Responsabilidad Única (SRP)**: Representa una zona despejada sobre la cual pueden transitar libremente el personaje y las cajas (hoja del Composite).
*   **Atributos**: Ninguno propio.
*   **Métodos**:
    *   `public SueloComun(int f, int c)`: Constructor.
    *   `public boolean esTransitable()`: Retorna siempre `true`.

---

## 4. Meta
*   **Nombre exacto**: `ec.edu.epn.sokoban.model.escenario.Meta`
*   **Responsabilidad Única (SRP)**: Representa el punto de destino donde se debe colocar una caja (hoja del Composite) y realiza el seguimiento de si está satisfecha.
*   **Atributos**:
    *   `private boolean satisfecha`
*   **Métodos**:
    *   `public Meta(int f, int c)`: Constructor. Inicializa `satisfecha` en `false`.
    *   `public boolean isSatisfecha()`
    *   `public void setSatisfecha(boolean satisfecha)`
    *   `public boolean esTransitable()`: Retorna siempre `true` (un personaje o caja pueden estar encima de una meta).

---

## 5. Caja
*   **Nombre exacto**: `ec.edu.epn.sokoban.model.escenario.Caja`
*   **Responsabilidad Única (SRP)**: Objeto móvil que el personaje empuja hacia las metas (hoja del Composite).
*   **Atributos**:
    *   `private boolean enMeta`
*   **Métodos**:
    *   `public Caja(int f, int c)`: Constructor. Inicializa `enMeta` en `false`.
    *   `public boolean isEnMeta()`
    *   `public void setEnMeta(boolean enMeta)`
    *   `public boolean esTransitable()`: Retorna `false` (no se puede atravesar una caja; requiere empuje).

---

## 6. Personaje
*   **Nombre exacto**: `ec.edu.epn.sokoban.model.escenario.Personaje`
*   **Responsabilidad Única (SRP)**: Representa al operario controlado por el usuario que se mueve y empuja cajas en el mapa (hoja del Composite).
*   **Atributos**: Ninguno propio.
*   **Métodos**:
    *   `public Personaje(int f, int c)`: Constructor.
    *   `public boolean esTransitable()`: Retorna `false`.

---

## 7. Tablero
*   **Nombre exacto**: `ec.edu.epn.sokoban.model.escenario.Tablero`
*   **Responsabilidad Única (SRP)**: Estructura compuesta (Composite) que organiza las casillas bidimensionales, gestiona el mapa actual y delega consultas de movimiento de operario.
*   **Atributos**:
    *   `private int filas`
    *   `private int columnas`
    *   `private Casilla[][] celdas`
*   **Métodos**:
    *   `public Tablero(int filas, int columnas)`: Constructor.
    *   `public int getFilas()`
    *   `public int getColumnas()`
    *   `public Casilla[][] getCeldas()`
    *   `public Casilla obtenerCasilla(int f, int c)`
    *   `public void actualizarCasilla(int f, int c, Casilla nuevaCasilla)`: Reemplaza una celda en una posición específica.
    *   `public boolean moverOperario(Direccion d)`: Realiza el desplazamiento del personaje principal y retorna si se ejecutó con éxito.
    *   `public boolean esTransitable()`: Retorna siempre `true` (firma requerida por heredar de `Casilla`).

---

## 8. Nivel
*   **Nombre exacto**: `ec.edu.epn.sokoban.model.historial.Nivel`
*   **Responsabilidad Única (SRP)**: Estructura contenedora del estado inicial del mapa leído de la persistencia.
*   **Atributos**:
    *   `private boolean completado`
    *   `private String[][] mapaDatos`
*   **Métodos**:
    *   `public Nivel(String[][] mapaDatos)`: Constructor.
    *   `public boolean isCompletado()`
    *   `public void setCompletado(boolean completado)`
    *   `public String[][] getMapaDatos()`
    *   `public void setMapaDatos(String[][] mapaDatos)`
    *   `public void marcarComoCompletado()`: Establece `completado` en `true`.

---

## 9. PartidaMomento
*   **Nombre exacto**: `ec.edu.epn.sokoban.model.historial.PartidaMomento`
*   **Responsabilidad Única (SRP)**: Almacena una instantánea del estado del juego en un movimiento específico (patrón Memento). Permite restaurar las posiciones de las cajas y del personaje.
*   **Atributos**:
    *   `private Map<Caja, Casilla> posicionesCajas` (asocia cada caja a la casilla donde está colocada).
    *   `private Casilla posicionJugador` (casilla donde se encuentra el operario).
*   **Métodos**:
    *   `public PartidaMomento(Map<Caja, Casilla> posicionesCajas, Casilla posicionJugador)`: Constructor.
    *   `public Map<Caja, Casilla> getPosicionesCajas()`
    *   `public Casilla getPosicionJugador()`
    *   `public void restaurarEnTablero(Tablero t)`: Utiliza la información capturada para revertir las posiciones en el `Tablero`.

---

## 10. HistorialMovimientos
*   **Nombre exacto**: `ec.edu.epn.sokoban.model.historial.HistorialMovimientos`
*   **Responsabilidad Única (SRP)**: Actúa como el administrador (Caretaker) de la historia de los movimientos para implementar la acción "Deshacer" (Undo) en base a momentos (`PartidaMomento`).
*   **Atributos**:
    *   `private int movimientosContador`
    *   `private Stack<PartidaMomento> historial` (Pila interna para almacenar los momentos).
*   **Métodos**:
    *   `public HistorialMovimientos()`: Constructor.
    *   `public int getMovimientosContador()`
    *   `public void setMovimientosContador(int movimientosContador)`
    *   `public void registrarEstado(PartidaMomento e)`: Apila un nuevo momento y suma el contador.
    *   `public PartidaMomento extraerUltimoEstado()`: Extrae y retorna el último momento registrado.
    *   `public void vaciarHistorial()`: Reinicia la pila y el contador de movimientos.

---

## 11. Direccion (Enum)
*   **Nombre exacto**: `ec.edu.epn.sokoban.model.Direccion`
*   **Responsabilidad Única (SRP)**: Representa los movimientos ortogonales permitidos y calcula sus desplazamientos geométricos relativos en filas y columnas.
*   **Valores**:
    *   `ARRIBA`, `ABAJO`, `IZQUIERDA`, `DERECHA`
*   **Atributos**:
    *   `private final int deltaFila`
    *   `private final int deltaColumna`
*   **Métodos**:
    *   `private Direccion(int deltaFila, int deltaColumna)`: Constructor interno.
    *   `public int getDeltaFila()`
    *   `public int getDeltaColumna()`

---

## 12. ReglasJuego
*   **Nombre exacto**: `ec.edu.epn.sokoban.model.reglas.ReglasJuego`
*   **Responsabilidad Única (SRP)**: Evalúa las condiciones generales de reglas de negocio para determinar si un movimiento es válido y verificar si se ha alcanzado la victoria.
*   **Atributos**: Ninguno.
*   **Métodos**:
    *   `public ReglasJuego()`: Constructor.
    *   `public boolean validarMovimiento(Casilla origen, Direccion d, Tablero t)`: Evalúa si un actor puede avanzar desde la casilla de origen en la dirección indicada.
    *   `public boolean verificarVictoria(List<Meta> metas)`: Retorna `true` si todas las metas tienen una caja posicionada sobre ellas (satisfechas).

---

## 13. GestorColisiones
*   **Nombre exacto**: `ec.edu.epn.sokoban.model.reglas.GestorColisiones`
*   **Responsabilidad Única (SRP)**: Resuelve dinámicamente si dos elementos colisionan al moverse y maneja la lógica para empujar cajas.
*   **Atributos**: Ninguno.
*   **Métodos**:
    *   `public GestorColisiones()`: Constructor.
    *   `public boolean verificarColision(Tablero t, Casilla c, Direccion d)`: Analiza si mover un elemento a la casilla adyacente causará una colisión inamovible.
    *   `public boolean resolverEmpuje(Tablero t, Casilla c, Caja d, Direccion dir)`: Ejecuta la física de empuje de la caja `d` hacia la dirección `dir` evaluando las casillas detrás de ella, actualizando el tablero.

---

## 14. FabricaNiveles
*   **Nombre exacto**: `ec.edu.epn.sokoban.model.factory.FabricaNiveles`
*   **Responsabilidad Única (SRP)**: Construye e inicializa un objeto `Tablero` (con sus celdas, cajas, metas y personaje) a partir del mapa de datos crudo encapsulado en un `Nivel` (patrón Factory).
*   **Atributos**: Ninguno.
*   **Métodos**:
    *   `public FabricaNiveles()`: Constructor.
    *   `public Tablero construirTablero(Nivel n)`: Parsea la matriz de caracteres del `Nivel` e instancia las correspondientes implementaciones de `Casilla`.

---

## 15. JuegoSokoban
*   **Nombre exacto**: `ec.edu.epn.sokoban.model.JuegoSokoban`
*   **Responsabilidad Única (SRP)**: Actúa como el controlador de estado del juego (Facade principal), enlazando niveles, historial, colisiones y persistencia para ofrecer una API simplificada.
*   **Atributos**:
    *   `private List<Nivel> nivelesDisponibles`
    *   `private Nivel nivelActual`
    *   `private Tablero tableroActual`
    *   `private HistorialMovimientos historial`
    *   `private ReglasJuego reglas`
    *   `private GestorColisiones colisiones`
    *   `private GestorPersistencia persistencia`
*   **Métodos**:
    *   `public JuegoSokoban(List<Nivel> nivelesDisponibles)`: Constructor.
    *   `public List<Nivel> getNivelesDisponibles()`
    *   `public Nivel getNivelActual()`
    *   `public Tablero getTableroActual()`
    *   `public void seleccionarNivel(Nivel nivel)`: Carga un nivel específico, genera su tablero inicial y limpia el historial.
    *   `public void procesarEntrada(Direccion dir)`: Ejecuta el intento de movimiento del personaje en la dirección solicitada.
    *   `public void deshacerUltimaAccion()`: Restaura el estado inmediato anterior del tablero desde el historial.
    *   `public void reiniciarNivelActual()`: Vuelve a generar el tablero limpio del nivel en curso.
    *   `public void agregarNivel(Nivel n)`: Añade un nuevo nivel a la lista disponible.

---

## 16. GestorPersistencia
*   **Nombre exacto**: `ec.edu.epn.sokoban.model.persistencia.GestorPersistencia`
*   **Responsabilidad Única (SRP)**: Carga niveles desde archivos planos de recursos y lee/escribe el progreso guardado del juego del usuario.
*   **Atributos**:
    *   `private String archivoRuta`
*   **Métodos**:
    *   `public GestorPersistencia(String archivoRuta)`: Constructor.
    *   `public String getArchivoRuta()`
    *   `public void setArchivoRuta(String archivoRuta)`
    *   `public void guardarProgreso(List<Nivel> niveles)`: Escribe los niveles completados del usuario.
    *   `public List<Integer> cargarProgreso()`: Retorna los IDs de los niveles previamente completados.
    *   `public Nivel cargarNivelDesdeRecursos(int nivelId)`: Lee el archivo del nivel y construye un objeto `Nivel`.
