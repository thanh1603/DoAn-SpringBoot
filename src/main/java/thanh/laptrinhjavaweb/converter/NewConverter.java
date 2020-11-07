package thanh.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import thanh.laptrinhjavaweb.dto.NewDTO;
import thanh.laptrinhjavaweb.entity.NewEntity;

@Component // su dung co che dependence cho  1 class 

public class NewConverter {
	public NewEntity toEntity(NewDTO dto) {
		NewEntity entity = new NewEntity();
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setShortDescription(dto.getShortDescription());
		entity.setThumbnail(dto.getThumbnail());
		
		return entity;
	}
	
	public NewDTO toDTO(NewEntity entity) {
		NewDTO dto = new NewDTO();
		if (entity.getId() !=null) {
			dto.setId(entity.getId());
		}

		dto.setTitle(entity.getTitle());
		dto.setContent(entity.getContent());
		dto.setShortDescription(entity.getShortDescription());
		dto.setThumbnail(entity.getThumbnail());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		dto.setModifiedBy(entity.getModifiedBy());
		
		return dto;
	}
	
	public NewEntity toEntity(NewDTO dto, NewEntity entity) {
	
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		entity.setShortDescription(dto.getShortDescription());
		entity.setThumbnail(dto.getThumbnail());
		
		return entity;
	}
}
