# Requerimientos del Proyecto

## 📋 Información General

Este documento detalla todos los requerimientos necesarios para compilar, desarrollar y ejecutar el proyecto **Calculadora de Operaciones Aritméticas**.

---

## 🖥️ Entorno de Desarrollo Actual

### Sistema Operativo

| Componente | Valor |
|------------|-------|
| **Sistema** | Linux |
| **Distribución** | Ubuntu 24.04 LTS |
| **Kernel** | 6.8.0-85-generic |
| **Arquitectura** | x86_64 (amd64) |

### IDE y Herramientas de Desarrollo

#### NetBeans IDE

| Propiedad | Detalle |
|-----------|---------|
| **Versión** | NetBeans 27 |
| **Instalación** | Snap Package |
| **Ruta** | `/snap/netbeans/134/` |
| **Maven Integrado** | Maven 3.9.11 |
| **Ruta Maven** | `/snap/netbeans/134/netbeans/java/maven/` |

**URL de Descarga:**
- Sitio oficial: [https://netbeans.apache.org/download/](https://netbeans.apache.org/download/)
- Instalación en Ubuntu/Linux:
  ```bash
  sudo snap install netbeans --classic
  ```

**Características de NetBeans 27:**
- Soporte completo para Java 24
- Integración con JavaFX
- Maven incorporado
- Depuración avanzada
- Autocompletado inteligente
- Gestión de proyectos modulares (JPMS)

---

## ☕ Java Development Kit (JDK)

### Configuración Actual del Proyecto

| Componente | Versión |
|------------|---------|
| **Compilación** | Java 11 |
| **Ejecución** | Java 24 (Amazon Corretto) |
| **Gestor de Versiones** | SDKMAN |

### Java 24 (Amazon Corretto)

**Información de la Versión:**
- **Vendor:** Amazon.com Inc.
- **Versión Completa:** 24.0.2-amzn
- **Tipo:** OpenJDK
- **Ruta de Instalación:** `/home/usuario/.sdkman/candidates/java/24.0.2-amzn`

**URL de Descarga:**
- Amazon Corretto: [https://aws.amazon.com/corretto/](https://aws.amazon.com/corretto/)
- Página de descargas: [https://docs.aws.amazon.com/corretto/latest/corretto-24-ug/downloads-list.html](https://docs.aws.amazon.com/corretto/latest/corretto-24-ug/downloads-list.html)

### SDKMAN - Gestor de Versiones de Java

SDKMAN es una herramienta para gestionar múltiples versiones de Java y otros SDKs en paralelo.

**Información:**
- **Sitio Web:** [https://sdkman.io/](https://sdkman.io/)
- **Documentación:** [https://sdkman.io/usage](https://sdkman.io/usage)

**Instalación de SDKMAN:**

```bash
# Descargar e instalar SDKMAN
curl -s "https://get.sdkman.io" | bash

# Activar SDKMAN en la sesión actual
source "$HOME/.sdkman/bin/sdkman-init.sh"

# Verificar instalación
sdk version
```

**Configuración de Java con SDKMAN:**

```bash
# Listar versiones de Java disponibles
sdk list java

# Instalar Java 24 (Amazon Corretto)
sdk install java 24.0.2-amzn

# Establecer Java 24 como versión por defecto
sdk default java 24.0.2-amzn

# O usar solo para la sesión actual
sdk use java 24.0.2-amzn

# Verificar versión activa
java -version
```

**Salida esperada de `java -version`:**
```
openjdk version "24.0.2" 2025-07-15
OpenJDK Runtime Environment Corretto-24.0.2.1 (build 24.0.2+9-FR)
OpenJDK 64-Bit Server VM Corretto-24.0.2.1 (build 24.0.2+9-FR, mixed mode, sharing)
```

**Gestión de múltiples versiones:**

```bash
# Listar versiones instaladas
sdk list java | grep installed

# Cambiar entre versiones
sdk use java 11.0.23-amzn    # Para Java 11
sdk use java 24.0.2-amzn     # Para Java 24

# Desinstalar una versión
sdk uninstall java 11.0.23-amzn
```

**Ventajas de SDKMAN:**
- ✅ Gestión de múltiples versiones de Java simultáneamente
- ✅ Cambio rápido entre versiones sin conflictos
- ✅ Instalación limpia sin permisos de administrador
- ✅ Soporte para múltiples distribuciones (Oracle, OpenJDK, Corretto, etc.)
- ✅ Actualizaciones automáticas de catálogo

---

## 🎨 JavaFX - Framework de Interfaz Gráfica

### Configuración del Proyecto

| Propiedad | Valor |
|-----------|-------|
| **Versión** | JavaFX 13 |
| **Módulo** | javafx-controls |
| **Gestión** | Maven (automática) |

**URL de Recursos:**
- Sitio oficial: [https://openjfx.io/](https://openjfx.io/)
- Documentación API: [https://openjfx.io/javadoc/13/](https://openjfx.io/javadoc/13/)
- Guía de inicio: [https://openjfx.io/openjfx-docs/](https://openjfx.io/openjfx-docs/)
- Maven Repository: [https://mvnrepository.com/artifact/org.openjfx/javafx-controls/13](https://mvnrepository.com/artifact/org.openjfx/javafx-controls/13)

**Dependencia Maven:**
```xml
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>13</version>
</dependency>
```

**Componentes JavaFX Utilizados:**
- `javafx.application.Application` - Clase base de la aplicación
- `javafx.scene.Scene` - Contenedor de la interfaz
- `javafx.scene.control.*` - Controles (Button, TextField, Label)
- `javafx.scene.layout.GridPane` - Layout de cuadrícula
- `javafx.geometry.*` - Utilidades de posicionamiento

**Características:**
- Sistema de módulos compatible con JPMS
- Renderizado acelerado por hardware
- CSS para estilos personalizados
- Arquitectura MVC
- Multiplataforma (Linux, Windows, macOS)

---

## 🔧 Apache Maven

### Configuración

| Propiedad | Valor |
|-----------|-------|
| **Versión** | Maven 3.9.11 |
| **Integración** | NetBeans (incluido) |
| **Maven Home** | `/snap/netbeans/134/netbeans/java/maven` |

**URL de Recursos:**
- Sitio oficial: [https://maven.apache.org/](https://maven.apache.org/)
- Documentación: [https://maven.apache.org/guides/](https://maven.apache.org/guides/)
- Descargas: [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
- Central Repository: [https://mvnrepository.com/](https://mvnrepository.com/)

**Plugins Utilizados:**

1. **maven-compiler-plugin 3.8.0**
   - URL: [https://maven.apache.org/plugins/maven-compiler-plugin/](https://maven.apache.org/plugins/maven-compiler-plugin/)
   - Función: Compilación de código Java

2. **javafx-maven-plugin 0.0.4**
   - URL: [https://github.com/openjfx/javafx-maven-plugin](https://github.com/openjfx/javafx-maven-plugin)
   - Función: Ejecución de aplicaciones JavaFX

**Comandos Maven Esenciales:**

```bash
# Limpiar proyecto
mvn clean

# Compilar
mvn compile

# Ejecutar aplicación JavaFX
mvn javafx:run

# Empaquetar JAR
mvn package

# Instalar en repositorio local
mvn install

# Ver árbol de dependencias
mvn dependency:tree

# Actualizar dependencias
mvn versions:display-dependency-updates
```

---

## 📦 Dependencias del Proyecto

### Dependencias Directas

| Dependencia | Versión | Propósito |
|-------------|---------|-----------|
| **javafx-controls** | 13 | Componentes de interfaz gráfica |

### Dependencias Transitivas (Automáticas)

Maven descarga automáticamente:
- `javafx-base-13` - Clases base de JavaFX
- `javafx-graphics-13` - Motor de renderizado
- Dependencias específicas de plataforma (Linux/Windows/macOS)

**Ubicación del Repositorio Local:**
```
~/.m2/repository/org/openjfx/
```

---

## 🔐 Configuración de Variables de Entorno

### Variables Requeridas

```bash
# Java
export JAVA_HOME=/home/usuario/.sdkman/candidates/java/24.0.2-amzn
export PATH=$JAVA_HOME/bin:$PATH

# Maven
export MAVEN_HOME=/snap/netbeans/134/netbeans/java/maven
export PATH=$MAVEN_HOME/bin:$PATH
```

### Script de Configuración Incluido

El proyecto incluye `configurar_maven.sh` para automatizar la configuración:

```bash
#!/bin/bash
# Agregar al ~/.bashrc
echo 'export JAVA_HOME=/home/usuario/.sdkman/candidates/java/24.0.2-amzn' >> ~/.bashrc
echo 'export PATH=$JAVA_HOME/bin:$PATH' >> ~/.bashrc
echo 'export MAVEN_HOME=/snap/netbeans/134/netbeans/java/maven' >> ~/.bashrc
echo 'export PATH=$MAVEN_HOME/bin:$PATH' >> ~/.bashrc

# Aplicar cambios
source ~/.bashrc
```

**Uso:**
```bash
./configurar_maven.sh
source ~/.bashrc
```

---

## 🌐 Sistema de Módulos Java (JPMS)

### Java Platform Module System

El proyecto utiliza el sistema de módulos introducido en Java 9+.

**Archivo:** `module-info.java`

```java
module com.iupanamericano.mariaramirez {
    requires javafx.controls;
    exports com.iupanamericano.mariaramirez;
}
```

**Documentación:**
- Guía oficial: [https://www.oracle.com/corporate/features/understanding-java-9-modules.html](https://www.oracle.com/corporate/features/understanding-java-9-modules.html)
- Tutorial: [https://docs.oracle.com/javase/tutorial/java/modules/](https://docs.oracle.com/javase/tutorial/java/modules/)

---

## 💾 Requisitos de Hardware

### Mínimos

| Componente | Especificación |
|------------|----------------|
| **Procesador** | 1.5 GHz (x86-64) |
| **RAM** | 2 GB |
| **Disco Duro** | 500 MB libres |
| **Pantalla** | 1024x768 |

### Recomendados

| Componente | Especificación |
|------------|----------------|
| **Procesador** | 2.0 GHz o superior (multi-core) |
| **RAM** | 4 GB o más |
| **Disco Duro** | 1 GB libres (para dependencias) |
| **Pantalla** | 1920x1080 (Full HD) |

---

## 🔍 Verificación del Entorno

### Script de Verificación

```bash
#!/bin/bash
echo "=== Verificación del Entorno de Desarrollo ==="
echo ""

# Java
echo "Java:"
java -version
echo ""

# Maven
echo "Maven:"
mvn -version
echo ""

# SDKMAN
echo "SDKMAN:"
sdk version
echo ""

# NetBeans (verificar instalación)
echo "NetBeans:"
if [ -d "/snap/netbeans" ]; then
    echo "NetBeans instalado en /snap/netbeans"
    snap info netbeans | grep installed
else
    echo "NetBeans NO encontrado"
fi
echo ""

# Directorio del proyecto
echo "Proyecto:"
if [ -f "pom.xml" ]; then
    echo "✓ pom.xml encontrado"
    grep -A 1 "<artifactId>" pom.xml | head -2
else
    echo "✗ pom.xml NO encontrado"
fi
echo ""

# Módulos Java
echo "Módulo Java:"
if [ -f "src/main/java/module-info.java" ]; then
    echo "✓ module-info.java encontrado"
    cat src/main/java/module-info.java
else
    echo "✗ module-info.java NO encontrado"
fi
```

### Comandos de Verificación Manual

```bash
# 1. Verificar Java
java -version
echo $JAVA_HOME

# 2. Verificar Maven
mvn -version
which mvn

# 3. Verificar SDKMAN
sdk version
sdk current java

# 4. Verificar dependencias del proyecto
cd /ruta/al/proyecto
mvn dependency:tree

# 5. Compilar proyecto (prueba)
mvn clean compile
```

---

## 📚 Recursos Adicionales

### Tutoriales y Guías

- **JavaFX para principiantes:** [https://jenkov.com/tutorials/javafx/index.html](https://jenkov.com/tutorials/javafx/index.html)
- **Maven en 5 minutos:** [https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
- **NetBeans Tutorial:** [https://netbeans.apache.org/tutorial/](https://netbeans.apache.org/tutorial/)

### Comunidad y Soporte

- **Stack Overflow - JavaFX:** [https://stackoverflow.com/questions/tagged/javafx](https://stackoverflow.com/questions/tagged/javafx)
- **Oracle Java Community:** [https://community.oracle.com/tech/developers/categories/java](https://community.oracle.com/tech/developers/categories/java)
- **NetBeans Forum:** [https://netbeans.apache.org/community/mailing-lists.html](https://netbeans.apache.org/community/mailing-lists.html)

### Repositorios de Código

- **Ejemplos JavaFX:** [https://github.com/openjfx/samples](https://github.com/openjfx/samples)
- **Maven Archetypes:** [https://github.com/openjfx/javafx-maven-archetypes](https://github.com/openjfx/javafx-maven-archetypes)

---

## 🐧 Instalación en Diferentes Sistemas Operativos

### Linux (Ubuntu/Debian)

```bash
# Instalar NetBeans
sudo snap install netbeans --classic

# Instalar SDKMAN y Java
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install java 24.0.2-amzn

# Verificar instalación
java -version
```

### Windows

1. **NetBeans:**
   - Descargar de [https://netbeans.apache.org/download/](https://netbeans.apache.org/download/)
   - Ejecutar instalador `.exe`

2. **Java 24:**
   - Descargar Amazon Corretto MSI: [https://corretto.aws/downloads/latest/amazon-corretto-24-x64-windows-jdk.msi](https://corretto.aws/downloads/latest/amazon-corretto-24-x64-windows-jdk.msi)
   - Configurar `JAVA_HOME` en Variables de Entorno

3. **Maven:**
   - Incluido en NetBeans
   - O descargar de [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)

### macOS

```bash
# Instalar Homebrew (si no lo tienes)
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

# Instalar SDKMAN y Java
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install java 24.0.2-amzn

# Instalar NetBeans
brew install --cask netbeans
```

---

## ⚙️ Configuración del Proyecto en NetBeans

### Pasos para Abrir el Proyecto

1. Abrir NetBeans 27
2. **File** → **Open Project**
3. Navegar a `/home/usuario/NetBeansProjects/Opsaritmeticas`
4. Seleccionar el proyecto (aparece con icono de Maven)
5. Click en **Open Project**

### Configuración de Java en NetBeans

1. **Tools** → **Java Platforms**
2. Click en **Add Platform**
3. Seleccionar la ruta de Java 24:
   ```
   /home/usuario/.sdkman/candidates/java/24.0.2-amzn
   ```
4. Click en **Finish**

### Configurar Proyecto para Usar Java 24

1. Click derecho en el proyecto → **Properties**
2. **Build** → **Compile**
3. En **Java Platform**, seleccionar **JDK 24**
4. Click en **OK**

---

## 📝 Notas Importantes

### Compatibilidad de Versiones

- **Java 11** es el target de compilación configurado en `pom.xml`
- **Java 24** es compatible para ejecutar el bytecode de Java 11
- **JavaFX 13** funciona correctamente con ambas versiones

### Warnings Esperados

Al ejecutar con Java 24, son normales estos warnings:
```
WARNING: sun.misc.Unsafe::staticFieldBase has been called
```

Estos warnings son informativos y **NO afectan** la funcionalidad de la aplicación.

### Recomendaciones

1. Usar **SDKMAN** para gestionar múltiples versiones de Java
2. Mantener **Maven** actualizado a través de NetBeans
3. Configurar **JAVA_HOME** correctamente para evitar conflictos
4. Ejecutar `mvn clean` antes de cambiar versiones de Java

---

## 📞 Soporte

Para problemas relacionados con el proyecto, consultar:
- **README.md** - Documentación técnica general
- **DOCUMENTACION.md** - Documentación académica completa
- **Issues del proyecto** - Reportar problemas

---

**Última actualización:** Octubre 2025

**Mantenido por:** Maria Guadalupe Ramirez Mazariego
