import React, { useState, useEffect } from 'react';
import CaseModel from '../../../Models/CaseModel';
import { useParams, useNavigate } from 'react-router-dom';
import Swal from 'sweetalert2';
import UserModel from '../../../Models/UserModel';

function EditUserController() {
  const { userId } = useParams();
  const navigate = useNavigate();
  const [caseData, setCaseData] = useState(null);
    
  useEffect(() => {
    const fetchCase = async () => {
        const data = await CaseModel.getCaseById(userId);
        if (data && data.response) {
            setCaseData(data.response);
        }
    };
    fetchCase();
  }, [userId]);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    const keys = name.split('.'); // Divide el nombre del input en partes

    setCaseData(prevCaseData => {
        let updatedData = { ...prevCaseData };
        let currentLevel = updatedData; // Comienza en el nivel superior

        // Recorre las claves excepto la última
        for (let i = 0; i < keys.length - 1; i++) {
            currentLevel[keys[i]] = { ...currentLevel[keys[i]] }; // Copia el subnivel
            currentLevel = currentLevel[keys[i]]; // Avanza al siguiente subnivel
        }

        // Actualiza el valor en el nivel más profundo
        currentLevel[keys[keys.length - 1]] = value;

        return updatedData;
    });
};

  const handleSubmit = async (event) => {
    event.preventDefault(caseData);
    try {
        console.log('aQUI: ', caseData);

        const victim = new UserModel(
          caseData._usuario_victima._usuario._nombre,
          caseData._usuario_victima._usuario._apellido,
          caseData._usuario_victima._usuario._alias,
          caseData._usuario_victima._usuario._cedula,
          caseData._usuario_victima._usuario._correo,
          caseData._usuario_victima._usuario._direccion_mac,
          caseData._usuario_victima._usuario._clave,
          caseData._usuario_victima._usuario._activate,
          1
        ); 

        const atack = new UserModel(
          caseData._usuario_atacante._usuario._nombre,
          caseData._usuario_atacante._usuario._apellido,
          caseData._usuario_atacante._usuario._alias,
          caseData._usuario_atacante._usuario._cedula,
          caseData._usuario_atacante._usuario._correo,
          caseData._usuario_atacante._usuario._direccion_mac,
          caseData._usuario_atacante._usuario._clave,
          caseData._usuario_atacante._usuario._activate,
          2
        );

        victim.id = caseData._usuario_victima._usuario.id;
        atack.id = caseData._usuario_atacante._usuario.id;


        const distancia = caseData._distancia;
        const tiempo = caseData._tiempo;

        console.log('Victima: ', victim);
        console.log('Atacante: ', atack);

        //EDITAR VICTIMA
        const data = await victim.updateUser();
        console.log(data);
        if(data.success) {
          //EDITAR ATACANTE
          const data2 = await atack.updateUser();
          if(data2.success) {
            //AÑADIR RELACION CON DISTANCIA
            const data3 = await CaseModel.updateCase(distancia, tiempo, caseData._usuario_victima._usuario.id, caseData._usuario_victima._usuario.id,  caseData._usuario_victima.id, caseData._usuario_atacante.id, caseData.id);
            if(data3.success) {
              Swal.fire({
                title: 'Hecho!',
                text: 'Se ha registrado el caso correctamente!',
                icon: 'success',
                confirmButtonText: 'Seguir'
              }).then((result) => {
                if (result.isConfirmed) {
                  window.location.href = '/dashboard';
                }
              });
            } else {
              console.log("Error al añadir relacion:", data3);
            }
          } else {
            console.log("Error al editar usuario atacante:", data2);
          }
        } else {
          console.log("Error al editar usuario victima:", data);
        }
    } catch (error) {
      console.log(error);
        Swal.fire({
            title: 'Error',
            text: 'Hubo un problema al actualizar el caso',
            icon: 'error'
        });
    }
  };

  if (!caseData) {
    return <div className='background'>Cargando...</div>; // Muestra un mensaje de carga mientras caseData es null
  }

    return (
      <div className='background'>
        <form onSubmit={handleSubmit} className='formulario'>
          <div className='background2'>
            <div className='row colBackground'>
              <h1>Datos de Victima</h1>
              <input className="form-control" type="text" name="_usuario_victima._usuario._nombre" placeholder='Nombres' value={caseData._usuario_victima._usuario._nombre} onChange={handleInputChange} />
              <input className="form-control" type="text" name="_usuario_victima._usuario._apellido" placeholder='Apellidos' value={caseData._usuario_victima._usuario._apellido} onChange={handleInputChange} />
              <input className="form-control" type="text" name="_usuario_victima._usuario._alias" placeholder='Username' value={caseData._usuario_victima._usuario._alias} onChange={handleInputChange} disabled />
              <input className="form-control" type="text" name="_usuario_victima._usuario._cedula" placeholder='Cedula' value={caseData._usuario_victima._usuario._cedula} onChange={handleInputChange} />
              <input className="form-control" type="text" name="_usuario_victima._usuario._correo" placeholder='Correo' value={caseData._usuario_victima._usuario._correo} onChange={handleInputChange} />
              <input className="form-control" type="text" name="_usuario_victima._usuario._direccion_mac" placeholder='MAC' value={caseData._usuario_victima._usuario._direccion_mac} onChange={handleInputChange} />
              <input className="form-control" type="password" name="_usuario_victima._usuario._clave" placeholder='Contraseña' value={caseData._usuario_victima._usuario._clave} onChange={handleInputChange} />
            </div>
            <div className='row colBackground'>
              <h1>Datos de Atacante</h1>
              <input className="form-control" type="text" name="_usuario_atacante._usuario._nombre" placeholder='Nombres' value={caseData._usuario_atacante._usuario._nombre} onChange={handleInputChange} />
              <input className="form-control" type="text" name="_usuario_atacante._usuario._apellido" placeholder='Apellidos' value={caseData._usuario_atacante._usuario._apellido} onChange={handleInputChange} />
              <input className="form-control" type="text" name="_usuario_atacante._usuario._alias" placeholder='Username' value={caseData._usuario_atacante._usuario._alias} onChange={handleInputChange} disabled />
              <input className="form-control" type="text" name="_usuario_atacante._usuario._cedula" placeholder='Cedula' value={caseData._usuario_atacante._usuario._cedula} onChange={handleInputChange} />
              <input className="form-control" type="text" name="_usuario_atacante._usuario._correo" placeholder='Correo' value={caseData._usuario_atacante._usuario._correo} onChange={handleInputChange} />
              <input className="form-control" type="text" name="_usuario_atacante._usuario._direccion_mac" placeholder='MAC' value={caseData._usuario_atacante._usuario._direccion_mac} onChange={handleInputChange} />
              <input className="form-control" type="password" name="_usuario_atacante._usuario._clave" placeholder='Contraseña' value={caseData._usuario_atacante._usuario._clave} onChange={handleInputChange} />
            </div>
            <div className='row colBackground'>
              <h1>Distancia máxima de acercamiento</h1>
              <input className="form-control" type="number" name="_distancia" placeholder='Distancia' value={caseData._distancia} onChange={handleInputChange} />
            </div>
            <div className='row colBackground'>
              <h1>Tiempo de Control</h1>
              <input className="form-control" type="number" name="_tiempo" placeholder='Tiempo (Segundos)' value={caseData._tiempo} onChange={handleInputChange} />
            </div>
          
            <button className='btn btn-primary' type="submit">Editar Caso</button>
          </div>
        </form>
      </div>
    );
}

export default EditUserController;
