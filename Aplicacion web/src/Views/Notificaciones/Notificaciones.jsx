import React, { useEffect, useState } from 'react';
import NotificationModel from '../../Models/NotificationModel.js';
import Swal from 'sweetalert2';

const NotificationComponent = () => {
    var lastChecked = useState();

    const checkForNotifications = async () => {
        try {
            const response = await NotificationModel.getNotifications();
        
            console.log(response);
            console.log('ultimoGuardado: ',lastChecked);
            console.log('ID actual: ', response.id);

            if((response !== null) && (response.id !== lastChecked)){

                if(response._tipo === 'Alerta 1'){
                    Swal.fire({
                        title: 'Alerta 1',
                        text: 'El usuario ' + response._usuario._nombre + ' ' + response._usuario._apellido + ' está en peligro',
                        icon: 'warning',
                        confirmButtonText: 'Aceptar'
                    });
                }
                lastChecked = response.id;
            }

        } catch (error) {
            console.error('Error al verificar notificaciones', error);
        }
    };

    // useEffect(() => {
    //     const interval = setInterval(checkForNotifications, 5000); // Revisa cada 5 segundos
    //     console.log('hola');
    //     return () => clearInterval(interval);
    // }, []);

    return <></>;
};

export default NotificationComponent;
