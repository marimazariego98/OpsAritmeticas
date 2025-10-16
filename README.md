# Calculadora de Operaciones Aritméticas

[![Java](https://img.shields.io/badge/Java-11%2B-orange.svg)](https://www.oracle.com/java/)
[![JavaFX](https://img.shields.io/badge/JavaFX-13-blue.svg)](https://openjfx.io/)
[![Maven](https://img.shields.io/badge/Maven-3.8+-red.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-Academic-green.svg)]()

Aplicación de escritorio desarrollada con JavaFX que implementa una calculadora básica para operaciones aritméticas fundamentales (suma, resta, multiplicación y división).

## 📋 Descripción

Calculadora gráfica interactiva que permite realizar operaciones aritméticas entre dos números con validación de entrada, manejo de errores (división por cero, entradas inválidas) y formateo automático de resultados con hasta 12 decimales.

## ✨ Características

- ✅ Interfaz gráfica intuitiva con JavaFX
- ✅ Cuatro operaciones básicas: Suma (+), Resta (-), Multiplicación (×), División (÷)
- ✅ Validación automática de entrada de datos
- ✅ Manejo de división por cero con mensaje informativo
- ✅ Formateo inteligente de resultados (hasta 12 decimales)
- ✅ Función RESET para limpiar campos rápidamente
- ✅ Arquitectura modular con Java Platform Module System (JPMS)
- ✅ Interfaz no redimensionable para mantener diseño consistente

## 🔧 Requisitos del Sistema

### Software Requerido

| Componente | Versión | Notas |
|------------|---------|-------|
| **JDK** | 11 o superior | Java 24 recomendado para desarrollo |
| **Maven** | 3.6+ | Incluido en NetBeans |
| **JavaFX** | 13 | Gestionado automáticamente por Maven |
| **Sistema Operativo** | Linux, Windows, macOS | Multiplataforma |

### Hardware Recomendado

- **Procesador:** 1.5 GHz o superior
- **RAM:** 2 GB mínimo (4 GB recomendado)
- **Espacio en Disco:** 500 MB libres
- **Resolución:** 1024x768 o superior

## 📦 Instalación

### 1. Clonar el Repositorio

```bash
git clone [<URL-del-repositorio>](https://github.com/marimazariego98/OpsAritmeticas)
cd Opsaritmeticas
```

### 2. Configurar Java (si usas SDKMAN)

```bash
# Instalar SDKMAN (si no lo tienes)
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"

# Instalar Java 24
sdk install java 24.0.2-amzn
sdk use java 24.0.2-amzn
```

### 3. Configurar Variables de Entorno (Opcional)

Para usar Maven directamente desde terminal:

```bash
# Ejecutar script de configuración incluido
./configurar_maven.sh
source ~/.bashrc
```

O configurar manualmente en `~/.bashrc`:

```bash
export JAVA_HOME=/home/usuario/.sdkman/candidates/java/24.0.2-amzn
export MAVEN_HOME=/snap/netbeans/134/netbeans/java/maven
export PATH=$JAVA_HOME/bin:$MAVEN_HOME/bin:$PATH
```

### 4. Compilar el Proyecto

```bash
mvn clean compile
```

Salida esperada:
```
[INFO] BUILD SUCCESS
[INFO] Compiling 3 source files
```

## 🚀 Ejecución

### Opción 1: Maven (Recomendado)

```bash
mvn clean javafx:run
```

### Opción 2: NetBeans IDE

1. Abrir NetBeans
2. **File** → **Open Project**
3. Seleccionar la carpeta `Opsaritmeticas`
4. Click derecho en el proyecto → **Run** (o presionar `F6`)

### Opción 3: Línea de Comandos con Java Específico

```bash
JAVA_HOME=/home/usuario/.sdkman/candidates/java/24.0.2-amzn \
/snap/netbeans/134/netbeans/java/maven/bin/mvn clean javafx:run
```

### Opción 4: Ejecutar sin Maven instalado

Si Maven no está en tu PATH, usa el script incluido:

```bash
./configurar_maven.sh
source ~/.bashrc
mvn javafx:run
```

## 📁 Estructura del Proyecto

```
Opsaritmeticas/
│
├── src/
│   └── main/
│       └── java/
│           ├── module-info.java                    # Descriptor de módulo JPMS
│           └── com/iupanamericano/mariaramirez/
│               ├── App.java                        # Clase principal de la aplicación
│               └── SystemInfo.java                 # Información del sistema
│
├── target/                                         # Archivos compilados (generado)
│   ├── classes/                                    # Bytecode compilado
│   └── maven-status/                               # Estado de compilación
│
├── pom.xml                                         # Configuración Maven
├── configurar_maven.sh                             # Script de configuración
├── README.md                                       # Este archivo
├── DOCUMENTACION.md                                # Documentación académica completa
├── .gitignore                                      # Archivos ignorados por Git
└── nbactions.xml                                   # Configuración NetBeans
```

## 🛠️ Tecnologías Utilizadas

### Lenguajes y Frameworks

- **Java 11** - Versión de compilación configurada
- **Java 24** - Compatible para ejecución (recomendado)
- **JavaFX 13** - Framework para interfaz gráfica de usuario
- **Maven 3.x** - Gestión de dependencias y construcción

### Características de Java Utilizadas

- **Java Platform Module System (JPMS)** - Modularización
- **Expresiones Lambda** - Programación funcional
- **Streams API** - Procesamiento de datos
- **Try-Catch** - Manejo robusto de excepciones

## 💻 Arquitectura Técnica

### Diseño de la Aplicación

```
┌─────────────────────────────────────┐
│         App.java (Main)             │
│  extends Application (JavaFX)       │
├─────────────────────────────────────┤
│  - start(Stage)                     │
│  - botonOp(String)                  │
│  - operar(TextField, TextField,     │
│           Label, BiFunction)        │
└─────────────────────────────────────┘
           │
           ├──> GridPane (Layout)
           │    ├── TextField × 2 (Entradas)
           │    ├── Button × 4 (Operaciones)
           │    ├── Button × 1 (Reset)
           │    └── Label × 3 (Resultados)
           │
           └──> Event Handlers (Lambda)
                └── BiFunction<Double, Double, Double>
```

### Componentes Principales

#### 1. **App.java** - Clase Principal
- Hereda de `javafx.application.Application`
- Implementa el método `start(Stage stage)`
- Gestiona la interfaz gráfica y lógica de negocio

**Métodos clave:**
- `botonOp(String texto)` - Crea botones de operación con estilo
- `operar(...)` - Ejecuta operaciones usando BiFunction
- `main(String[] args)` - Punto de entrada de la aplicación

#### 2. **module-info.java** - Descriptor de Módulo

```java
module com.iupanamericano.mariaramirez {
    requires javafx.controls;
    exports com.iupanamericano.mariaramirez;
}
```

Define las dependencias del módulo y los paquetes exportados.

### Patrones de Diseño Implementados

1. **MVC Simplificado**
   - Vista: Componentes JavaFX (GridPane, TextField, Button)
   - Controlador: Manejadores de eventos (lambdas)
   - Modelo: Lógica de cálculo (BiFunction)

2. **Programación Funcional**
   - Uso de `BiFunction<Double, Double, Double>` para operaciones
   - Expresiones lambda para event handlers
   - Separación de lógica y presentación

3. **Event-Driven Architecture**
   - Respuesta a eventos de usuario (clics en botones)
   - Actualización dinámica de la interfaz

## 🧪 Casos de Prueba

### Operaciones Básicas

| Operación | Entrada 1 | Entrada 2 | Resultado Esperado |
|-----------|-----------|-----------|-------------------|
| Suma | 45 | 68 | 113 |
| Resta | 100 | 35 | 65 |
| Multiplicación | 12 | 8 | 96 |
| División | 100 | 4 | 25 |
| División Decimal | 10 | 3 | 3.333333333333 |

### Casos de Error

| Escenario | Entrada 1 | Entrada 2 | Resultado Esperado |
|-----------|-----------|-----------|-------------------|
| División por cero | 10 | 0 | "∞ / inválido" |
| Entrada no numérica | abc | 123 | "Entrada inválida" |
| Campo vacío | | 50 | "Entrada inválida" |
| Espacios en blanco | " 10 " | " 5 " | 15 (se trimean) |

## 📝 Configuración del Proyecto

### pom.xml - Dependencias

```xml
<groupId>com.iupanamericano</groupId>
<artifactId>Opsaritmeticas</artifactId>
<version>1.0-SNAPSHOT</version>

<properties>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>

<dependencies>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>13</version>
    </dependency>
</dependencies>
```

### Plugins Maven

- **maven-compiler-plugin 3.8.0** - Compilación Java 11
- **javafx-maven-plugin 0.0.4** - Ejecución de aplicaciones JavaFX

## 🐛 Solución de Problemas

### Problema: "Module not found"

**Solución:**
```bash
# Limpiar y recompilar
mvn clean compile
```

### Problema: "Command 'mvn' not found"

**Solución:**
```bash
# Usar ruta completa de Maven
/snap/netbeans/134/netbeans/java/maven/bin/mvn clean javafx:run

# O configurar PATH
./configurar_maven.sh
source ~/.bashrc
```

### Problema: "JavaFX runtime components are missing"

**Solución:**
```bash
# Reinstalar dependencias
mvn clean install

# Verificar pom.xml tiene la dependencia javafx-controls
```

### Problema: Aplicación se cierra inmediatamente

**Causa:** Posible error en la clase principal o configuración del módulo.

**Solución:**
```bash
# Verificar logs
mvn clean javafx:run 2>&1 | tee log.txt

# Verificar mainClass en pom.xml (línea 34)
# Debe ser: com.iupanamericano.mariaramirez.App
```

### Problema: Warnings de "sun.misc.Unsafe"

**Causa:** Warnings normales de Java 24 con dependencias antiguas.

**Solución:** Estos warnings son informativos y no afectan la funcionalidad.

## 📚 Documentación Adicional

- **[DOCUMENTACION.md](DOCUMENTACION.md)** - Documentación académica completa en español
  - Introducción detallada
  - Explicación línea por línea del código
  - Guía de usuario con capturas
  - Conceptos de programación utilizados

## 🎓 Información Académica

**Proyecto:** Calculadora de Operaciones Aritméticas
**Estudiante:** Maria Guadalupe Ramirez Mazariego
**Universidad:** Universidad Panamericana
**Materia:** Lenguaje De Programación IV
**Año:** 2025

## 🤝 Contribuciones

Este es un proyecto académico desarrollado con fines educativos. Para sugerencias o mejoras:

1. Abrir un **Issue** describiendo la mejora
2. Hacer **Fork** del proyecto
3. Crear una **Pull Request** con los cambios

## 📄 Licencia

Proyecto académico desarrollado para fines educativos en la Universidad Panamericana.

## 🔗 Enlaces Útiles

- [Documentación JavaFX](https://openjfx.io/javadoc/13/)
- [Maven Central - JavaFX](https://mvnrepository.com/artifact/org.openjfx/javafx-controls)
- [Java 11 Documentation](https://docs.oracle.com/en/java/javase/11/)
- [SDKMAN - Gestor de JDK](https://sdkman.io/)

## 📞 Contacto

Para consultas académicas sobre este proyecto, contactar a través de los canales oficiales de la Universidad Panamericana.

---

**Desarrollado con ❤️ usando Java y JavaFX**

*Última actualización: Octubre 2025*
