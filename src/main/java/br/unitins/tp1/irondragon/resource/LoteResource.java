package br.unitins.tp1.irondragon.resource;

import br.unitins.tp1.irondragon.dto.request.LoteRequestDTO;
import br.unitins.tp1.irondragon.dto.response.LoteResponseDTO;
import br.unitins.tp1.irondragon.service.lote.LoteService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/lotes")
public class LoteResource {
    @Inject
    public LoteService loteService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(LoteResponseDTO.valueOf(loteService.findById(id))).build();
    }

    @GET
    @Path("/search/{codigo}")
    public Response findByCodigo(@PathParam("codigo") String codigo) {
        return Response.ok(LoteResponseDTO.valueOf(loteService.findByCodigo(codigo))).build();
    }

    @POST
    public Response create(@Valid LoteRequestDTO dto) {
        return Response.status(Response.Status.CREATED).entity(LoteResponseDTO.valueOf(loteService.create(dto))).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid LoteRequestDTO dto) {
        loteService.update(id, dto);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        loteService.delete(id);
        return Response.noContent().build();
    }
}
