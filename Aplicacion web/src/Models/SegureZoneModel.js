import Url from '../config.js';
export default class SegureZoneModel {

    static async deleteSegureZonePoints(idZona){
        try {
            const points = await this.getSegureZonePoints(idZona);
            const pointsArray = points.response;
            for (let i = 0; i < pointsArray.length; i++) {
                await this.deleteSegureZonePoint(pointsArray[i].id);
            }
            return true;     
        } catch (error) {
            console.error('Error al eliminar puntos de zona segura:', error);
        }
    }

    static async deleteSegureZonePoint(idPunto){
        try {
            const response = await fetch(Url() + '/coordenadas/' + idPunto, {
                method: 'DELETE'
            });

            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }

            const data = await response.json();
            data.success = true;
            return data;
        } catch (error) {
            console.error('Error al eliminar punto de zona segura:', error);
        }
    }


    static async getSegureZonePoints(idZona){
        try {
            const response = await fetch(Url() + '/coordenadas/zona_segura/' + idZona, {
                method: 'GET'
            });

            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }

            const data = await response.json();
            data.success = true;
            return data;
        } catch (error) {
            console.error('Error al obtener zona segura:', error);
            //throw error;
        }
    }

    static async getZoneByVictimId(id) {
            
        try {
            const response = await fetch(Url() + '/zona_segura/victima/' + id, {
                method: 'GET'
            });

            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }

            const data = await response.json();
            data.success = true;
            return data;
        } catch (error) {
            console.error('Error al obtener zona segura:', error);
            //throw error;
        }
    }

    static async updateSegureZone(nombreZona, idVictima, idUsuario, idZona) {
            
            const segureZone = {
                "_nombre": nombreZona,
                "_victima": {
                    "_usuario": {
                        "id": idUsuario
                    },
                    "id": idVictima
                },
                "id": idZona
            }
    
            try {
                const response = await fetch(Url() + '/zona_segura', {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(segureZone)
    
                });
    
                if (!response.ok) {
                    throw new Error(`Error: ${response.status}`);
                }
    
                const data = await response.json();
                data.success = true;
                return data;
            } catch (error) {
                console.error('Error al actualizar zona segura:', error);
                //throw error;
            }
    }


    static async addSegureZone(nombreZona, idVictima, idUsuario) {

        const segureZone = {
            "_nombre": nombreZona,
            "_victima": {
                "_usuario": {
                    "id": idUsuario
                },
                "id": idVictima
            }
        }

        try {
            const response = await fetch(Url() + '/zona_segura', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(segureZone)

            });

            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }

            const data = await response.json();
            data.success = true;
            return data;
        } catch (error) {
            console.error('Error al añadir zona segura:', error);
            //throw error;
        }
    }

    static async getSegureZone(id) {

        try {
            const response = await fetch(Url() + '/zona_segura/' + id, {
                method: 'GET'
            });

            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }

            const data = await response.json();
            console.log(data);
            data.success = true;
            return data;
        } catch (error) {
            console.error('Error al obtener zona segura:', error);
            //throw error;
        }
    }

    static async addCoordenadas(latitud, longitud, idZona, idVictima, idUsuario) {

        const punto = {
            "_latitud": latitud,
            "_longitud": longitud,
            "_zona_segura": {
                "_victima": {
                    "_usuario": {
                        "id": idUsuario
                    },
                    "id": idVictima
                },
                "id": idZona
            }
        }

        try {
            const response = await fetch(Url() + '/coordenadas', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(punto)
    
            });
    
            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }
    
            const data = await response.json();
            console.log(data);
            data.success = true;
            return data;
        } catch (error) {
            console.error('Error al añadir coordenadas:', error);
            //throw error;
        }
    }

}