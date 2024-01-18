import Url from '../config.js';

export default class NotificationModel {
    static async getNotifications() {
        try {
            const response = await fetch(Url() + '/notificacion/todos', {
                method: 'GET',
            });

            if (!response.ok) {
                throw new Error(`Error en la red. Código de estado: ${response.status}`);
            }

            var data = await response.json();

            if (data.response.length > 0) {
                const lastNotification = data.response[data.response.length - 1];
                return lastNotification;
            } else {
                return null;
            }

        } catch (error) {
            console.error('Hubo un problema con la petición fetch:', error);
        }
    }

    static async getAllNotifications() {
        try {
            const response = await fetch(Url() + '/notificacion/todos', {
                method: 'GET',
            });

            if (!response.ok) {
                throw new Error(`Error en la red. Código de estado: ${response.status}`);
            }

            var data = await response.json();

            if (data.response.length > 0) {
                return data.response;
            } else {
                return null;
            }

        } catch (error) {
            console.error('Hubo un problema con la petición fetch:', error);
        }
    
    }

}
