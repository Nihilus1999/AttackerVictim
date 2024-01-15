import React, { useState, useEffect } from 'react';
import CaseModel from '../Models/CaseModel';
import { useNavigate } from 'react-router-dom';

function CasesController() {
    const [cases, setCases] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        const fetchCases = async () => {
            const casesData = await CaseModel.getAllCases();
            console.log(casesData.response);
            setCases(casesData.response);
        };
        fetchCases();
    }, []);

    const handleCaseClick = (caseId) => {
        navigate(`/cases/${caseId}`);
    };

    if (!cases){
        return (
            <div>
                No hay casos
            </div>
        );
    }

    return (
        <div>
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

export default CasesController;
