package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Relacion_VA;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.relacion_VA.atomic.GetPosicionByRelacionIDCommand;
import com.ucab.cmcapp.logic.dtos.dtos.Historico_UsuarioDto;
import com.ucab.cmcapp.logic.dtos.utilities.calcularDistanciaSeparacionDto;
import com.ucab.cmcapp.logic.mappers.Historico_UsuarioMapper;
import com.ucab.cmcapp.logic.mappers.Relacion_VAMapper;
import com.ucab.cmcapp.logic.commands.CommandFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/operaciones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OperacionesService extends BaseService {
    @GET
    @Path("distancia-separacion/{id_relacion_va}")
    public Response getSeparationDistanceByIncidentId(@PathParam("id_relacion_va") long relacionId) {
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
                distanciaSeparacion = new calcularDistanciaSeparacionDto().calcularDistanciaSeperacion2(responseDTO.get(0), responseDTO.get(1));

            } else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("[GENERAL EXCEPTION] Could not calculate the separation distance with incident id: " + relacionId)).build();
        } catch (Exception e) {

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("[GENERAL EXCEPTION] at method getSeparationDistanceByIncidentId: " + e.getMessage())).build();

        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(distanciaSeparacion, "La distancia es menor a la minima establecida, por lo tanto la victima esta cerca de la victima" + relacionId)).build();

    }
}
