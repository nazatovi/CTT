\# AdminISP Mobile



\## Filosofía



AdminISP Mobile es una herramienta desarrollada para técnicos de ISP con el objetivo de reemplazar la notebook en la mayor cantidad posible de tareas de campo.



La aplicación prioriza:



\- rapidez

\- simplicidad

\- confiabilidad

\- reutilización de componentes

\- arquitectura mantenible



\---



\# Arquitectura



Patrón utilizado:



MVVM



\## Capas



model/



Contiene los modelos de datos.



repository/



Responsable de acceder a la información (API, HTML, etc.).



viewmodel/



Contiene la lógica de presentación y el estado de la UI.



ui/



Pantallas y componentes Compose.



util/



Utilidades compartidas.



network/



Retrofit, OkHttp y comunicación HTTP.



\---



\# Estado global



AppViewModel mantiene:



\- Suscriptor seleccionado

\- Equipo seleccionado



No deben crearse ViewModels globales adicionales.



\---



\# Principios



\- Un Repository por dominio.

\- Un ViewModel por pantalla.

\- Componentes reutilizables.

\- Ninguna pantalla accede directamente a Retrofit.

\- Ningún Repository conoce Compose.

\- Toda navegación pasa por Navigation Compose.



\---



\# Objetivo



Construir una herramienta profesional para técnicos de CTT que permita administrar clientes e infraestructura desde dispositivos móviles.

