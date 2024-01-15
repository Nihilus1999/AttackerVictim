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

    static async addSafeZone(caseId, safeZoneData) {
        // Aquí iría la lógica para añadir una zona segura a un caso específico
    }
}

export default CaseModel;
