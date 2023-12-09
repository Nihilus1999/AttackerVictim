import Url from '../config.js';
export default class UserModel {
    constructor() {
        this.username = "";
        this.password = "";
    }

    async login() {
        const username = this.username;
        const password = this.password;
        console.log(Url() + 'usuario/alias/' + username);
        try {
            const response = await fetch(Url() + '/usuario/alias/' + username, {
                method: 'GET',
            });

            if (!response.ok) {
                throw new Error(`Error en la red. Código de estado: ${response.status}`);
            }

            var data = await response.json();
            if (data.response == null) {
                data.success = false;
            } else if (data.response['_alias'] != password) {
                data.description = 'Contraseña incorrecta';
                data.success = false;
            } else {
                data.success = true;
                console.log(data);
            }

            return data;

        } catch (error) {
            console.error('Hubo un problema con la petición fetch:', error);
        }
    }

}