import Url from '../config.js';
export default class UserModel {
    constructor(_nombre, _apellido, _alias, _cedula, _correo, _direccion_mac, _clave, _tipo_usuario) {
        this._nombre = _nombre;
        this._apellido = _apellido;
        this._alias = _alias;
        this._cedula = _cedula;
        this._correo = _correo;
        this._direccion_mac = _direccion_mac;
        this._clave = _clave;
        this._tipo_usuario = _tipo_usuario;
    }

    async addUser() {

        delete this._tipo_usuario;

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

    async updateUser(){

        delete this._tipo_usuario;

        try {
            const response = await fetch(Url() + '/usuario', {
                method: 'PUT',
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
            console.error('Error al actualizar usuario:', error);
            //throw error;
        }
    }

    static async addVictima(id) {

        const victim = {
            "_usuario": {
                "id": id
            }
        }

        try {
            const response = await fetch(Url() + '/victima', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(victim)

            });

            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }

            const data = await response.json();
            console.log(data);
            data.success = true;
            return data;
        } catch (error) {
            console.error('Error al añadir usuarioo:', error);
        }
    }

    static async addAtacante(id) {

        const atacante = {
            "_usuario": {
                "id": id
            }
        }

        try {
            const response = await fetch(Url() + '/atacante', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(atacante)

            });

            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }

            const data = await response.json();
            console.log(data);
            data.success = true;
            return data;
        } catch (error) {
            console.error('Error al añadir usuarioo:', error);
        }
    }

    static async addRelacionVictimaAtacante(idVictima, idAtacante, distancia, idAtackTable, idVictimTable, tiempo) {

        const relacion = {
            "_distancia": distancia,
            "_tiempo": tiempo,
               "_usuario_victima": {
                   "_usuario": {
                       "id": idVictima
                   },
                   "id": idVictimTable
               },
               "_usuario_atacante": {
                   "_usuario": {
                       "id": idAtacante
                   },
                   "id": idAtackTable
               }
        }

        try {
            const response = await fetch(Url() + '/relacion', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(relacion)

            });

            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }

            const data = await response.json();
            console.log(data);
            data.success = true;
            return data;
        } catch (error) {
            console.error('Error al añadir usuarioo:', error);
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

    static async getUserByNick(nick) {
        console.log(Url() + '/usuario/alias/' + nick);
        try {
            const response = await fetch(Url() + '/usuario/alias/' + nick);

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
}