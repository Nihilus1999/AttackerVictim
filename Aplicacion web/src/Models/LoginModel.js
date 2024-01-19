import Url from '../config.js';
export default class UserModel {
    constructor() {
        this.username = "";
        this.password = "";
    }

    async login() {
        const username = this.username;
        const password = this.password;
        
        const body = {
            _alias: username,
            _clave: password
        }

        console.log(Url() + '/login/administrador');
        console.log(body);
        var response = null;
        

        try {
            response = await fetch(Url() + '/login/administrador', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(body)

            });
            

            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }

            const data = await response.json();

            if (data.response == null) {
                data.success = false;
            }else{
                data.success = true;
            }
            return data;
        } catch (error) {
            return response.status;
            //throw error;
        }

        // console.log(Url() + '/administrador/alias/' + username);

        // try {
        //     const response = await fetch(Url() + '/administrador/alias/' + username, {
        //         method: 'GET',
        //     });

        //     if (!response.ok) {
        //         throw new Error(`Error en la red. Código de estado: ${response.status}`);
        //     }

        //     var data = await response.json();
        //     console.log(data);
        //     if (data.response == null) {
        //         data.success = false;
        //     } else if (data.response['_clave'] != password) {
        //         data.description = 'Contraseña incorrecta';
        //         data.success = false;
        //     } else {
        //         data.success = true;
        //         console.log(data);
        //     }

        //     return data;

        // } catch (error) {
        //     console.error('Hubo un problema con la petición fetch:', error);
        // }
    }

}