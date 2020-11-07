package thanh.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import thanh.laptrinhjavaweb.converter.NewConverter;
import thanh.laptrinhjavaweb.dto.NewDTO;
import thanh.laptrinhjavaweb.entity.CategoryEntity;
import thanh.laptrinhjavaweb.entity.NewEntity;
import thanh.laptrinhjavaweb.repository.CategoryReposytory;
import thanh.laptrinhjavaweb.repository.NewRepository;
import thanh.laptrinhjavaweb.service.INewService;

@Service
public class NewService implements INewService{
	
	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private CategoryReposytory categoryRepository;
	
	@Autowired
	private NewConverter newConverter;
	
	

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if (newDTO.getId() != null ) {
			NewEntity oldNewEntity = newRepository.findOne(newDTO.getId());
			newEntity = newConverter.toEntity(newDTO, oldNewEntity);
		}else {
			newEntity = newConverter.toEntity(newDTO);
		}
		//NewEntity newEntity = newConverter.toEntity(newDTO);
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}



	@Override
	public void delete(long[] ids) {
		
		try {
			for( long item: ids) {
				newRepository.delete(item);
			}
		} catch (Exception e) {
			
		}
		
		
	}



	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll(pageable).getContent();
		for (NewEntity item: entities) {
			NewDTO newDTO = newConverter.toDTO(item);
			results.add(newDTO);
		}
		return results;
	}



	@Override
	public int totalItem() {
		return (int) newRepository.count();
	}



	@Override
	public List<NewDTO> findAll() {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll();
		for (NewEntity item: entities) {
			NewDTO newDTO = newConverter.toDTO(item);
			results.add(newDTO);
		}
		return results;
	}



//	@Override
//	public NewDTO update(NewDTO newDTO) {
//		NewEntity oldNewEntity = newRepository.findOne(newDTO.getId());
//		NewEntity newEntity = newConverter.toEntity(newDTO, oldNewEntity);
//		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
//		newEntity.setCategory(categoryEntity);
//		newEntity = newRepository.save(newEntity);
//		return newConverter.toDTO(newEntity);
//	}
	
}
