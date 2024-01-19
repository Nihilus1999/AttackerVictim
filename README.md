# AttackerVictim - Grupo C

## Integrantes del Proyecto:

Jose El Asmar, V-27.130.898  
Pedro De Gouveia, V-27.475.935  
Jose Alayon, V-26.546.441  


## 1. Descripcion general del sistema

AttackerVictim es un sistema para el soporte a victimas de agresión, que busca controlar o apoyar las
sentencias emitidas por las autoridades civiles al momento de la atención de estos casos. Para la gestión
de las actividades involucradas en el sistema se deberán desarrollar 4 componentes principales que se
listan a continuación:

### A. Aplicación de Gestión Administrativa (Aplicación Web)

Está aplicación permitirá a las autoridadesgestionar los atributos de control asignados en la sentencia 
como lo son zonas de seguridad, distancias de alejamiento y tiempos de control.

    a) Ingreso o Login Aplicación: El desarrollo de los procesos de ingreso a la aplicación deberá contar con la opción que permita la recuperación de los datos del usuario y la administración de los datos de
    autenticación deberán gestionarse a través del algún sistema de Directorio Activo o LDAP.

    b) Administración de Zonas de Seguridad: Este modulo deberá permitir a los administradores la gestión
    de las zonas de seguridad establecidas para la victima y el agresor luego del análisis de la situación
    realizado por las autorizadas. Estas zonas de seguridad estará conformada por polígonos armados con
    puntos de geográficos de posicionamiento. El objetivo es establecer delimitaciones entre las partes que
    ayuden a evitar los posibles encuentros físicos entre las partes involucradas en la querella.

    c) Administración de Distancias de Alejamiento: Este modulo deberá permitir a los administradores la
    gestión de las distancias mínimas que deberá existir entre los involucrados fuera de las zonas de
    seguridad.

    d) Administración de Tiempos de Control: Este módulo deberá permitir a los administradores la gestión
    de los tiempos de control que se manejan en 2 funcionalidades específicas de la APP.

        Alerta Cuenta Atrás
        Inamovilidad

    e) Gestión de Usuarios: Este módulo deberá permitir a los administradores la gestión de los datos de los
    involucrados definiendo no solo los datos de identidad sino generando los accesos a la aplicación

### B. Aplicación Victima: (Aplicación Móvil)

Está aplicación permitirá llevar el control del posicionamiento, la conectividad, inamovibilidad, cercanía 
del agresor, generar alertas y gestionar puntos de control de seguridad.

    a) Ingreso o Login Aplicación: El desarrollo de los procesos de ingreso a la aplicación deberá contar con
    la opción que permita la recuperación de los datos del usuario y la administración de los datos de
    autenticación deberán gestionarse a través del algún sistema de Directorio Activo o LDAP.

    b) Control de Posicionamiento: La aplicación deberá monitorear en tiempo real la geolocalización del
    dispositivo que la contiene a fin de reportar el tracking de posicionamiento a las autoridades y contar
    con los elementos que le permitan validar las zonas de seguridad y el distanciamiento del agresor.

    c) Conectividad: La aplicación deberá en todo momento comprobar y reportar a las autoridades la
    conectividad del dispositivo móvil con la señal de datos, en caso de no poseer señal de datos deberá
    contar con un mecanismo que registre todos los datos de control de posicionamiento en el dispositivo y
    en la primera oportunidad de envío, reporte el histórico de los datos manejas en modo offline a las
    autoridades.

    d) Cercanía del Agresor: La aplicación deberá poder comprobar que los dispositivos móviles se
    encuentran a una distancia mayor que la que le permita conectarlo por Bluetooth. En caso contrarío
    deberá emitir una alerta sonora y visual a la victima a través del APP y emitir las notificaciones
    correspondientes a las autoridades.

    e) Botón SOS: La aplicación deberá contar con una opción que permita a la victima en cualquier
    momento generar un llamado SOS. Está opción deberá de notificar a las autoridades indicando, fecha,
    hora y geoposición al momento de la solicitud de ayuda.

    f) Puntos de Control: La aplicación deberá contar con una opción que permita a la victima establecer un
    punto de control en el que se inicia la cuenta atrás del tiempo establecido por la aplicación
    administrativa para comprobar que la victima se encuentra bien, cuando el tiempo definido llegue a
    cero la aplicación deberá emitir alerta sonora y de vibración que indiquen a la victima que el tiempo
    que el tiempo de control ha terminado y que se emitieron las alertas correspondientes a las autoridades.

### C. Aplicación Agresor: (Aplicación Móvil)

Está aplicación permitirá llevar el control del posicionamiento, la conectividad, inamovibilidad.

    a) Ingreso o Login Aplicación: El desarrollo de los procesos de ingreso a la aplicación deberá contar con
    la opción que permita la recuperación de los datos del usuario y la administración de los datos de
    autenticación deberán gestionarse a través del algún sistema de Directorio Activo o LDAP.

    b) Control de Posicionamiento: La aplicación deberá monitorear en tiempo real la geolocalización del
    dispositivo que la contiene a fin de reportar el tracking de posicionamiento a las autoridades y contar
    con los elementos que le permitan validar las zonas de seguridad y el distanciamiento de la victima. En
    esta aplicación todo el control de posicionamiento se hace sin mostrar información en el mapa. Solo se
    emitirán alertas (mensajes en pantalla).

    c) Conectividad: La aplicación deberá en todo momento comprobar y reportar a las autoridades la
    conectividad del dispositivo móvil con la señal de datos, en caso de no poseer señal de datos deberá
    contar con un mecanismo que registre todos los datos de control de posicionamiento en el dispositivo y
    en la primera oportunidad de envío, reporte el histórico de los datos manejas en modo offline a las
    autoridades.

### D. API (Conexion entre los dispositivos)
La API se encargar de gestionar las peticiones generales entre los distintos dispostivos del sistema, las
peticiones son Endpoints que envian la informacion en formato JSON mediante un GET, POST, PUT, DELETE.

## 2. Programa de Despliegue - Packetriot:

Es un servicio de túneles inversos y reenvío de puertos que permite a los usuarios exponer sus aplicaciones y servicios en línea de manera segura y confiable. Proporciona una forma sencilla de realizar conexiones salientes a través de firewalls y redes NAT, lo que permite el acceso remoto a servidores y recursos detrás de esas barreras.Las principales características de Packetriot incluyen:

### Túneles inversos: 
Packetriot permite establecer túneles inversos desde una red interna hacia Internet, lo que significa que los servicios y aplicaciones que se ejecutan en una red privada pueden ser accesibles desde cualquier lugar en línea. Esto es especialmente útil en entornos donde se utilizan firewalls o se comparten conexiones de red.

### Reenvío de puertos: 
El servicio permite redirigir puertos específicos de un servidor o dispositivo a través de la red de Packetriot, lo que permite a los usuarios acceder a esos puertos de manera segura desde cualquier lugar. Esto es útil cuando se necesita acceder a servicios específicos, como servidores web, bases de datos o aplicaciones en línea.

### Seguridad: 
Packetriot utiliza conexiones cifradas y autenticación basada en tokens para garantizar la seguridad de las comunicaciones. Los datos transmitidos a través de los túneles están protegidos y solo pueden ser accedidos por las partes autorizadas.

### Facilidad de uso: 
El servicio está diseñado para ser fácil de configurar y utilizar. Proporciona una interfaz sencilla para crear y administrar los túneles, y ofrece opciones de configuración flexibles para adaptarse a diferentes necesidades y entornos.

### Integraciones y herramientas adicionales: 
Packetriot ofrece integraciones con varias herramientas y servicios populares, como Docker, Kubernetes y GitHub. Además, proporciona características adicionales, como registros detallados, métricas y alertas, para facilitar la supervisión y el análisis de los túneles establecidos.
