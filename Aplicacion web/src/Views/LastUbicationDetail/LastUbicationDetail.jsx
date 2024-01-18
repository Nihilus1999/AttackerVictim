import React, { useState, useEffect, useRef  } from 'react';
import { useNavigate, useParams } from "react-router-dom";
import { useAuth } from '../../AuthContext/AuthContext';
import LastUbicationModel from '../../Models/LastUbicationModel';
import { GoogleMap, useLoadScript, Marker } from '@react-google-maps/api';
import atacanteImg from '../../Images/hacker.png';
import victimaImg from '../../Images/objetivo.png';
import './LastUbicationDetail.css';

export default function LastUbicationDetail() {
    const { caseId } = useParams();
    const { authState } = useAuth();
    const navigate = useNavigate();
    const [lastUbicationAtacante, setLastUbicationAtacante] = useState(null);
    const [lastUbicationVictima, setLastUbicationVictima] = useState(null);
    const { isLoaded } = useLoadScript({ googleMapsApiKey: "AIzaSyAVCv2edVHkkor2XENUBSsamIXFgMFn8UM" });
    const mapStyles = { height: "75vh", width: "100%" };
    const defaultCenter = lastUbicationVictima ? 
        { lat: lastUbicationVictima._latitud, lng: lastUbicationVictima._longitud } : 
        { lat: 10.505046, lng: -66.899488 };
    const mapOptions = {
        zoomControl: false,
        scrollwheel: false,
        disableDoubleClickZoom: true,
        gestureHandling: 'greedy'
    };
    const createIcon = (iconUrl) => {
        return {
            url: iconUrl,
            scaledSize: new window.google.maps.Size(40, 40), // Cambia las dimensiones según necesites
            origin: new window.google.maps.Point(0, 0),
            anchor: new window.google.maps.Point(20, 40) // Ajusta para que la base de la imagen esté en la ubicación exacta
        };
    };
    const mapRef = useRef(null);
    const goToAtacante = () => {
        if (lastUbicationAtacante && mapRef.current) {
            mapRef.current.panTo({ lat: lastUbicationAtacante._latitud, lng: lastUbicationAtacante._longitud });
        }
    };
    const goToVictima = () => {
        if (lastUbicationVictima && mapRef.current) {
            mapRef.current.panTo({ lat: lastUbicationVictima._latitud, lng: lastUbicationVictima._longitud });
        }
    };

    useEffect(() => {
        if (!authState.isAuthenticated) {
            navigate('/');
            return;
        }

        const fetchData = async () => {
            const lastUbicationAtacanteData = await LastUbicationModel.getLastUbicationAtacante(caseId);
            setLastUbicationAtacante(lastUbicationAtacanteData.response);

            const lastUbicationVictimaData = await LastUbicationModel.getLastUbicationVictima(caseId);
            setLastUbicationVictima(lastUbicationVictimaData.response);
        };

        fetchData();
    }, [authState.isAuthenticated, caseId, navigate]);

    if (!isLoaded) return <div>Loading...</div>;

    return (
        <div className='background divView'>

            <div className='divMap'>
                <GoogleMap
                    onLoad={map => mapRef.current = map}
                    mapContainerStyle={mapStyles}
                    zoom={15}
                    center={defaultCenter}
                    options={mapOptions}
                >
                    {lastUbicationAtacante && (
                        <Marker
                            position={{ lat: lastUbicationAtacante._latitud, lng: lastUbicationAtacante._longitud }}
                            icon={createIcon(atacanteImg)}
                        />
                    )}
                    {lastUbicationVictima && (
                        <Marker
                            position={{ lat: lastUbicationVictima._latitud, lng: lastUbicationVictima._longitud }}
                            icon={createIcon(victimaImg)}
                        />
                    )}
                </GoogleMap>
            </div>
            <div className='row' style={{backgroundColor: 'white', marginTop: '20px', boxShadow: '0px 0px 6px 0px black', borderRadius: '10px', padding: '20px'}}>
                <div className='col' style={{display: 'flex', flexDirection: 'column'}} onClick={goToAtacante}>
                    <img src={atacanteImg} style={{width: '100px'}}/>
                    <h3>Atacante</h3>
                </div>
                <div className='col' style={{display: 'flex', flexDirection: 'column'}} onClick={goToVictima}>
                    <img src={victimaImg} style={{width: '100px'}}/>   
                    <h3>Victima</h3>
                </div>
            </div>
        </div>
    );
}

