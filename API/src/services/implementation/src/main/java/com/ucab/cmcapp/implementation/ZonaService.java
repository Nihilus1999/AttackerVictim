package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Zona_Segura;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.zona_segura.atomic.GetZonaByVictimaIdCommand;
import com.ucab.cmcapp.logic.commands.zona_segura.composite.*;
import com.ucab.cmcapp.logic.dtos.dtos.Zona_SeguraDto;
import com.ucab.cmcapp.logic.mappers.Zona_SeguraMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/zona_segura")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ZonaService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(ZonaService.class);

    /**
     * Obtiene una zona segura por su ID.
     *
     * @param zonasId ID de la zona segura a buscar.
     * @return Objeto Response con la información de la zona segura encontrada.
     */
    @GET
    @Path("/{id}")
    public Response getZonas(@PathParam("id") long zonasId) {
        Zona_Segura entity;
        Zona_SeguraDto responseDTO = null;
        GetZonaCommand command = null;

        _logger.debug( "Tomando de ZonaService.getZonas" );

        try {
            entity = Zona_SeguraMapper.mapDtoToEntity(zonasId);
            command = CommandFactory.createGetZona_SeguraCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = Zona_SeguraMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El ID " + zonasId + " de la zona segura no existe en la BBDD ")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno en la ruta ID " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando ZonaService.getZonas" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El ID " + zonasId + " de la zona segura ha sido encontrado correctamente")).build();
    }

    /**
     * Obtiene todas las zonas seguras.
     *
     * @return Objeto Response con la lista de todas las zonas seguras encontradas.
     */
    @GET
    @Path("/todos")
    public Response getAllZonas() {
        List <Zona_SeguraDto> responseDTO = null;
        GetAllZonaCommand command = null;

        _logger.debug( "Tomando de ZonaService.getAllZonas" );

        try {
            command = CommandFactory.createGetAllZona_SeguraCommand();
            command.execute();
            responseDTO = Zona_SeguraMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.size() == 0) {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("La base de datos esta vacia")).build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno al ejecutar la ruta todos: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando ZonaService.getAllZonas" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "Todos las zonas seguras se han obtenido correctamente")).build();
    }

    /**
     * Obtiene todas las zonas seguras asociadas a una víctima por su ID.
     *
     * @param victimaId ID de la víctima.
     * @return Objeto Response con la lista de zonas seguras asociadas a la víctima.
     */
    @GET
    @Path("victima/{victima_id}")
    public Response getAllZonasByVictimaId(@PathParam("victima_id") long victimaId) {
        Zona_Segura entity;
        List<Zona_SeguraDto> responseDTO = null;
        GetZonaByVictimaIdCommand command = null;

        _logger.debug( "Tomando de ZonaService.getAllZonasByVictimaId" );

        try {
            entity = Zona_SeguraMapper.mapDtoToEntityUsuarioId(victimaId);
            command = CommandFactory.createGetZona_SeguraByVictimaCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = Zona_SeguraMapper.mapEntityListToDtoList(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No hay zona segura asociada al ID " + victimaId + " de la victima")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de ejecutar la ruta id usuario" + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando de ZonaService.getAllZonasByVictimaId" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La zonas seguras de la victima con el ID " + victimaId + " se han obtenido correctamente")).build();
    }

    /**
     * Agrega una nueva zona segura.
     *
     * @param zonasSegurasDto Objeto con los datos de la zona segura a agregar.
     * @return Objeto Response con la información de la zona segura agregada.
     */
    @POST
    public Response addZonas(Zona_SeguraDto zonasSegurasDto) {
        Zona_Segura entity;
        Zona_SeguraDto responseDTO = null;
        CreateZonaCommand command = null;

        _logger.debug( "Tomando de ZonaService.addZonas" );

        try {
            entity = Zona_SeguraMapper.mapDtoToEntity(zonasSegurasDto);
            command = CommandFactory.createCreateZona_SeguraCommand(entity);
            command.execute();
            responseDTO = Zona_SeguraMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de registrar una zona segura", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando de ZonaService.addZonas" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La zona segura ha sido creado correctamente")).build();
    }

    /**
     * Elimina una zona segura por su ID.
     *
     * @param zonasId ID de la zona segura a eliminar.
     * @return Objeto Response con la información de la zona segura eliminada.
     */
    @DELETE
    @Path("/{id}")
    public Response deleteZonas(@PathParam("id") long zonasId) {
        Zona_Segura entity;
        Zona_SeguraDto responseDTO = null;
        DeleteZonaCommand command = null;

        _logger.debug( "Tomando de ZonaService.DeleteZonas" );

        try {
            entity = Zona_SeguraMapper.mapDtoToEntity(zonasId);
            command = CommandFactory.createDeleteZona_SeguraCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = Zona_SeguraMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo eliminar la zona segura con ese ID")).build();


        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de eliminar una zona segura", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando de ZonaService.DeleteZonas" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La zona segura ha sido eliminado correctamente")).build();
    }

    /**
     * Actualiza una zona segura.
     *
     * @param zonasSegurasDto Objeto con los datos de la zona segura a actualizar.
     * @return Objeto Response con la información de la zona segura actualizada.
     */
    @PUT
    public Response updateZonas(Zona_SeguraDto zonasSegurasDto) {
        Zona_Segura entity;
        Zona_SeguraDto responseDTO = null;
        UpdateZonaCommand command = null;

        _logger.debug( "Tomando de ZonaService.UpdateZonas" );

        try {
            entity = Zona_SeguraMapper.mapDtoToEntity(zonasSegurasDto);
            command = CommandFactory.createUpdateZona_SeguraCommand(entity);
            command.execute();
            if (command.getReturnParam() != null)
                responseDTO = Zona_SeguraMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo editar el ID: " + zonasSegurasDto.getId()) + " debido a que no existe en la base de datos").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al actualizar la zona segura: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        _logger.debug( "Dejando de ZonaService.UpdateZonas" );

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La zona segura con el ID " + zonasSegurasDto.getId() + " se actualizo correctamente")).build();
    }
}
