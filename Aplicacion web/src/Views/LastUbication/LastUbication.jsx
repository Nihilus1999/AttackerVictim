import React from 'react';
import { useState, useEffect } from 'react';
import { useAuth } from '../../AuthContext/AuthContext';
import { useNavigate } from "react-router-dom";
import CaseModel from '../../Models/CaseModel';

export default function LastUbication() {

    const { authState } = useAuth();
    const navigate = useNavigate();
    const [cases, setCases] = useState([]);

    useEffect(() => {
        if (!authState.isAuthenticated) {
            navigate('/');
            return;
        }
    }, [authState.isAuthenticated, navigate]);

    useEffect(() => {
        const fetchCases = async () => {
            const casesData = await CaseModel.getAllCases();
            console.log(casesData.response);
            setCases(casesData.response);
        };
        fetchCases();
    }, []);

    const handleCaseClick = (caseId) => {
        navigate(`/casesLastUbication/${caseId}`);
    };

    if (!cases){
        return (
            <div>
                No hay casos
            </div>
        );
    }

    return (
        <div className='background'>
            {cases.map(caseItem => (
                <div key={caseItem.id} onClick={() => handleCaseClick(caseItem.id)}>
                    <div className="row">
                        <div className="col-sm-6 mb-3 mb-sm-0">
                            <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">Caso #{caseItem.id}</h5>
                                <p className="card-text">
                                    <strong>Victima del caso:</strong> {caseItem._usuario_victima._usuario._nombre} {caseItem._usuario_victima._usuario._apellido} <br />
                                    <strong>Atacante del caso:</strong> {caseItem._usuario_atacante._usuario._nombre} {caseItem._usuario_atacante._usuario._apellido}
                                </p>
                            </div>
                            </div>
                        </div>
                    </div>
                </div>
            ))}
        </div>
    );
}
