package br.unitins.tp1.irondragon.resource;

import br.unitins.tp1.irondragon.dto.request.AuthRequestDTO;
import br.unitins.tp1.irondragon.dto.response.usuario.UsuarioResponseDTO;
import br.unitins.tp1.irondragon.model.usuario.Usuario;
import br.unitins.tp1.irondragon.service.hash.HashService;
import br.unitins.tp1.irondragon.service.jwt.JwtService;
import br.unitins.tp1.irondragon.service.usuario.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    private static final Logger LOGGER = Logger.getLogger(AuthResource.class);

    @Inject
    HashService hashService;

    @Inject
    UsuarioService usuarioService;

    @Inject
    JwtService jwtService;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(AuthRequestDTO authDTO) {
        String hash = hashService.getHashSenha(authDTO.senha());

        Usuario usuario = usuarioService.findByUsernameAndSenha(authDTO.username(), hash);

        if (usuario == null) {
            return Response.status(Response.Status.NO_CONTENT)
                    .entity("Usuario não encontrado").build();
        }

        LOGGER.info("Cliente " + usuario.getUsername() + " logou no sistema!");

        return Response.ok()
                .header("Authorization", jwtService.generateJwt(UsuarioResponseDTO.valueOf(usuario)))
                .build();

    }

}
