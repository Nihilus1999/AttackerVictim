# 🛡️ AttackerVictim — Grupo C

Sistema integral para el **seguimiento y control de medidas de protección a víctimas de agresión**, desarrollado como proyecto académico.  
Permite la **gestión de zonas seguras, distancias, tiempos de control y alertas** mediante aplicaciones web y móviles conectadas a una API central.

---

## 👥 Integrantes del Proyecto

- **José El Asmar** — V-27.130.898  
- **Pedro De Gouveia** — V-27.475.935  
- **José Alayón** — V-26.546.441  

---

## 🧠 Descripción General

**AttackerVictim** se compone de cuatro módulos principales:

1. 🖥️ **Aplicación Web Administrativa:**  
   Permite a las autoridades gestionar zonas de seguridad, distancias y usuarios.

2. 📱 **Aplicación Víctima:**  
   Supervisa posición, conexión y cercanía del agresor. Incluye botón SOS.

3. 📲 **Aplicación Agresor:**  
   Monitorea ubicación y cumplimiento de distancias sin mostrar mapas.

4. 🔗 **API Central:**  
   Gestiona la comunicación entre dispositivos y el sistema web.

---


## ⚙️ Tecnologías Principales

### 🌐 Aplicación Web (Administración)

- ⚛️ **React 18 + Vite 4** — Framework rápido para el desarrollo de interfaces modernas  
- 🗺️ **Leaflet / React Leaflet** — Visualización interactiva de mapas y zonas de seguridad  
- 📍 **@react-google-maps/api** — Integración con mapas de Google  
- 💅 **Bootstrap 5** — Estilos responsivos y diseño moderno  
- 🔔 **SweetAlert2** — Alertas y notificaciones elegantes  
- 🚦 **React Router DOM** — Navegación y control de rutas  
- 🔧 **ESLint + SWC Plugin** — Linter y compilador rápido para optimización del código  

---

### 📱 Aplicaciones Móviles (Víctima y Agresor)

- ⚛️ **React Native + Expo** — Desarrollo multiplataforma Android / iOS  
- 📍 **Expo Location / React Native Maps** — Seguimiento y trazado de ubicación  
- 🔒 **Axios** — Comunicación con la API REST  
- 🧭 **React Navigation** — Manejo estructurado de pantallas  
- 🌐 **React Native Geolocation Service** — Validación de posición en tiempo real  
- 🧠 **React Native Screens / Safe Area Context** — Optimización visual y compatibilidad de interfaz  

---

### 🔧 Backend / API
- 🧠 **Java EE** — Lógica de negocio y endpoints  
- 🗄️ **PostgreSQL** — Base de datos central  
- 🔐 **JWT** — Autenticación segura  

---
