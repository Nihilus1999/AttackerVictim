import React from 'react';
import { useState, useEffect } from 'react';
import { useAuth } from '../../AuthContext/AuthContext';
import { useNavigate } from "react-router-dom";
import NotificationModel from '../../Models/NotificationModel';
import './NotificationView.css';

export default function Notification() {
    const { authState } = useAuth();
    const navigate = useNavigate();
    const [notifications, setNotifications] = useState([]);
    const [filter, setFilter] = useState('');
    const formatDate = (milliseconds) => {
        const date = new Date(milliseconds);
        return date.toLocaleString();
    };
    
    useEffect(() => {
        if (!authState.isAuthenticated) {
            navigate('/');
            return;
        }
    }, [authState.isAuthenticated, navigate])

    useEffect(() => {
        const fetchNotifications = async () => {
            const data = await NotificationModel.getAllNotifications();
            if (data) {
                setNotifications(data);
            }
        };

        fetchNotifications();
    }, []);

    return (
        <div className='background'>
            <h1>Notificaciones</h1>
            <div className="mb-3">
                <input 
                    type="text" 
                    className="form-control" 
                    placeholder="Filtrar por usuario" 
                    value={filter} 
                    onChange={(e) => setFilter(e.target.value)}
                />
            </div>
            <div className="container mt-4">
                <table className="table table-striped table-bordered">
                    <thead className="thead-dark">
                        <tr>
                            <th>Fecha</th>
                            <th>Tipo</th>
                            <th>Descripción</th>
                            <th>Usuario</th>
                            {/* Añade más encabezados de columna según sea necesario */}
                        </tr>
                    </thead>
                    <tbody>
                        {notifications.filter(notification => 
                            notification._usuario._nombre.toLowerCase().includes(filter.toLowerCase()) || 
                            notification._usuario._apellido.toLowerCase().includes(filter.toLowerCase())
                        ).map(filteredNotification => (
                            <tr key={filteredNotification.id}>
                                <td>{formatDate(filteredNotification._fecha)}</td>
                                <td>{filteredNotification._tipo}</td>
                                <td>{filteredNotification._descripcion}</td>
                                <td>{`${filteredNotification._usuario._nombre} ${filteredNotification._usuario._apellido}`}</td>
                            </tr>
                        ))}
                        {notifications.length === 0 && (
                            <tr>
                                <td colSpan="3">No hay notificaciones</td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        </div>
    );
    
}