package com.alkemy.disney.disney.repository.specifications;

import com.alkemy.disney.disney.dto.CharacterFilterDTO;
import com.alkemy.disney.disney.entity.CharacterEntity;
import org.springframework.data.jpa.domain.Specification;

public class CharacterSpecification {

    public Specification<CharacterEntity> getByFilters(CharacterFilterDTO characterDTO){
        return null;
        /*
            return(root,query,criteriaBuilder)->{
                List<Predicate> predicates = new ArrayList<>();

                if(StringUtils.hasLength(characterDTO.getName()){
                        predicates.add(
                                criteriaBuilder.like(
                                        criteriaBuilder.lower(root.get("denominacion")),
                                        "%"+characterDTO.getName().toLowerCase()+"%"
                                )
                        );
                }





            }
         */
    }
}
