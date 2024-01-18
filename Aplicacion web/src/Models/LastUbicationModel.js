import Url from '../config.js';

export default class LastUbicationModel {

    static async getLastUbicationAtacante(id) {

        try {
            let response = await fetch(Url() + '/operaciones/atacante_posicion/' + id);
            let data = await response.json();
            return data;
        } catch (error) {
            console.log(error);
        }

    }
    
    static async getLastUbicationVictima(id) {

        try {
            let response = await fetch(Url() + '/operaciones/victima_posicion/' + id);
            let data = await response.json();
            return data;
        } catch (error) {
            console.log(error);
        }

    }

}