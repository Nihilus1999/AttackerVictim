import Url from '../config.js';
export default class UserModel {
    constructor(_nombre, _apellido, _alias, _cedula, _correo, _direccion_mac, _clave) {
        this._nombre = _nombre;
        this._apellido = _apellido;
        this._alias = _alias;
        this._cedula = _cedula;
        this._correo = _correo;
        this._direccion_mac = _direccion_mac;
        this._clave = _clave;
    }

    async addUser() {

        try {
            const response = await fetch(Url() + '/usuario', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this)

            });

            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }

            const data = await response.json();
            console.log(data);
            data.success = true;
            return data;
        } catch (error) {
            console.error('Error al añadir usuario:', error);
            //throw error;
        }
    }

    static async getAllUsers() {
        try {
            const response = await fetch(Url() + '/usuario/todos');

            if (!response.ok) {
                throw new Error(`Error en la solicitud HTTP: ${response.status}`);
            }
            const data = await response.json();
            console.log(data);
            data.success = true;
            return data;
        } catch (error) {
            console.error('Error al obtener los usuarios:', error);
            //throw error;
        }
    }

    static async getUser(userId) {
        console.log(Url() + '/usuario/' + userId);
        try {
            const response = await fetch(Url() + '/usuario/' + userId);

            if (!response.ok) {
                throw new Error(`Error en la solicitud HTTP: ${response.status}`);
            }
            const data = await response.json();
            console.log(data);
            data.success = true;
            return data;
        } catch (error) {
            console.error('Error al obtener los usuarios:', error);
            //throw error;
        }
    }

    static async deteteUser(user) {
        user['_activate'] = false;
        console.log(user);
        if (window.confirm('¿Estás seguro de que quieres desactivar este usuario?')) {
            try {
                const response = await fetch(Url() + `/usuario`, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(user)
                });

                if (!response.ok) {
                    throw new Error(`Error: ${response.status}`);
                }

                const data = await response.json();
                data.success = true;
                console.log('datazo: ', data);
                return data;

            } catch (error) {
                console.error('Error al actualizar el usuario:', error);
                // Manejar el error
            }
        }
    }

    static async updateUser(userId, userData) {
        console.log('entro al update: ', userData);
        try {
            const response = await fetch(Url() + `/usuario `, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(userData)
            });

            if (!response.ok) {
                throw new Error(`
                        Error: $ { response.status }
                        `);
            }

            return await response.json();
        } catch (error) {
            console.error('Error al actualizar el usuario:', error);
            throw error;
        }
    }
}