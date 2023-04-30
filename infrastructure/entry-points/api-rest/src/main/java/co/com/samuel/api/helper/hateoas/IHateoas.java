package co.com.samuel.api.helper.hateoas;

import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

public interface IHateoas {

    static <T> PagedModel<EntityModel<T>> addPaginationLinks(Page<T> page){
        PagedResourcesAssembler<T> pagedResourcesAssembler = new PagedResourcesAssembler<>(null, null);
        return pagedResourcesAssembler.toModel(page);
    }

}
