Aquí tienes un README.md profesional optimizado para el repositorio BlogDeNotasJava 👇

📝 BlogDeNotasJava

Un editor de texto ligero desarrollado en Java utilizando Swing, que permite crear, abrir y guardar archivos .txt mediante una interfaz gráfica intuitiva.

📌 Descripción

BlogDeNotasJava es una aplicación de escritorio tipo Notepad que demuestra conceptos fundamentales de:

Programación Orientada a Objetos (POO)

Desarrollo de interfaces gráficas con Swing

Manejo de eventos (Event Handling)

Lectura y escritura de archivos en Java

Uso de menús y atajos de teclado

Este proyecto está diseñado con fines educativos para comprender cómo funcionan las aplicaciones GUI en Java desde cero.

🚀 Características
📁 Gestión de Archivos

Abrir archivos .txt

Guardar archivo actual

Guardar como (Save As)

Validación automática de extensión .txt

Control del archivo actual mediante currentFile

✏ Edición de Texto

Cut (Ctrl + X)

Copy (Ctrl + C)

Paste (Ctrl + V)

Ajuste automático de línea

Scroll vertical permanente

🧭 Interfaz

Barra de menú (File, Edit, Help)

Atajos de teclado

Mnemonics (Alt + F, Alt + E, etc.)

Diálogo "About"

Diseño limpio y minimalista

🛠 Tecnologías Utilizadas

Java 17+

Swing (javax.swing)

AWT (java.awt)

Java IO (FileReader, FileWriter)

📂 Estructura del Proyecto
BlogDeNotasJava
│
└── src/
    └── com/mycompany/menubarexample/
        └── myFrame.java

🧠 Conceptos Técnicos Aplicados
1️⃣ Interfaz Gráfica

JFrame

JTextArea

JScrollPane

JMenuBar

JMenu

JMenuItem

JFileChooser

JOptionPane

2️⃣ Eventos

ActionListener

ActionEvent

Aceleradores con KeyStroke

Mnemonics con KeyEvent

3️⃣ Manejo de Archivos

File

FileReader

FileWriter

try-with-resources

Manejo de excepciones (IOException)

▶ Cómo Ejecutarlo
🖥 Desde un IDE (Recomendado)

Abrir el proyecto en NetBeans / IntelliJ / Eclipse.

Ejecutar la clase myFrame.

Se abrirá la ventana del editor.

💻 Desde la terminal

Compilar:

javac myFrame.java


Ejecutar:

java myFrame

🔍 Funcionamiento del Guardado
Save

Si currentFile es null, llama automáticamente a Save As.

Si el archivo ya existe, sobrescribe el contenido actual.

Save As

Abre JFileChooser.

Verifica que el archivo termine en .txt.

Guarda el contenido del JTextArea.

Actualiza currentFile.

📸 Vista General

Área de texto con fuente Consolas

Fondo claro

Scroll vertical siempre visible

Edición fluida y rápida

📈 Posibles Mejoras Futuras

Opción "New File"

Detección de cambios no guardados

Modo oscuro

Contador de líneas y columnas

Soporte UTF-8 explícito

Función de búsqueda

Arquitectura MVC

👨‍💻 Autor

Niko
Desarrollado con Java + Swing
2026

📜 Licencia

Proyecto educativo.
Libre para modificar y mejorar.
