package br.com.aula.rest.resources;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.aula.dao.ContatoDao;
import br.com.aula.model.Contato;
import br.com.aula.service.ContatoService;

@Path("/contatos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class ContatoResource {

	@Inject
	private ContatoService contatoService;
	
	@GET
	public List<Contato> getContatos(){
		return contatoService.findAll();
	}
	
	@GET
	@Path("{id}")
	public Contato getContato(@PathParam("id") long id) {
		return contatoService.findById(id);
	}
	
	@POST
	public Response salvar(Contato contato) {
		contatoService.save(contato);
		
		return Response.status(Status.CREATED).entity(contato).build();
	}
	
}
