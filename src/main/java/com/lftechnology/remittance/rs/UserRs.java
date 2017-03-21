package com.lftechnology.remittance.rs;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.lftechnology.remittance.Resources;
import com.lftechnology.remittance.annotations.TenantEm;
import com.lftechnology.remittance.entity.User;
import com.lftechnology.remittance.enums.PCUnitName;
import com.lftechnology.remittance.exception.ObjectNotFoundException;
import com.lftechnology.remittance.service.UserService;

/**
 * @author Achyut Pokhrel <achyutpokhrel@lftechnology.com>
 */
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserRs {

	@Inject
	Resources entityManagerFactory;

	@Inject
	@TenantEm
	Event<EntityManager> tenantBaseEM;

	@Inject
	private UserService userService;

	@GET
	@Path("/")
	public Response list() {

		EntityManager entityManager;
		entityManager = entityManagerFactory.createEntityManger(PCUnitName.DB2);
		tenantBaseEM.fire(entityManager);
		List<User> users = new ArrayList<>();
		users.addAll(userService.findByFilter());

		entityManager = entityManagerFactory.createEntityManger(PCUnitName.DB1);
		tenantBaseEM.fire(entityManager);
		users.addAll(userService.findByFilter());
		return Response.status(Response.Status.OK).entity(users).build();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(@NotNull(message = "Request body expected") @Valid User user, @Context HttpHeaders headers) {
		fireEntityManager(headers);
		return Response.status(Status.OK).entity(userService.save(user)).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") UUID id, @NotNull(message = "Request body expected") @Valid User user, @Context HttpHeaders headers) {
		fireEntityManager(headers);
		return Response.status(Response.Status.OK).entity(userService.merge(id, user)).build();
	}

	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") UUID id, @Context HttpHeaders headers) {
		fireEntityManager(headers);
		User user = userService.findById(id);
		if (user != null) {
			return Response.status(Response.Status.OK).entity(user).build();
		} else {
			throw new ObjectNotFoundException();
		}
	}

	@DELETE
	@Path("/{id}")
	public Response remove(@javax.ws.rs.PathParam("id") UUID id, @Context HttpHeaders headers) {
		fireEntityManager(headers);
		userService.removeById(id);
		return Response.status(Response.Status.OK).build();
	}


	private void fireEntityManager(HttpHeaders headers){
		EntityManager entityManager;
		List<String> tenants = headers.getRequestHeader("tenant");
		if(!tenants.isEmpty()){
			if(tenants.get(0).equals("Tenant1")){
				entityManager = entityManagerFactory.createEntityManger(PCUnitName.DB1);
			}else{
				entityManager = entityManagerFactory.createEntityManger(PCUnitName.DB2);
			}
			tenantBaseEM.fire(entityManager);
		}else{
			tenantBaseEM.fire(entityManagerFactory.createEntityManger(PCUnitName.DB1));
		}

	}
}
