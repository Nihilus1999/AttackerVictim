package com.ucab.cmcapp.common.exceptions.mappers;


import com.ucab.cmcapp.common.exceptions.FaultBean;
import com.ucab.cmcapp.common.exceptions.FindAllException;
import com.ucab.cmcapp.properties.Registry;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class FindAllExceptionMapper implements ExceptionMapper<FindAllException> {
    @Override
    public Response toResponse(FindAllException exception) {
        try{
            FaultBean faultBean = new FaultBean(Registry.getInstance().getProperty(Registry.EXC_FINDALLDB_CODE),
                    Registry.getInstance().getProperty(Registry.EXC_FINDALLDB_MSG),
                    exception.getMessage());

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(faultBean).build();
        }catch (NullPointerException e){
            return null;
        }
    }
}
