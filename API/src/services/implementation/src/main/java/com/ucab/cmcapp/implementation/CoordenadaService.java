/**
 * Clase que implementa los servicios relacionados con las coordenadas.
 */
package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.coordenada.atomic.GetCoordenadaByZonaIdCommand;
import com.ucab.cmcapp.logic.commands.coordenada.composite.*;
import com.ucab.cmcapp.logic.dtos.dtos.CoordenadaDto;
import com.ucab.cmcapp.logic.mappers.CoordenadaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/coordenadas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoordenadaService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(CoordenadaService.class);

    /**
     * Obtiene una coordenada por su ID.
     *
     * @param coordenadaId el ID de la coordenada a obtener.
     * @return una respuesta HTTP con la coordenada obtenida o un mensaje de error si no existe.
     */
    @GET
    @Path("/{id}")
    public Response getCoordenada(@PathParam("id") long coordenadaId) {
        Coordenada entity;
        CoordenadaDto responseDTO = null;
        GetCoordenadaCommand command = null;

        try {
            entity = CoordenadaMapper.mapDtoToEntity(coordenadaId);
            command = CommandFactory.createGetCoordenadaCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = CoordenadaMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El ID " + coordenadaId + " de coordenada no existe en la BBDD ")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno en la ruta ID " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El ID " + coordenadaId + " de la coordenada ha sido encontrado correctamente")).build();
    }

    /**
     * Obtiene todas las coordenadas.
     *
     * @return una respuesta HTTP con la lista de coordenadas obtenidas o un mensaje si la base de datos está vacía.
     */
    @GET
    @Path("/todos")
    public Response getAllCoordenada() {
        List<CoordenadaDto> responseDTO = null;
        GetAllCoordenadaCommand command = null;

        try {
            command = CommandFactory.createGetAllCoordenadaCommand();
            command.execute();
            responseDTO = CoordenadaMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.size() == 0) {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("La base de datos esta vacia ")).build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno al ejecutar la ruta todos: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "Las coordenadas se han obtenido correctamente")).build();
    }

    /**
     * Obtiene las coordenadas de una zona segura por su ID.
     *
     * @param zonaId el ID de la zona segura.
     * @return una respuesta HTTP con la lista de coordenadas obtenidas o un mensaje de error si no hay coordenadas asociadas.
     */
    @GET
    @Path("zona_segura/{zona_id}")
    public Response getAllZonasByUsuarioId(@PathParam("zona_id") long zonaId) {
        Coordenada entity;
        List<CoordenadaDto> responseDTO = null;
        GetCoordenadaByZonaIdCommand command = null;

        try {
            entity = CoordenadaMapper.mapDtoToEntityZonaId(zonaId);
            command = CommandFactory.createGetCoordenadaByZonaCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = CoordenadaMapper.mapEntityListToDtoList(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No hay coordenada asociada alID " + zonaId + " de la zona segura")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de ejecutar la ruta id zona" + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La coordenadas de la zona segura con el ID " + zonaId + " se han obtenido correctamente")).build();
    }

    /**
     * Agrega una nueva coordenada.
     *
     * @param coordenadaDto el objeto CoordenadaDto que representa la coordenada a agregar.
     * @return una respuesta HTTP con la coordenada agregada o un mensaje de error en caso de fallo.
     */
    @POST
    public Response addCoordenada(CoordenadaDto coordenadaDto) {
        Coordenada entity;
        CoordenadaDto responseDTO = null;
        CreateCoordenadaCommand command = null;

        try {
            entity = CoordenadaMapper.mapDtoToEntity(coordenadaDto);
            command = CommandFactory.createCreateCoordenadaCommand(entity);
            command.execute();
            responseDTO = CoordenadaMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de registrar una coordenada", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La coordenada ha sido creado correctamente")).build();
    }


    /**
     * Elimina una coordenada por su ID.
     *
     * @param coordenadaId el ID de la coordenada a eliminar.
     * @return una respuesta HTTP con la coordenada eliminada o un mensaje de error si no se pudo eliminar.
     */
    @DELETE
    @Path("/{id}")
    public Response deleteCoordenada(@PathParam("id") long coordenadaId) {
        Coordenada entity;
        CoordenadaDto responseDTO = null;
        DeleteCoordenadaCommand command = null;

        try {
            entity = CoordenadaMapper.mapDtoToEntity(coordenadaId);
            command = CommandFactory.createDeleteCoordenadaCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = CoordenadaMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo eliminar la coordenada con ese ID")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de eliminar una coordenada", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La coordenada ha sido eliminada correctamente")).build();
    }

    /**
     * Actualiza una coordenada existente.
     *
     * @param coordenadaDto el objeto CoordenadaDto que representa la coordenada actualizada.
     * @return una respuesta HTTP con la coordenada actualizada o un mensaje de error si no se pudo editar.
     */
    @PUT
    public Response updateCoordenada(CoordenadaDto coordenadaDto) {
        Coordenada entity;
        CoordenadaDto responseDTO = null;
        UpdateCoordenadaCommand command = null;

        try {
            entity = CoordenadaMapper.mapDtoToEntity(coordenadaDto);
            command = CommandFactory.createUpdateCoordenadaCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = CoordenadaMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo editar el ID: " + coordenadaDto.getId()) + " debido a que no existe en la base de datos").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al actualizar la coordenada: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La coordenada con el ID " + coordenadaDto.getId() + " se actualizó correctamente")).build();
    }
}
