import Url from '../config.js';
export default class UserModel {
    constructor(nombres, apellidos, username, cedula, correo, mac, tipoUsuario, contraseña) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.username = username;
        this.cedula = cedula;
        this.correo = correo;
        this.mac = mac;
        this.tipoUsuario = tipoUsuario;
        this.contraseña = contraseña;
    }

    async addUser() {
        console.log('hola');
        try {
            const response = await fetch('http://localhost:8080/usuarios', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this)

            });

            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }

            return await response.json();
        } catch (error) {
            console.error('Error al añadir usuario:', error);
            throw error;
        }
    }
}