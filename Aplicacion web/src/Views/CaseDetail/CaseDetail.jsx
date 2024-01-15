import React, { useState, useEffect } from 'react';
import SafeZoneModel from '../../Models/SegureZoneModel';
import CaseModel from '../../Models/CaseModel';
import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';

function CaseDetail() {
    const [safeZones, setSafeZones] = useState([]);
    const { caseId } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        const fetchSafeZones = async () => {
            const data = await CaseModel.getCaseById(caseId);
            const dataResponse = data.response;
            const idVictima = dataResponse._usuario_victima.id;

            const safeZonesData = await SafeZoneModel.getZoneByVictimId(idVictima);
            setSafeZones(safeZonesData.response);
        };
        fetchSafeZones();
    }, [caseId]);

    const handleCaseClick = (zoneId) => {
        navigate(`/segure-zone/${zoneId}/case/${caseId}`);
    }

    const handleAddZone = () => {
        navigate(`/add-segure-zone/${caseId}`);
    }

    if (!safeZones){
        return (
            <div>
                <div>
                    No hay zonas seguras
                </div>
                <button className='btn btn-success' onClick={() => handleAddZone()}>Añadir Zona Segura</button>
            </div>
        );
    }

    return (
        <div>
            {safeZones.map(safeZone => (
                <div key={safeZone.id} className="safe-zone-card" onClick={() => handleCaseClick(safeZone.id)}>
                    <div className="card">
                        <div className="card-body">
                            <h5 className="card-title">{safeZone._nombre}</h5>
                            <p className="card-text">
                                {/* Aquí puedes añadir más detalles de la zona segura */}
                            </p>
                        </div>
                    </div>
                </div>
            ))}
            <button className='btn btn-success' onClick={() => handleAddZone()}>Añadir Zona Segura</button>
        </div>
    );
}

export default CaseDetail;
