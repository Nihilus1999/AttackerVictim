package com.ucab.cmcapp.implementation;

import com.ucab.cmcapp.common.entities.Usuario_Victima;
import com.ucab.cmcapp.common.util.CustomResponse;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario_victima.composite.*;
import com.ucab.cmcapp.logic.dtos.dtos.Usuario_VictimaDto;
import com.ucab.cmcapp.logic.mappers.Usuario_VictimaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Clase que implementa los servicios REST para las operaciones relacionadas con las víctimas.
 */
@Path("/victima")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VictimaService extends BaseService {
    private static Logger _logger = LoggerFactory.getLogger(VictimaService.class);

    /**
     * Obtiene una víctima por su ID.
     *
     * @param victimaId ID de la víctima a obtener.
     * @return Respuesta HTTP con el objeto Usuario_VictimaDto correspondiente al ID proporcionado.
     */
    @GET
    @Path("/{id}")
    public Response getVictima(@PathParam("id") long victimaId) {
        Usuario_Victima entity;
        Usuario_VictimaDto responseDTO = null;
        GetVictimaCommand command = null;

        try {
            entity = Usuario_VictimaMapper.mapDtoToEntity(victimaId);
            command = CommandFactory.createGetUsuario_VictimaCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = Usuario_VictimaMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("El ID " + victimaId + " de la víctima no existe en la BBDD ")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno en la ruta ID " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "El ID " + victimaId + " de la víctima ha sido encontrado correctamente")).build();
    }

    /**
     * Obtiene todas las víctimas.
     *
     * @return Respuesta HTTP con una lista de objetos Usuario_VictimaDto.
     */
    @GET
    @Path("/todos")
    public Response getAllVictima() {
        List<Usuario_VictimaDto> responseDTO = null;
        GetAllVictimaCommand command = null;

        try {
            command = CommandFactory.createGetAllUsuario_VictimaCommand();
            command.execute();
            responseDTO = Usuario_VictimaMapper.mapEntityListToDtoList(command.getReturnParam());

            if (responseDTO.size() == 0) {
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("La base de datos está vacía ")).build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>(e, "Error interno al ejecutar la ruta todas las víctimas: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "Todos las víctimas se han obtenido correctamente")).build();
    }

    /**
     * Agrega una nueva víctima.
     *
     * @param historicoUsuarioDto Objeto Usuario_VictimaDto a agregar.
     * @return Respuesta HTTP con el objeto Usuario_VictimaDto creado.
     */
    @POST
    public Response addVictima(Usuario_VictimaDto historicoUsuarioDto) {
        Usuario_Victima entity;
        Usuario_VictimaDto responseDTO = null;
        CreateVictimaCommand command = null;

        try {
            entity = Usuario_VictimaMapper.mapDtoToEntity(historicoUsuarioDto);
            command = CommandFactory.createCreateUsuario_VictimaCommand(entity);
            command.execute();
            responseDTO = Usuario_VictimaMapper.mapEntityToDto(command.getReturnParam());
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de registrar una víctima", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La víctima ha sido creado correctamente")).build();
    }

    /**
     * Elimina una víctima por su ID.
     *
     * @param victimaId ID de la víctima a eliminar.
     * @return Respuesta HTTP con el objeto Usuario_VictimaDto eliminado.
     */
    @DELETE
    @Path("/{id}")
    public Response deleteVictima(@PathParam("id") long victimaId) {
        Usuario_Victima entity;
        Usuario_VictimaDto responseDTO = null;
        DeleteVictimaCommand command = null;

        try {
            entity = Usuario_VictimaMapper.mapDtoToEntity(victimaId);
            command = CommandFactory.createDeleteUsuario_VictimaCommand(entity);
            command.execute();

            if (command.getReturnParam() != null)
                responseDTO = Usuario_VictimaMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo eliminar la víctima con ese ID")).build();


        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al momento de eliminar una víctima", e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }

        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La víctima ha sido eliminado correctamente")).build();
    }

    /**
     * Actualiza una víctima.
     *
     * @param usuarioVictimaDto Objeto Usuario_VictimaDto con los datos actualizados.
     * @return Respuesta HTTP con el objeto Usuario_VictimaDto actualizado.
     */
    @PUT
    public Response updateVictima(Usuario_VictimaDto usuarioVictimaDto) {
        Usuario_Victima entity;
        Usuario_VictimaDto responseDTO = null;
        UpdateVictimaCommand command = null;
        try {
            entity = Usuario_VictimaMapper.mapDtoToEntity(usuarioVictimaDto);
            command = CommandFactory.createUpdateUsuario_VictimaCommand(entity);
            command.execute();
            if (command.getReturnParam() != null)
                responseDTO = Usuario_VictimaMapper.mapEntityToDto(command.getReturnParam());
            else
                return Response.status(Response.Status.OK).entity(new CustomResponse<>("No se pudo editar el ID: " + usuarioVictimaDto.getId()) + " debido a que no existe en la base de datos").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new CustomResponse<>("Error interno al actualizar la víctima: " + e.getMessage())).build();
        } finally {
            if (command != null)
                command.closeHandlerSession();
        }
        return Response.status(Response.Status.OK).entity(new CustomResponse<>(responseDTO, "La víctima con el ID " + usuarioVictimaDto.getId() + " se actualizó correctamente")).build();
    }
}