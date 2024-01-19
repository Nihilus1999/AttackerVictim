package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.coordenada.composite.GetAllCoordenadaCommand;
import com.ucab.cmcapp.logic.commands.operaciones.GetPosicionAtacanteByRelacionIdCommand;
import com.ucab.cmcapp.logic.commands.operaciones.GetPosicionByRelacionIDCommand;
import com.ucab.cmcapp.logic.commands.operaciones.GetPosicionVictimaByRelacionIdCommand;
import com.ucab.cmcapp.logic.commands.relacion_VA.composite.GetRelacionCommand;
import com.ucab.cmcapp.logic.commands.zona_segura.atomic.GetZonaByVictimaIdCommand;
import com.ucab.cmcapp.logic.dtos.dtos.*;
import com.ucab.cmcapp.logic.dtos.extras.AtacanteDentroZonaSeguraDto;
import com.ucab.cmcapp.logic.dtos.extras.CalcularDistanciaSeparacionDto;
import com.ucab.cmcapp.logic.dtos.extras.DeterminarAtacanteZonaSeguraDto;
import com.ucab.cmcapp.logic.mappers.CoordenadaMapper;
import com.ucab.cmcapp.logic.mappers.Historico_UsuarioMapper;
import com.ucab.cmcapp.logic.mappers.Relacion_VAMapper;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.mappers.Zona_SeguraMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/operaciones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OperacionesService extends BaseService {

    /**
     * Obtiene la distancia de separación entre dos posiciones a partir del ID de una relación Victima-Atacante.
     *
     * @param relacionId ID de la relación Victima-Atacante.
     * @return Respuesta HTTP con la distancia de separación o un mensaje de error.
     */
    @GET
    @Path("distancia-separacion/{id_relacion_va}")
    public Response getDistanciaSeparacionByRelacionId(@PathParam("id_relacion_va") long relacionId) {
        Relacion_VA entity;
        List<Historico_UsuarioDto> responseDTO = null;
        GetPosicionByRelacionIDCommand command = null;
        double distanciaSeparacion;

        try {
            entity = Relacion_VAMapper.mapDtoToEntity(relacionId);
            command = CommandFactory.createGetPosicionByRelacionIDCommand(entity);
            command.execute();

            if (command.getReturnParam() != null) {
                responseDTO = Historico_UsuarioMapper.mapEntityListToDtoList(command.getReturnParam());
                distanciaSeparacion = new CalcularDistanciaSeparacionDto().calcularDistanciaSeperacion(responseDTO.get(0), responseDTO.get(1));

            } else

                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El ID "+ relacionId +" de la entidad Relacion_Victima-Atacante no existe en la BBDD")).build();

        } catch (Exception e) {

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("No se puede calcular la distancia con el ID "+ relacionId +" de la entidad Relacion_Victima-Atacante" + e.getMessage())).build();

        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(distanciaSeparacion, "La distancia se ha obtenido correctamente")).build();

    }

    /**
     * Obtiene la última ubicación del atacante a partir del ID de una relación Victima-Atacante.
     *
     * @param relacionId ID de la relación Victima-Atacante.
     * @return Respuesta HTTP con la última ubicación del atacante o un mensaje de error.
     */
    @GET
    @Path("atacante_posicion/{relacion_id}")
    public Response getPosicionAtacanteByRelacionId(@PathParam("relacion_id") long relacionId) {
        Relacion_VA entity;
        Historico_UsuarioDto responseDTO = null;
        GetPosicionAtacanteByRelacionIdCommand command = null;

        try {
            entity = Relacion_VAMapper.mapDtoToEntity(relacionId);
            command = CommandFactory.createGetPosicionAtacanteByRelacionIdCommand(entity);
            command.execute();

            if (command.getReturnParam() != null) {
                responseDTO = Historico_UsuarioMapper.mapEntityToDto(command.getReturnParam());
            } else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El ID "+ relacionId +" de la entidad Relacion_Victima-Atacante no existe en la BBDD")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("No se puede calcular la distancia con el ID "+ relacionId +" de la entidad Relacion_Victima-Atacante" + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "Se ha obtenido la ultima ubicacion del atacante correctamente")).build();
    }

    /**
     * Obtiene la última ubicación de la víctima a partir del ID de una relación Victima-Atacante.
     *
     * @param relacionId ID de la relación Victima-Atacante.
     * @return Respuesta HTTP con la última ubicación de la víctima o un mensaje de error.
     */
    @GET
    @Path("victima_posicion/{relacion_id}")
    public Response getPosicionVictimaByRelacionId(@PathParam("relacion_id") long relacionId) {
        Relacion_VA entity;
        Historico_UsuarioDto responseDTO = null;
        GetPosicionVictimaByRelacionIdCommand command = null;

        try {
            entity = Relacion_VAMapper.mapDtoToEntity(relacionId);
            command = CommandFactory.createGetPosicionVictimaByRelacionIdCommand(entity);
            command.execute();

            if (command.getReturnParam() != null) {
                responseDTO = Historico_UsuarioMapper.mapEntityToDto(command.getReturnParam());
            } else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El ID "+ relacionId +" de la entidad Relacion_Victima-Atacante no existe en la BBDD")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("No se puede calcular la distancia con el ID "+ relacionId +" de la entidad Relacion_Victima-Atacante" + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "Se ha obtenido la ultima ubicacion de la victima correctamente")).build();
    }

    /**
     * Determina si el atacante se encuentra dentro de una zona segura a partir del ID de una relación Victima-Atacante.
     *
     * @param incidentId ID de la relación Victima-Atacante.
     * @return Respuesta HTTP con el resultado de la verificación o un mensaje de error.
     */
    @GET
    @Path("atacante_dentro_Zona_Segura/{relacion_id}")
    public Response getAtacanteEnZonaSegura(@PathParam("relacion_id") long incidentId) {

        //definicion de variables para relacion_va
        Relacion_VA relacionEntity;
        Relacion_VADto relacionDto = null;
        GetRelacionCommand relacionCommand = null;

        //definicion de variables para zona_segura
        Zona_Segura zonaEntity;
        List<Zona_SeguraDto> zonaDto = null;
        GetZonaByVictimaIdCommand zonaCommand = null;

        //definicion de variables para el historico
        Historico_UsuarioDto historyDto = null;
        GetPosicionAtacanteByRelacionIdCommand attackerPositionCommand = null;


        //definicion de variables para las coordenadas
        List <CoordenadaDto> coordenadaDto = null;
        GetAllCoordenadaCommand coordenadaCommand = null;

        //resultado del json
        AtacanteDentroZonaSeguraDto resultDto;


        try {

            //obtener el id de la victima apatir del id de la relacion_va

            relacionEntity = Relacion_VAMapper.mapDtoToEntity(incidentId);
            relacionCommand = CommandFactory.createGetRelacion_VACommand(relacionEntity);
            relacionCommand.execute();

            if (relacionCommand.getReturnParam() != null)
                relacionDto = Relacion_VAMapper.mapEntityToDto(relacionCommand.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No existe ningun atacante con el id" + incidentId + " de la relacion_va")).build();

            //obtener las zonas seguras de la la victima

            zonaEntity = Zona_SeguraMapper.mapDtoToEntityUsuarioId(relacionDto.get_usuario_victima().getId()); // Aqui obtengo del relacion la victima y luego su id de user
            zonaCommand = CommandFactory.createGetZona_SeguraByVictimaCommand(zonaEntity);
            zonaCommand.execute();

            if (zonaCommand.getReturnParam() != null)
                zonaDto = Zona_SeguraMapper.mapEntityListToDtoList(zonaCommand.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No existe ninguna zona segura asociado al id" + relacionDto.get_usuario_victima().getId() +" de la victima")).build();

            //obtener la ultima posicion del atacante

            attackerPositionCommand = CommandFactory.createGetPosicionAtacanteByRelacionIdCommand(relacionEntity);
            attackerPositionCommand.execute();

            if (attackerPositionCommand.getReturnParam() != null) {
                historyDto = Historico_UsuarioMapper.mapEntityToDto(attackerPositionCommand.getReturnParam());
            } else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se puede calcular la distacia de separacion con el id " + incidentId + " de la relacion")).build();

            //obtener todas las coordenadas de la bbdd

            coordenadaCommand = CommandFactory.createGetAllCoordenadaCommand();
            coordenadaCommand.execute();
            coordenadaDto = CoordenadaMapper.mapEntityListToDtoList(coordenadaCommand.getReturnParam());

            if (coordenadaDto.size() == 0) {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("La base de datos esta vacia")).build();
            }

            //operacion de determinar si atacante esta en zona segura

           resultDto = new DeterminarAtacanteZonaSeguraDto().AtacanteDentroZonaSegura(historyDto, zonaDto,coordenadaDto);

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Ocurrio un error interno en la base de datos: " + e.getMessage())).build();
        } finally {
            if (relacionCommand != null)
                relacionCommand.closeHandlerSession();
            if (relacionCommand != null)
                relacionCommand.closeHandlerSession();
            if (attackerPositionCommand != null)
                attackerPositionCommand.closeHandlerSession();
            if (coordenadaCommand != null)
                coordenadaCommand.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(resultDto, "la informacion se ha obtenido correctamente")).build();
    }

}
