import React, { useState } from 'react';
import { GoogleMap, useLoadScript, Polygon } from '@react-google-maps/api';
import './SegureZone.css';
import SegureZoneModel from '../../Models/SegureZoneModel';
import { useParams } from 'react-router-dom';
import CaseModel from '../../Models/CaseModel';
import Swal from 'sweetalert2';
import { useEffect } from 'react';
import { useAuth } from '../../AuthContext/AuthContext';
import { useNavigate } from "react-router-dom";


const SegureZone = () => {
  const { caseId } = useParams();
  const [path, setPath] = useState([]);
  const [key, setKey] = useState(0);
  const [nombreZona, setNombreZona] = useState('');
  const { isLoaded } = useLoadScript({
    googleMapsApiKey: "AIzaSyAVCv2edVHkkor2XENUBSsamIXFgMFn8UM",
  });
  const { authState } = useAuth();
  const navigate = useNavigate();

  useEffect(() => {
    if (!authState.isAuthenticated) {
        navigate('/');
        return;
    }
  }, [authState.isAuthenticated, navigate])

  const handleInputChange = (event) => {
    setNombreZona(event.target.value);
  }
  const mapStyles = {        
    height: "75vh",
    width: "100%"
  };
  
  const defaultCenter = {
    lat: 10.505046, lng: -66.899488
  }

  const onMapClick = (e) => {
    setPath([...path, {lat: e.latLng.lat(), lng: e.latLng.lng()}]);
  };

  const clearPath = () => {
    setPath([]);
    setKey(prevKey => prevKey + 1);
  };

  const mapOptions = {
    zoomControl: false, // Desactiva los controles de zoom en el mapa
    scrollwheel: false, // Previene el zoom con la rueda del mouse
    disableDoubleClickZoom: true, // Previene el zoom con doble clic
    gestureHandling: 'greedy' // Desactiva el zoom con gestos táctiles
  };

  const getPoinst = async (event) => {
    console.log(path);

    if(path.length < 3){
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Debe seleccionar al menos 3 puntos para crear una zona segura',
      })
    }else{      
      try {
        const data = await CaseModel.getCaseById(caseId);
        const dataResponse = data.response;
        const idVictima = dataResponse._usuario_victima.id;
        const idUsuario = dataResponse._usuario_victima._usuario.id;

        const addZonaSegura = await SegureZoneModel.addSegureZone(nombreZona, idVictima, idUsuario);

        if(addZonaSegura.success === true){
          const idZonaSegura = addZonaSegura.response.id;

          try {
            for (var i=0; i < path.length; i++) {
              await SegureZoneModel.addCoordenadas(path[i].lat, path[i].lng, idZonaSegura, idVictima, idUsuario);
            }
            Swal.fire({
              icon: 'success',
              title: 'Zona segura creada',
              text: 'La zona segura se ha creado con exito',
            }).then((result) => {
              if (result.isConfirmed) {
                window.location.href = `/cases/${caseId}`;
              }
            })
          } catch (error) {
            Swal.fire({
              icon: 'error',
              title: 'Oops...',
              text: 'Error al añadir las coordenadas',
            })
          }
        }else{
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Error al crear la zona segura',
          })
        }

      } catch (error) {
        console.log(error);
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'No se pudo guardar la zona segura',
        })
      }
    }

    //await CaseModel.addSafeZone(caseId, safeZoneData);

  }

  if (!isLoaded) return <div>Loading...</div>;

  return (
    <>
      <div className='background divView'>
        <div className='divMap'>
          <GoogleMap
            mapContainerStyle={mapStyles}
            zoom={15}
            center={defaultCenter}
            onClick={onMapClick}
            key={key}
            options={mapOptions}
          >
            {path.length >= 1 && (
              <Polygon
                paths={path}
                key={path}
                options={{
                  fillColor: "lightblue",
                  fillOpacity: 0.5,
                  strokeColor: "blue",
                  strokeOpacity: 1,
                  strokeWeight: 2,
                }}
              />
            )}
          </GoogleMap>
        </div>
        <div className='inputs'>
        <input className="form-control" type="text" name="nombreZona" placeholder="Nombre de la Zona" value={nombreZona} onChange={handleInputChange} />
          <button className="btn btn-primary" onClick={clearPath}>Limpiar</button>
          <button className="btn btn-primary" onClick={getPoinst}>Guardar</button>
        </div>
      </div>
    </>
    
  )
}

export default SegureZone;

