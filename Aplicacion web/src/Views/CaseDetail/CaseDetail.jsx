import React, { useState, useEffect } from 'react';
import SafeZoneModel from '../../Models/SegureZoneModel';
import CaseModel from '../../Models/CaseModel';
import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../../AuthContext/AuthContext';

function CaseDetail() {
    const [safeZones, setSafeZones] = useState([]);
    const { caseId } = useParams();
    const navigate = useNavigate();
    const { authState } = useAuth();

    useEffect(() => {
        if (!authState.isAuthenticated) {
            navigate('/');
            return;
        }
    }
    , [authState.isAuthenticated, navigate]);

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
            <div className='background'>
                <div style={{marginBottom: '20px', padding: '10px', borderRadius: '10px'}}>
                    <h1><strong>No hay zonas seguras</strong></h1>
                </div>
                <button className='btn btn-success' onClick={() => handleAddZone()}>Añadir Zona Segura</button>
            </div>
        );
    }

    return (
        <div className='background'>
            {safeZones.map(safeZone => (
                <div key={safeZone.id} className="safe-zone-card" onClick={() => handleCaseClick(safeZone.id)}>
                    <div className="card">
                        <div className="card-body">
                            <h5 className="card-title">{safeZone._nombre}</h5>
                            <p className="card-text">
                                {/* Aquí se pueden añadir mas detalles */}
                            </p>
                        </div>
                    </div>
                </div>
            ))}
            <button className='btn btn-primary' onClick={() => handleAddZone()}>Añadir Zona Segura</button>
        </div>
    );
}

export default CaseDetail;
