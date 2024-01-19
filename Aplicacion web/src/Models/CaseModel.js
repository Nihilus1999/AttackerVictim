import Url from '../config.js';

class CaseModel {


    static async getAllCases() {
        let response = await fetch(Url() + '/relacion/todos');
        let data = await response.json();
        return data;
    }

    static async getCaseById(id) {
        let response = await fetch(Url() + '/relacion/' + id);
        let data = await response.json();
        return data;
    }

    static async updateCase(distancia, tiempo, idUsuarioVictima, idUsuarioAtacante, idVictima , idAtacante, idCaso) {

        const datos = {
            "_distancia": distancia,
            "_tiempo": tiempo,
               "_usuario_victima": {
                   "_usuario": {
                       "id": idUsuarioVictima
                   },
                   "id": idVictima
               },
               "_usuario_atacante": {
                   "_usuario": {
                       "id": idUsuarioAtacante
                   },
                   "id": idAtacante
               },
               "id": idCaso
           }

        try {
            const response = await fetch(Url() + '/relacion', {
                method: 'PUT',
                body: JSON.stringify(datos),
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            console.log(response);
            const data = await response.json();
            data.success = true;
            return data;
        } catch (error) {
            console.log(error);
        }

    }
}

export default CaseModel;
